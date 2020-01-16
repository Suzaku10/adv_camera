package com.ric.adv_camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Float width = (float) 0;
    private Float height = (float) 0;

    public CustomView(Context context) {
        super(context);
        init(null,0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(20f);
        mPaint.setColor(Color.rgb(255, 136, 0));

        mBorderPaint.setDither(true);
        mBorderPaint.setColor(Color.rgb(186, 186, 186));
        mBorderPaint.setStyle(Paint.Style.FILL);
        mBorderPaint.setStrokeWidth(2f);

        width = (float) getWidth();
        height = (float) getHeight();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = (float) w;
        height = (float) h;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = (float) this.getLayoutParams().width;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0f, 0f, width, 0f, mBorderPaint);
        canvas.drawLine(0f, 0f, 0f, height, mBorderPaint);

        canvas.drawLine(0f, height, width, height, mBorderPaint);
        canvas.drawLine(width, 0f, width, height, mBorderPaint);

        float cornerWidth = width / 5;

        canvas.drawLine(0f, 0f, cornerWidth, 0f, mPaint);
        canvas.drawLine(0f, 0f, 0f, cornerWidth, mPaint);

        canvas.drawLine(width - cornerWidth, 0f, width, 0f, mPaint);
        canvas.drawLine(width, 0f, width, cornerWidth, mPaint);

        canvas.drawLine(0f, height, cornerWidth, height, mPaint);
        canvas.drawLine(0f, height - cornerWidth, 0f, height, mPaint);

        canvas.drawLine(width - cornerWidth, height, width, height, mPaint);
        canvas.drawLine(width, height, width, height - cornerWidth, mPaint);
    }

    void setCornerColor(int cornerColor) {
        mPaint.setColor(cornerColor);
    }

}
