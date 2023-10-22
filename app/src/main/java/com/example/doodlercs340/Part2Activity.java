package com.example.doodlercs340;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Part2Activity extends AbstractMainActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Finds View from UI layout to add content onto it.
        FrameLayout doodleView = findViewById(R.id.doodleView);
        BottomNavigationView nav = findViewById(R.id.bottom_nav);   // Tabs at the bottom of screen.

        doodleView.removeAllViews();  // Clear the currently displayed view.

        // Register callback on item selected. This is called each time a tab is pressed.
        nav.setOnItemSelectedListener((item) -> {
            int id = item.getItemId();
            if (id == screen_1) {
                setCurrentTabId(R.id.action_part_1);
                Log.i("CSE340", "Switching to Part 1");
                startActivity(new Intent(getBaseContext(), Part1Activity.class));
                overridePendingTransition(0,0);
                return true;
            } else if (id == screen_2) {
                Log.i("CSE340", "You are already in Part 2");
                return true;
            } else {
                Log.e("CSE340", "Unrecognized nav item selected: " + item.getTitle());
            }
            return false;
        });

        // Show which tab has been selected
        nav.setSelectedItemId(getSavedTabId(savedInstanceState, R.id.action_part_2));

        // Calls the doodle function to draw on doodleView.
        doodle(doodleView);
    }

    @Override
    public void doodle(FrameLayout doodleView) {
        int doodle_height = doodleView.getHeight();
        int doodle_width = doodleView.getWidth();

        CircleView circle = new CircleView(this, 0, 50, 50);
        LineView line = new LineView(this, new Point(50,100), new Point(50,200));
        TextView text = new TextView(this, 0, 0, "Hello Worlg" +
                "", 50, 500);

        doodleView.addView(circle);
        doodleView.addView(text);
        doodleView.addView(line);

    }
}
