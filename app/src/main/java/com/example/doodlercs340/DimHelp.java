package com.example.doodlercs340;

import android.content.Context;
import android.util.DisplayMetrics;

public class DimHelp {
    private Context context;
    private static DimHelp instance = null;

    private DimHelp(Context context) {
        this.context = context;
    }

    public static DimHelp getInstance(Context context) {
        if (instance == null) {
            instance = new DimHelp(context);
        }
        return instance;
    }

    public int dpToPx(float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public int pxToDp(float px) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
