package edu.feicui.app.phone.base.util;

import android.util.Log;

/**
 * Created by qiuxianjie on 2016/8/17.
 */
public class UtilLog {
    //我们在测试程序时需要输出后台的日志，当我们项目完成后不需要输出
    public static boolean isOpenDebug = true;
    public static boolean isIsOpenWarn = true;

    public static void d(String tag, String msg) {
        if (isOpenDebug) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isIsOpenWarn) {
            Log.w(tag, msg);
        }
    }

}
