package com.view.anymo.anymotable;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MyHScrollView extends HorizontalScrollView {
    ScrollViewObserver mScrollViewObserver = new ScrollViewObserver();

    public MyHScrollView(Context context) {
        this(context, null);
    }

    public MyHScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyHScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int move_i = 0;

        if (ev.getAction()== MotionEvent.ACTION_DOWN) {
            Log.w("MyHScrollView"," onTouchEvent  ..down.."+move_i);
        }
        if (ev.getAction()== MotionEvent.ACTION_MOVE) {
            move_i = 1 ;
            Log.w("MyHScrollView"," onTouchEvent  ..move.."+move_i);
            float x = ev.getX();
            float y = ev.getY();
            ev.setLocation(x, y);
        }
        if (ev.getAction()== MotionEvent.ACTION_UP) {
            Log.w("MyHScrollView"," onTouchEvent  ..up.."+move_i);
        }
        return super.onTouchEvent(ev);
    }

    //    onscrollChanged方法有四个参数  第一个参数为变化后的X轴位置
    //                               第二个参数为变化后的Y轴的位置
    //                               第三个参数为原先的X轴的位置
    //                               第四个参数为原先的Y轴的位置
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		/*
		 * 当滚动条移动后，引发 滚动事件。通知给观察者，观察者会传达给其他的。
		 */
        if (mScrollViewObserver != null) {
            mScrollViewObserver.NotifyOnScrollChanged(l, t, oldl, oldt);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    /*
     * 订阅 本控件 的 滚动条变化事件
     * */
    public void AddOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.AddOnScrollChangedListener(listener);
    }

    /*
     * 取消 订阅 本控件 的 滚动条变化事件
     * */
    public void RemoveOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.RemoveOnScrollChangedListener(listener);
    }

    /*
     * 当发生了滚动事件时
     */
    public static interface OnScrollChangedListener {
         void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    /*
     * 观察者
     */
    public static class ScrollViewObserver {
        List<OnScrollChangedListener> mList;

        public ScrollViewObserver() {
            super();
            mList = new ArrayList<OnScrollChangedListener>();
        }

        public void AddOnScrollChangedListener(OnScrollChangedListener listener) {
            mList.add(listener);
        }

        public void RemoveOnScrollChangedListener(
                OnScrollChangedListener listener) {
            mList.remove(listener);
        }

        public void NotifyOnScrollChanged(int l, int t, int oldl, int oldt) {
            if (mList == null || mList.size() == 0) {
                return;
            }
            for (int i = 0; i < mList.size(); i++) {
                if (mList.get(i) != null) {
                    mList.get(i).onScrollChanged(l, t, oldl, oldt);
                }
            }
        }
    }
}
