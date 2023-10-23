package com.example.doodlercs340;

import static java.lang.Double.min;
import static java.lang.Math.abs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LineView extends DrawView{

    private Point p1;
    private Point p2;

    public LineView(@NonNull Context context, Point p1, Point p2) {
        super(context);
        this.p1 = p1;
        this.p2 = p2;
        float width = abs(p2.x - p1.x);
        float height = abs(p2.y - p1.y);
        Log.d("CSE340", "LineView width: " + width);
        Log.d("CSE340", "LineView height: " + height);
        if (width == 0) width = DimHelp.getInstance(context).pxToDp(brush_width);
        if (height == 0) height = DimHelp.getInstance(context).pxToDp(brush_width);
        float x = (float) min(p1.x, p2.x);
        float y = (float) min(p1.y, p2.y);
        initFromParentCoordsPX(dimHelp.pxToDp(x),dimHelp.pxToDp(y),dimHelp.pxToDp(width),dimHelp.pxToDp(height));
        Log.d("CSE340", "LineView width: " + dimHelp.pxToDp(width));
        Log.d("CSE340", "LineView height: " + dimHelp.pxToDp(height));
    }

    public LineView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = getBrush(Paint.Style.STROKE);
        Log.d("CSE340", "onDraw: " + getWidth());
        Log.d("CSE340", "onDraw: " + getHeight());
        canvas.drawLine(0,0,abs(p2.x - p1.x),abs(p2.y - p1.y),p);
    }
}
