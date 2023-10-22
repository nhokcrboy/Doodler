package com.example.doodlercs340;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircleView extends DrawView{
    public CircleView(@NonNull Context context, float x, float y, float radius) {
        super(context);
        initFromParentCoordsPX(x,y,radius,radius);
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
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2, getBrush(Paint.Style.STROKE, Color.BLACK, 5));
    }
}
