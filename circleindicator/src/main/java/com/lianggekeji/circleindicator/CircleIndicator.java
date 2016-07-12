package com.lianggekeji.circleindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
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
    private int mMinPadding = 2;
    private Paint mPaint;

    private int mCount;
    private int mIndex;
    private int mGravity;
    private int mBarWidth;
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
        mGravity = ta.getInt(R.styleable.indicator_gravity, 0);
        ta.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec)
                , mRadius * 2 + mMinPadding * 2+getPaddingTop()+getPaddingBottom());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCount <= 0) {
            return;
        }
        canvas.save();
        int x = (getMeasuredWidth() - mBarWidth) / 2 * mGravity;
        canvas.translate(x,0);
        mPaint.setColor(mUnselectedColor);
        for (int i = 0; i < mCount; i++)
            if (i != mIndex)
                canvas.drawCircle(mMinPadding + mRadius + mRadius * i * 2 + mSpace * i+getPaddingLeft()-getPaddingRight(),
                        mMinPadding + mRadius+getPaddingTop(), mRadius, mPaint);

        mPaint.setColor(mSelectedColor);
        canvas.drawCircle(mMinPadding + mRadius + mRadius * 2 * mIndex + mSpace * mIndex+getPaddingLeft()-getPaddingRight(),
                mMinPadding + mRadius+getPaddingTop(), mRadius, mPaint);
        canvas.restore();
    }

    public void setupViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void setCount(int mCount) {
        this.mCount = mCount;
        mBarWidth = mCount * 2 * mRadius + mMinPadding * 2 + (mCount > 0 ? (mCount - 1) * mSpace : 0);
        requestLayout();
    }

    public void setIndex(int mIndex) {
        this.mIndex = mIndex;
        postInvalidate();
    }


    private int dp2px(float value) {
        return (int) (getResources().getDisplayMetrics().density * value + 0.5);
    }
}
