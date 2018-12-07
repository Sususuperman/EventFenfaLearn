package event.superman.com.eventfenfalearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 参考博客
 * https://blog.csdn.net/guolin_blog/article/details/9097463/    郭霖
 * https://blog.csdn.net/lvxiangan/article/details/9309927   Android-onInterceptTouchEvent()和onTouchEvent()总结
 * https://www.jianshu.com/p/34cb396104a7  理解View事件分发 通过源码分析事件分发
 */
public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView iv;

    LinearLayout layout1, layout2;
    TextView view1;
/**************************************************/
    MyLayout mylayout;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        iv = findViewById(R.id.iv);

        layout1 = findViewById(R.id.viewgroup1);
        layout2 = findViewById(R.id.viewgroup2);
        view1 = findViewById(R.id.view1);
        /***************************************/
        mylayout = findViewById(R.id.mylayout);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);


        initListeners();
    }

    private void initListeners() {
        mylayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG","mylayout onTouch");
                return false;
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","btn1 onClicked");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","btn2 onClicked");
            }
        });

    /*****************************************************/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick");
            }
        });

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("TAG", "action " + motionEvent.getAction());//0是action_down  1是action_up onTouch先于onClick执行
                return false;//onTouch默认返回false 表示会继续向下执行onClick,返回true的话表示这个事件被消费掉了不再向下继续传递。
            }
        });

        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("TAG", "action " + motionEvent.getAction());//0是action_down  1是action_up onTouch先于onClick执行
                return false;//onTouch默认返回false 表示会继续向下执行onClick,返回true的话表示这个事件被消费掉了不再向下继续传递。
            }
        });

    view1.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.d("TAG", "action " + event.getAction());//0是action_down  1是action_up onTouch先于onClick执行
            return false;
        }
    });
    }

    /**
     * 一个触摸事件最先就是包装成一个MotionEvent给发送到Activity的dispatchTounchEvent了
     * 查看源码可以发现调用了activity window的superDispatchTouchEvent(ev)方法来进行事件的分发。
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    /**
     * 首先判断一下MotionEvent是否为down，如果是的话就调用 onUserInteraction()。
     * 而onUserInteraction()就是一个空方法，目的就是实现这个方法，
     * 可以更加方便管理一些notfication。
     */
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
    }
}
