package edu.feicui.app.phone.base.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

import edu.feicui.app.phone.entity.TelclassInfo;
import edu.feicui.app.phone.entity.TelnumberInfo;

/**
 * Created by qiuxianjie on 2016/8/17.
 */
public class DBRead {
    public static File file;

    static {
        String string = "data/";
        string += Environment.getDataDirectory().getAbsolutePath();
        string += "/edu.feicui.app.phone.activity/";
        File file1 = new File(string);
        file = new File(string + "commonnum.db");
    }

    public static boolean isExist() {
        File file = DBRead.file;
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }

    public static ArrayList<TelclassInfo> getClassTest() {
        ArrayList<TelclassInfo> arrayList = new ArrayList<TelclassInfo>();
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(DBRead.file, null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from classlist", null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int idx = cursor.getInt(cursor.getColumnIndex("idx"));
                TelclassInfo telclassInfo = new TelclassInfo(name, idx);
                arrayList.add(telclassInfo);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }


    public static ArrayList<TelnumberInfo> getnumberTest(int idx) {
        ArrayList<TelnumberInfo> arrayList = new ArrayList<TelnumberInfo>();
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(DBRead.file, null);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from table" + idx, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                TelnumberInfo telnumberInfo = new TelnumberInfo(name, number);
                arrayList.add(telnumberInfo);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }
}













