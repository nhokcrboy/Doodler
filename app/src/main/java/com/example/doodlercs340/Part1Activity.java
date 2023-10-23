package com.example.doodlercs340;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Part1Activity extends AbstractMainActivity {
    DimHelp dimHelp = DimHelp.getInstance(this);
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Finds View from UI layout to add content onto it.
        FrameLayout doodleView = findViewById(R.id.doodleView);
        BottomNavigationView nav = findViewById(R.id.bottom_nav);   // Tabs at the bottom of screen.

        doodleView.removeAllViews();  // Clear the currently displayed view.

        // Register callback on item selected. This is called each time a tab is pressed.

        // Set tab contents based on selected item.
        nav.setOnItemSelectedListener((item) -> {
            int id = item.getItemId();
            if (id == screen_1) {
                Log.i("CSE340", "You are already in Part 1");
                return true;
            } else if (id == screen_2) {
                setCurrentTabId(R.id.action_part_2);
                Log.i("CSE340", "Switching to Part 2");
                startActivity(new Intent(getBaseContext(), Part2Activity.class));
                overridePendingTransition(0,0);
                return true;
            } else {
                Log.e("CSE340", "Unrecognized nav item selected: " + item.getTitle());
            }
            return false;
        });

        // Show which tab has been selected
        nav.setSelectedItemId(getSavedTabId(savedInstanceState, R.id.action_part_1));

        // Show
        doodle(doodleView);
    }


    @Override
    public void doodle(FrameLayout doodleView) {
        // Adds all images as a heart collage.
        addAllImagesFromData(doodleView);
        Log.d("CSE340", "PHONE_DIMS: " + PHONE_DIMS.x);
        Log.d("CSE340", "PHONE_DIMS: " + PHONE_DIMS.y);

        TextView textView = new TextView(this, PHONE_DIMS_DP.x/2 - dimHelp.getTextWidthFromTextSize(50,"CSE340") / 2, PHONE_DIMS_DP.y/4, "CSE340", 50);
        textView.setColor(0xFFCD853F);
        LineView lineView = new LineView(this, new Point(0, PHONE_DIMS.y/4*3), new Point(PHONE_DIMS.x, PHONE_DIMS.y/4*3));
        lineView.setColor(0xFF8470FF);
        lineView.setBrush_width(50f);
        float radius[] = {25, 50, 75};
        CircleView circleView[] = new CircleView[3];

        for (int i = 0; i < 3; i++) {
            circleView[i] = new CircleView(this, PHONE_DIMS_DP.x/2 - radius[i], PHONE_DIMS_DP.y/4*3 - radius[i], radius[i]);
            doodleView.addView(circleView[i]);
        }

        TextView UW = new TextView(this ,0,PHONE_DIMS_DP.y/4*3 - dimHelp.getTextHeightFromTextSize(50), "UW", 50);
        UW.setColor(0xFFCD853F);

        doodleView.addView(textView);
        doodleView.addView(lineView);
        doodleView.addView(UW);

        ObjectAnimator animator = ObjectAnimator.ofFloat(UW,"translationX",0f,PHONE_DIMS.x - dimHelp.dpToPx(dimHelp.getTextWidthFromTextSize(50,"UW")));
        animator.setDuration(1000);
        animator.start();
    }
}
