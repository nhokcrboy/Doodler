package com.example.doodlercs340;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public abstract class DrawView extends AppCompatImageView {
    public DrawView(@NonNull Context context) {
        super(context);
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void getBrush() {

    }

    protected abstract void initFromParentCoordsPX();

    protected abstract void onDraw();
}
