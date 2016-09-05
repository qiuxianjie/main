package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.feicui.app.phone.activity.R;
import edu.feicui.app.phone.entity.TelclassInfo;

/**
 * Created by qiuxianjie on 2016/8/17.
 */
public class TelclassAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<TelclassInfo> arrayList = new ArrayList<TelclassInfo>();

    public TelclassAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addSingele(TelclassInfo telclassInfo) {
        if (telclassInfo != null) {
            arrayList.add(telclassInfo);
        }
    }

    public void addMore(ArrayList<TelclassInfo> telclassInfos) {
        if (telclassInfos != null) {
            arrayList.addAll(telclassInfos);
        }
    }


    public void addClear() {
        arrayList.clear();
    }

    public ArrayList<TelclassInfo> getArrayListClass() {
        return arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public TelclassInfo getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.one, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText(arrayList.get(i).name);
        return view;
    }
}

