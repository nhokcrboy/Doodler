package com.example.doodlercs340;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public abstract class DrawView extends AppCompatImageView {
    protected static Paint paint = new Paint();
    private float width;
    private float height;

    public DrawView(@NonNull Context context) {
        super(context);
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Paint getBrush(Paint.Style style, int color , float width) {
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(width);
        return paint;
    }

    public Paint getBrush(float text_size,int color) {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setTextSize(text_size);
        paint.setColor(color);
        return paint;
    }

    protected void initFromParentCoordsPX(float mParentX, float mParentY, float width, float height) {
        DimHelp dimhelp = DimHelp.getInstance(getContext());
        mParentX = dimhelp.dpToPx(mParentX);
        mParentY = dimhelp.dpToPx(mParentY);
        width = dimhelp.dpToPx(width);
        height = dimhelp.dpToPx(height);
        setX(mParentX);
        setY(mParentY);
        this.width = width;
        this.height = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int)this.width, (int)this.height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
