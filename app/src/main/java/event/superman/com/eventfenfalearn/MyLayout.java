package event.superman.com.eventfenfalearn;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 作者 Superman
 * 日期 2018/12/7 14:33.
 * 文件 EventFenfaLearn
 * 描述 https://blog.csdn.net/guolin_blog/article/details/9153747  Android事件分发机制完全解析，带你从源码的角度彻底理解(下) 郭霖
 */

public class MyLayout extends LinearLayout{
    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * viewgroup的事件拦截，默认是不拦截向下传递
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);//
        return true;//返回true 拦截
    }
}
