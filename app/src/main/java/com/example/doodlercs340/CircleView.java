package com.example.doodlercs340;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircleView extends DrawView{
    private float radius;
    public CircleView(@NonNull Context context, float x, float y, float radius) {
        super(context);
        this.radius = dimHelp.dpToPx(radius);
        initFromParentCoordsPX(x,y,2*radius + dimHelp.pxToDp(brush_width),2*radius + dimHelp.pxToDp(brush_width));
    }

    public CircleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("CSE340", "onDraw radius: " + radius);
        canvas.drawCircle(getWidth()/2,getHeight()/2, radius, getBrush(Paint.Style.STROKE));
    }
}
