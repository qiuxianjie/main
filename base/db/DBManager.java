package edu.feicui.app.phone.base.db;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by qiuxianjie on 2016/8/17.
 */
public class DBManager {
    public static void dbmanager(Context context, String data, File file) {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            inputStream = context.getAssets().open(data);
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            byte[] ss = new byte[2048];
            int len = 0;
            while (-1 != (len = bufferedInputStream.read(ss, 0, ss.length))) {
                bufferedOutputStream.write(ss, 0, len);
            }
            bufferedOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
