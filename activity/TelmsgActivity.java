package edu.feicui.app.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.feicui.app.phone.adapter.TelclassAdapter;
import edu.feicui.app.phone.base.db.BaseActivity;
import edu.feicui.app.phone.base.db.DBManager;
import edu.feicui.app.phone.base.db.DBRead;
import edu.feicui.app.phone.entity.TelclassInfo;

public class TelmsgActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    TelclassAdapter telclassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telmsg);
        listView = (ListView) findViewById(R.id.listView);
        telclassAdapter = new TelclassAdapter(this);
        initone();
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        telclassAdapter.addClear();
        telclassAdapter.addSingele(new TelclassInfo("本地电话", 0));
        telclassAdapter.addMore(DBRead.getClassTest());
        listView.setAdapter(telclassAdapter);

    }

    public void init() {
        if (!DBRead.isExist()) {
            try {
                DBManager.dbmanager(getApplicationContext(), "commonnum.db", DBRead.file);
            } catch (Exception e) {
                Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void initone() {
        ArrayList<TelclassInfo> arrayList = DBRead.getClassTest();
        for (TelclassInfo telclassInfo : arrayList) {
            Toast.makeText(this, "姓名：" + telclassInfo.name +
                    "\nID" + telclassInfo.idx, Toast.LENGTH_LONG).show();
            Log.e("姓名：" + telclassInfo.name, "ID" + telclassInfo.idx);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            startActivity(intent);
            return;
        }
        TelclassInfo telclassInfo = telclassAdapter.getItem(i);
        Intent intent = new Intent(TelmsgActivity.this, TellistActivity.class);
        intent.putExtra("idx", telclassInfo.idx);
        startActivity(intent);
    }
}
