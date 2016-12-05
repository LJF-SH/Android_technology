package com.team.demo.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.team.demo.R;
import com.team.demo.api.response.GroupResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 */
public class MainAdapter<T> extends BaseAdapter {
    List<T> data = new ArrayList<T>();
    private LayoutInflater mInflater;
    private Context mContext;

    public MainAdapter() {
    }

    public MainAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);

    }

    public void addDates(List<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        if (null != data) {
            return data.size();
        }
        return 0;
    }

    @Override
    public T getItem(int position) {
        if (data.size() > position) {
            return data.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_group, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final String response = (String) getItem(position);
        holder.mNotice.setText(response);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_group_name)
        protected TextView mNotice;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
