package com.lianggekeji.circleindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Yi on 16/7/11.
 */

public class CircleIndicator extends View {
    private int mRadius;
    private int mSpace;
    private int mUnselectedColor;
    private int mSelectedColor;
    private int mPadding = 2;
    private Paint mPaint;

    private int mCount;
    private int mIndex;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.indicator);
        mRadius = (int) ta.getDimension(R.styleable.indicator_radius, dp2px(10));
        mSpace = (int) ta.getDimension(R.styleable.indicator_space, dp2px(10));
        mSelectedColor = ta.getColor(R.styleable.indicator_selectedColor, 0xcc4a4a4a);
        mUnselectedColor = ta.getColor(R.styleable.indicator_unSelectedColor, 0xeeeeeeee);
        ta.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCount <= 0) {
            return;
        }
        mPaint.setColor(mUnselectedColor);
        for (int i = 0; i < mCount ; i++) {
            canvas.drawCircle(mPadding + mRadius+mRadius * i*2 + mSpace * i
                    , mPadding + mRadius, mRadius, mPaint);
        }
        mPaint.setColor(mSelectedColor);
        canvas.drawCircle(mPadding + mRadius+mRadius * 2*mIndex + mSpace * mIndex, mPadding + mRadius, mRadius, mPaint);

    }


    public void setCount(int mCount) {
        this.mCount = mCount;
        requestLayout();
    }


    public void setIndex(int mIndex) {
        this.mIndex = mIndex;
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mCount * 2 * mRadius + mPadding * 2+(mCount > 0 ? (mCount - 1) * mSpace : 0)
                , mRadius * 2 + mPadding * 2);
    }


    private int dp2px(float value) {
        return (int) (getResources().getDisplayMetrics().density * value + 0.5);
    }
}
