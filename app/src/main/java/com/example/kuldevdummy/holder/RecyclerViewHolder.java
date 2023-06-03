package com.example.kuldevdummy.holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuldevdummy.R;
import com.example.kuldevdummy.adapters.NestedRecyclerViewAdapter;
import com.example.kuldevdummy.models.Data;

import java.util.List;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private RecyclerView recyclerView;


    public RecyclerViewHolder(View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.recycler_view);

    }

    public void bindData(List<Data> recyclerItem) {
        NestedRecyclerViewAdapter recyclerAdapter = new NestedRecyclerViewAdapter(recyclerItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        recyclerView.setAdapter(recyclerAdapter);
    }
}