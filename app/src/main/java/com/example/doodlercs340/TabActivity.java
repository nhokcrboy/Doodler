package com.example.doodlercs340;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A type of activity which provides a getter and setter for persistent storage
 * of an integer across the application lifecycle via Bundle. Convenient to store
 * current tab view ID.
 */

public class TabActivity extends AppCompatActivity {
    // Key used to save the current tab id so we can restore it later
    protected static final String CURRENT_TAB_ID_KEY = "ACTIVITY_TAB_ID";

    private int tabId = -1; // The current tab we are showing

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_TAB_ID_KEY, tabId); // Save which tab we are currently on
    }

    /*
     * Get the id of the tab we were on before
     */
    protected int getSavedTabId(Bundle state, int defaultVal) {
        if (state == null) {
            return defaultVal;
        }
        return state.getInt(CURRENT_TAB_ID_KEY, defaultVal);
    }

    /**
     * Sets the current tab
     *
     * @param id The id of the current tab
     */
    protected final void setCurrentTabId(int id) {
        tabId = id;
    }
}
