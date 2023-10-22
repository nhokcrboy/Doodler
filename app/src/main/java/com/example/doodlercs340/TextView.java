package com.example.doodlercs340;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextView extends DrawView {
        public TextView(@NonNull Context context) {
                super(context);
        }

        public TextView(@NonNull Context context, @Nullable AttributeSet attrs) {
                super(context, attrs);
        }

        public TextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);
        }

        @Override
        protected void initFromParentCoordsPX() {

        }

        @Override
        protected void onDraw() {

        }
}
