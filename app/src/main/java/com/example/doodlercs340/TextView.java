package com.example.doodlercs340;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextView extends DrawView {
        private String Text;
        private float text_size;
        private DimHelp dimHelp = DimHelp.getInstance(getContext());

        public TextView(@NonNull Context context, float x, float y, String Text, float text_size, float width) {
                super(context);
                initFromParentCoordsPX(x, y, width, getHeightFromTextSize(text_size));
                this.Text = Text;
                this.text_size = dimHelp.dpToPx(text_size);
        }

        public TextView(@NonNull Context context, @Nullable AttributeSet attrs) {
                super(context, attrs);
        }

        public TextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                Paint p = getBrush(text_size, Color.BLACK);
//                Log.d("CSE340", "onDraw: " + getHeight());
//                Log.d("CSE340", "onDraw: " + this.Text);
//                Log.d("CSE340", "onDraw: " + this.text_size);
                canvas.drawText(this.Text, 0, text_size, p);
        }

        private float getHeightFromTextSize(float textSize) {
                Paint p = new Paint();
                p.setTextSize(dimHelp.dpToPx(textSize));
                Paint.FontMetrics fm = p.getFontMetrics();
                return fm.descent - fm.ascent;
        }
}
