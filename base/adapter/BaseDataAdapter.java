package edu.feicui.app.phone.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuxianjie on 2016/8/18.
 */
public abstract class BaseDataAdapter<E> extends BaseAdapter {
    private ArrayList<E> adapterDatas = new ArrayList<E>();
    protected LayoutInflater layoutInflater;
    protected Context context;

    public BaseDataAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return adapterDatas.size();
    }

    @Override
    public E getItem(int position) {
        return adapterDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 为ArrayList<E> 添加get()set()方法
    public ArrayList<E> getDataFromAdapter() {
        return adapterDatas;
    }

    public void setAdapterDatas(List<E> e) {
        adapterDatas.clear();
        if (e != null) {
            adapterDatas.addAll(e);
        }
    }

    //添加单个数据
    public void addDataToAdapter(E e) {
        if (e != null) {
            adapterDatas.add(e);
        }
    }

    //添加集合数据
    public void addDataToAdapter(ArrayList<E> e) {
        if (e != null) {
            adapterDatas.addAll(e);
        }
    }

    //clearAdapter():删除当前适配器集合内数据
    public void addDataToAdapterClear() {
        adapterDatas.clear();
    }

    //在BaseAdapter中添加removeDataFromAdapter (),
    public void removeDataFromAdapter(E e) {
        adapterDatas.remove(e);
    }

    public void removeDataFromAdapter(int index) {
        adapterDatas.remove(index);
    }

}


