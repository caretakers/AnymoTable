package com.view.anymo.anymotable;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class InterceptScrollContainer extends LinearLayout {

    public InterceptScrollContainer(Context context) {
        this(context,null);
    }

    public InterceptScrollContainer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InterceptScrollContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction()== MotionEvent.ACTION_DOWN) {
            Log.w("ScrollContainer"," onInterceptTouchEvent down..");
        }
        if (ev.getAction()== MotionEvent.ACTION_MOVE) {
            Log.w("ScrollContainer"," onInterceptTouchEvent move..");

        }
        if (ev.getAction()== MotionEvent.ACTION_UP) {
            Log.w("ScrollContainer"," onInterceptTouchEvent up..");
        }
        //拦截事件,子布局不会收到点击事件
        return true;
    }
}
