package com.view.anymo.anymotable;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    private static final String TAG = "UserAdapter";
    private Context mContext;
    private List<User> users;
    private RelativeLayout mHead;

    public UserAdapter(Context context, List<User> users, RelativeLayout mHead) {
        mContext = context;
        this.users = users;
        this.mHead = mHead;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.user_list_item, null);
        }
        User user = users.get(position);
        TextView id = (TextView) convertView.findViewById(R.id.item_user_id);
        id.setText(user.getId());
        TextView name = (TextView) convertView.findViewById(R.id.item_user_name);
        name.setText(user.getName());
        TextView age = (TextView) convertView.findViewById(R.id.item_user_age);
        age.setText(user.getAge());
        TextView gender = (TextView) convertView.findViewById(R.id.item_user_gender);
        gender.setText(user.getGender());
        TextView creattime = (TextView) convertView.findViewById(R.id.item_user_creattime);
        creattime.setText(date2String(user.getCreattime()));

        MyHScrollView scrollView = (MyHScrollView) convertView.findViewById(R.id.user_horizontalScrollView);
        MyHScrollView headSrcrollView = (MyHScrollView) mHead.findViewById(R.id.user_horizontalScrollView);
        //让条目能横向滑动，关联头部滑动和条目
        headSrcrollView.AddOnScrollChangedListener(new OnScrollChangedListener(scrollView));

        return convertView;
    }

    class OnScrollChangedListener implements MyHScrollView.OnScrollChangedListener {
        MyHScrollView mScrollView;

        public OnScrollChangedListener(MyHScrollView scrollView) {
            mScrollView = scrollView;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollView.smoothScrollTo(l, t);
        }
    }

    private String date2String(Date date)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (null != date) {
            String str = sdf.format(date);
            return str;
        }else {
            return null;
        }
    }
}
