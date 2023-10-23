package com.example.doodlercs340;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public abstract class DrawView extends AppCompatImageView {
    protected static Paint paint = new Paint();
    private float width;
    private float height;
    protected float brush_width = 10f;
    protected int color = Color.BLACK;

    public float getBrush_width() {
        return brush_width;
    }

    public void setBrush_width(float brush_width) {
        this.brush_width = brush_width;
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    protected DimHelp dimHelp = DimHelp.getInstance(getContext());

    public DrawView(@NonNull Context context) {
        super(context);
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Paint getBrush(Paint.Style style) {
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(brush_width);
        paint.setColor(color);
        return paint;
    }

    public Paint getBrush(float text_size) {
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
