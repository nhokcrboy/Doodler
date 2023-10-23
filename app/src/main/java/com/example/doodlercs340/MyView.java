package com.example.doodlercs340;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyView extends DrawView{

    private float x;
    private float y;
    private float radius;
    private Pair<Float, Float> center[] = new Pair[5];

    public MyView(@NonNull Context context,float x, float y, float radius) {
        super(context);
        initFromParentCoordsPX(x - radius/2, y - radius/2, radius, radius);
        this.radius = dimHelp.dpToPx(radius);
        this.x = radius;
        this.y = radius;
        SetUp();
    }

    public void SetUp() {
        center[0] = new Pair<>(x,y-radius/2);
        center[1] = new Pair<>(x + (float)(radius*cos(18)),y + (float)(radius*sin(18)));
        center[2] = new Pair<>(x - (float)(radius*cos(18)),y - (float)(radius*sin(18)));
        center[3] = new Pair<>(x + (float)(radius*cos(54)),y + (float)(radius*sin(54)));
        center[4] = new Pair<>(x - (float)(radius*cos(54)),y - (float)(radius*sin(54)));
        for (int i = 0; i < 5; i++) {
            Log.d("CSE340", "SetUp: " + center[i].first + " " + center[i].second);
        }
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                canvas.drawLine(center[i].first,center[i].second,center[j].first,center[j].second,getBrush(Paint.Style.STROKE));
            }
        }
    }
}
