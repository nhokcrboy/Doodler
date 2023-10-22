package com.example.doodlercs340;

import static java.lang.Double.min;
import static java.lang.Math.abs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LineView extends DrawView{
    public LineView(@NonNull Context context, Point p1, Point p2) {
        super(context);
        float width = abs(p2.x - p1.x);
        float height = abs(p2.y - p1.y);
        if (width == 0) width = 10f;
        if (height == 0) height = 10f;
        float x = (float) min(p1.x, p2.x);
        float y = (float) min(p1.y, p2.y);
        initFromParentCoordsPX(x,y,width,height);
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
        Paint p = getBrush(Paint.Style.STROKE, Color.BLACK, 10f);
        canvas.drawLine(0,0,getWidth(),getHeight(),p);
    }
}
