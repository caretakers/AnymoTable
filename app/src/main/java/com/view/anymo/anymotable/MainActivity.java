package com.view.anymo.anymotable;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lv)
    ListView lv;
    @Bind(R.id.lv_header)
    RelativeLayout lvHeader;
    private List<User> users;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(i + "", "anymo" + i, (i + 10) + "", "male", "本科", new Date(System.currentTimeMillis()));
            users.add(user);
        }
        //头部
        lvHeader.setFocusable(true);
        lvHeader.setClickable(true);
        lvHeader.setBackgroundColor(Color.parseColor("#BBB7C6"));
        lvHeader.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());//滑动监听

        //列表
        lv.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());//滑动监听
        lv.setAdapter(new UserAdapter(this, users, lvHeader));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (toast == null) {
                    toast = Toast.makeText(MainActivity.this, position+"",Toast.LENGTH_SHORT);
                }
                toast.setText(position+"");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    /**
     * 滑动事件
     */
    private class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            //当在列头 和 listView控件上touch时，将这个touch的事件分发给 ScrollView，只允许头部横向滑动
            HorizontalScrollView headSrcrollView = (HorizontalScrollView) lvHeader
                    .findViewById(R.id.user_horizontalScrollView);
            headSrcrollView.onTouchEvent(arg1);
            return false;
        }
    }
}
