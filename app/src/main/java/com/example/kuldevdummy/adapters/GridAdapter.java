package com.example.kuldevdummy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kuldevdummy.R;
import com.example.kuldevdummy.models.Data;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private List<Data> items;

    public GridAdapter(Context context, List<Data> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);
        }


        TextView textView = convertView.findViewById(R.id.textView_name);
        ImageView gridImageView = convertView.findViewById(R.id.grid_image_view);

        Data item = items.get(position);

        Glide.with(convertView.getContext())
                .load(item.getImageUrl())
                .into(gridImageView);

        textView.setText(item.getValue());

        return convertView;
    }
}
