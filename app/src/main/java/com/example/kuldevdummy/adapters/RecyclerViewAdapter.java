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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Data> items;

    public RecyclerViewAdapter(List<Data> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data item = items.get(position);

        // Set data to the views

        holder.textView_name.setText(item.getName());
        holder.textview_value.setText(item.getValue());
        holder.textview_desc.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_name,textview_value,textview_desc;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_name = itemView.findViewById(R.id.textView_name);
            textview_value = itemView.findViewById(R.id.textView_value);
            textview_desc = itemView.findViewById(R.id.textView_desc);
        }
    }
}
