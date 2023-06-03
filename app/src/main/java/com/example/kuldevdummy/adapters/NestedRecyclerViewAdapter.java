package com.example.kuldevdummy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuldevdummy.R;
import com.example.kuldevdummy.models.Data;

import java.util.List;

public class NestedRecyclerViewAdapter extends RecyclerView.Adapter<NestedRecyclerViewAdapter.MyViewHolder> {
    private List<Data> data;

    public NestedRecyclerViewAdapter(List<Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recyclerview_item_layout, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data item = data.get(position);
        holder.textView_value.setText(item.getValue());
        holder.textView_name.setText(item.getName());
        holder.textView_desc.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_name,textView_value,textView_desc;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.textView_name);
            textView_value = itemView.findViewById(R.id.textView_value);
            textView_desc = itemView.findViewById(R.id.textView_desc);
        }
    }
}
