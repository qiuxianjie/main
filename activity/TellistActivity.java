package edu.feicui.app.phone.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.feicui.app.phone.adapter.TelnumberAdapter;
import edu.feicui.app.phone.base.db.BaseActivity;
import edu.feicui.app.phone.base.db.DBRead;
import edu.feicui.app.phone.entity.TelnumberInfo;

public class TellistActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    TelnumberAdapter telnumberAdapter;
    int idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tellist);

        Intent intent = getIntent();
        idx = intent.getIntExtra("idx", 0);
        listView = (ListView) findViewById(R.id.ListView2);
        telnumberAdapter = new TelnumberAdapter(this);
        init(idx);
    }

    @Override
    protected void onResume() {
        super.onResume();
        telnumberAdapter.numberClear();
        telnumberAdapter.addMore(DBRead.getnumberTest(idx));
        telnumberAdapter.notifyDataSetChanged();
        listView.setAdapter(telnumberAdapter);
        listView.setOnItemClickListener(this);

    }

    public void init(int idx) {
        ArrayList<TelnumberInfo> arrayList = DBRead.getnumberTest(idx);
        for (TelnumberInfo telnumberInfo : arrayList) {
            Toast.makeText(this, "姓名：" + telnumberInfo.name + "\n电话号码" + telnumberInfo.number, Toast.LENGTH_SHORT).show();
            Log.e("姓名：" + telnumberInfo.name, "电话号码" + telnumberInfo.number);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String name = telnumberAdapter.getItem(i).name;
        String number = telnumberAdapter.getItem(i).number;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(TellistActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            show(number);
        } else {
            show(number);
        }

    }
    public void show(String number) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }
}
