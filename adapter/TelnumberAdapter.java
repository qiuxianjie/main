package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.feicui.app.phone.activity.R;
import edu.feicui.app.phone.entity.TelnumberInfo;

/**
 * Created by qiuxianjie on 2016/8/17.
 */
public class TelnumberAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<TelnumberInfo> arrayList = new ArrayList<TelnumberInfo>();

    public TelnumberAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addSingle(TelnumberInfo telnumberInfo) {
        if (telnumberInfo != null) {
            arrayList.add(telnumberInfo);
        }
    }

    public void addMore(ArrayList<TelnumberInfo> telnumberInfos) {
        if (telnumberInfos != null) {
            arrayList.addAll(telnumberInfos);
        }
    }


    public ArrayList<TelnumberInfo> getArrayListNumber() {
        return arrayList;
    }

    public void numberClear() {
        arrayList.clear();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public TelnumberInfo getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.two, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        textView.setText(arrayList.get(i).name);
        TextView textView1 = (TextView) view.findViewById(R.id.tv_number);
        textView1.setText(arrayList.get(i).number);
        return view;
    }
}
