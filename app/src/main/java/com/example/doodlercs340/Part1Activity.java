package com.example.doodlercs340;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Part1Activity extends AbstractMainActivity {
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

        // To allow this to run on multiple screen sizes, we scale all of our coordinate values
        // using scaleX and scaleY. For a more efficient way to do this, see EX2 Layout.


        // TODO: Do your animation with the UW text view here! It's stored in the "uw" variable.
    }
}
