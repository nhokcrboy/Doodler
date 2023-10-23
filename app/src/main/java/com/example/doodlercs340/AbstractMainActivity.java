package com.example.doodlercs340;

import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class describes the requirements of a Doodler (addLine, addText, addImage) and
 * provides some convenience methods such as scaleX, scaleY, and PHONE_DIMS. I'd recommend
 * that you take a look through this class.
 *
 * @author rfrowe
 * @version 1.0
 */

public abstract class AbstractMainActivity extends TabActivity {
    protected static final int screen_1 = R.id.action_part_1;
    protected static final int screen_2 = R.id.action_part_2;
    /**
     * Current phone dimensions, for your convenience.
     * Display width is stored in PHONE_DIMS.x and height in PHONE_DIMS.y.
     */
    protected static final Point PHONE_DIMS = new Point();
    protected static final Point PHONE_DIMS_DP = new Point();

    /** Dimensions of the Pixel 2 XL. Private because you should not need these. */
    private static final Point PIXEL_DIMS = new Point(1440, 2712);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindowManager().getDefaultDisplay().getSize(PHONE_DIMS);
        PHONE_DIMS_DP.x = (int) DimHelp.getInstance(this).pxToDp(PHONE_DIMS.x);
        PHONE_DIMS_DP.y = (int) DimHelp.getInstance(this).pxToDp(PHONE_DIMS.y);

        // Sets the UI layout to this activity.
        setContentView(R.layout.activity_main);
    }

    /**
     * This is the function that does the actual doodling! It gets a doodleView and can then
     * call addLine, addImage, and addText to doodle on the it.
     *
     * @param doodleView    Canvas on which to doodle.
     */
    public abstract void doodle(FrameLayout doodleView);

    /**
     * Adds an image to the doodleView with the given position and size.
     *
     * @param doodleView    View to draw image in
     * @param imageName Filename for image in 'res/drawable'.
     * @param x Horizontal location from top left in px.
     * @param y Vertical location from top left px.
     * @param size Width and height of image on-screen in ox.
     * @return ImageView which has been added to doodleView.
     */
    public ImageView addImage(FrameLayout doodleView, String imageName, float x, float y, int size) {
        // Creates ImageView and add it to doodleView.
        ImageView imageView = new ImageView(this);
        doodleView.addView(imageView);

        Configuration configuration = getResources().getConfiguration();

        // set height - set width
        // set x - set y

//        x = scaleX(x);
//        y = scaleY(y);

        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            imageView.getLayoutParams().height = size;
            imageView.getLayoutParams().width = size;
            imageView.setX(x);
            imageView.setY(y);
        } else {
//            x = convertX(x);
//            y = convertY(y);
            imageView.getLayoutParams().height = size;
            imageView.getLayoutParams().width = size;
            imageView.setX(x);
            imageView.setY(y);
        }


        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(resID);

        return imageView;
    }

    /**
     * Scales a y coordinate from Pixel 2 XL to any phone.
     *
     * @param y Original coordinate.
     * @return Coordinate scaled to the current device screen size.
     */
    public float scaleY(float y) {
        return y * PHONE_DIMS.y / PIXEL_DIMS.y;
    }

    public float convertX(float x) {
        return x * PHONE_DIMS.y / PHONE_DIMS.x;
    }

    public float convertY(float y) {
        return y * PHONE_DIMS.x / PHONE_DIMS.y;
    }

    /**
     * Scales an x coordinate from Pixel 2 XL to any phone.
     *
     * @param x Original coordinate.
     * @return Coordinate scaled to the current device screen size.
     */
    public float scaleX(float x) {
        return x * PHONE_DIMS.x / PIXEL_DIMS.x;
    }

    public void addAllImagesFromData(FrameLayout doodleView) {
        try {
            Scanner scan = new Scanner(new InputStreamReader(getAssets().open("data.csv")));
            scan.useDelimiter("[,\n]");
            while (scan.hasNextLine()) {
                addImage(doodleView, scan.next(), scaleX(scan.nextFloat()), scaleY(scan.nextFloat()),
                        (int) scaleX(scan.nextInt()));
            }
        } catch (IOException e) {
            throw new IllegalStateException("data.csv not found in assets");
        } catch (InputMismatchException e) {
            throw new IllegalStateException("data.csv is malformed");
        }
    }
}
