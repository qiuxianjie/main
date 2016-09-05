package edu.feicui.app.phone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.feicui.app.phone.activity.R;

/**
 * Created by qiuxianjie on 2016/8/23.
 */
public class ActionView extends LinearLayout {
    private ImageView iv_actionbar_left;//左边按钮
    private ImageView iv_actionbar_right;//右边按钮
    private TextView tv_actionbar_title;//中间文本

    public ActionView(Context context) {
        super(context);
    }

    public ActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.three, this);
        tv_actionbar_title = (TextView) findViewById(R.id.tv_title);
        iv_actionbar_left = (ImageView) findViewById(R.id.iv_left);
        iv_actionbar_right = (ImageView) findViewById(R.id.iv_right);
    }

    public ActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ActionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void ActionBarTest(String title, int leftResID,
                              int rightResID, OnClickListener listener) {
        tv_actionbar_title.setText(title);
        if (leftResID == -1) {
            iv_actionbar_left.setVisibility(View.INVISIBLE);
        } else {
            iv_actionbar_left.setImageResource(leftResID);
            iv_actionbar_left.setOnClickListener(listener);
        }
        if (rightResID == -1) {
            iv_actionbar_right.setVisibility(View.INVISIBLE);
        } else {
            iv_actionbar_right.setImageResource(rightResID);
            iv_actionbar_right.setOnClickListener(listener);
        }
    }

}
