package edu.feicui.app.phone.base.db;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.feicui.app.phone.base.util.UtilLog;

/**
 * Created by qiuxianjie on 2016/8/18.
 */
public abstract class BaseActionbarActivity extends BaseActivity {
    public static final int NULL_ID = -1;

    /**
     * 设置ActionBar控件上的数据
     * * * @param resIdTitle * 中间主标题文本id,没有标题时可使用{@link #NULL_ID}
     * * @param resIdLeft * 左侧图标资源id,没有图标时可使用{@link #NULL_ID}
     * * @param resIdRight * 右侧图标资源id,没有图标时可使用{@link #NULL_ID}
     */

    public void setActionBar(int resIdTitle, int resIdLeft, int resIdRight) {
        try {
            TextView tv_action_title = (TextView) findViewById(NULL_ID);
            ImageView iv_action_left = (ImageView) findViewById(NULL_ID);
            ImageView iv_action_right = (ImageView) findViewById(NULL_ID);

            if (resIdLeft != NULL_ID) {
                iv_action_left.setImageResource(resIdLeft);
            } else {
                iv_action_left.setVisibility(View.INVISIBLE);
            }

            if(resIdRight!=NULL_ID){
                iv_action_right.setImageResource(resIdRight);
            }else {
                iv_action_right.setVisibility(View.INVISIBLE);
            }
            if(resIdTitle!=NULL_ID){
                tv_action_title.setText(resIdTitle);
            }
        } catch (Exception e) {
            UtilLog.w("BaseActionbarActivity", "ActionBar有异常," +
                    "是否当前页面并没有includle==> include_actionbar.xml布局?");
        }
    }

}
