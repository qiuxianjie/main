package edu.feicui.app.phone.base.db;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

import edu.feicui.app.phone.base.util.UtilLog;

/**
 * Created by qiuxianjie on 2016/8/17.
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "代码测试中";
    //定义变量
    private static ArrayList<BaseActivity> activities = new ArrayList<BaseActivity>();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void finish() {
        super.finish();

    }


    @Override
    protected void onStart() {
        super.onStart();
        UtilLog.w(TAG, getClass().getSimpleName() + "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        UtilLog.d(TAG, getClass().getSimpleName() + "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        UtilLog.d(TAG, getClass().getSimpleName() + "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        UtilLog.d(TAG, getClass().getSimpleName() + "onStop()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        UtilLog.d(TAG, getClass().getSimpleName() + "onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UtilLog.d(TAG, getClass().getSimpleName() + "onDestroy()");
        if(activities.contains(this)){
            activities.remove(this);
        }
    }

    //在BaseActivity类中添加finishAll()方法依次退出当前存在的所有Activity的
    //关闭所有窗口的方法
    public static void finishall() {
        Iterator<BaseActivity> iterator = activities.iterator();
        while (iterator.hasNext()) {
            iterator.next().finish();
        }
    }

    //普通跳转
    protected void startActivityTest(Class<?> targetClass) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }

    //传递参数的跳转
    protected void startActivityTest(Class<?> targetClass, Bundle bundle) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void startActivityTest(Class<?> targetClass, int inAnimID, int outAnimID) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }

    //带动画跳转，并传递参数
    protected void startActivity(Class<?> targetClass, int inAnimID, int outAnimID, Bundle bundle) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        overridePendingTransition(inAnimID,outAnimID);
    }


}
