package com.example.kuldevdummy.holder;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kuldevdummy.R;
import com.example.kuldevdummy.adapters.ExpandableGridView;
import com.example.kuldevdummy.adapters.GridAdapter;
import com.example.kuldevdummy.models.Component;
import com.example.kuldevdummy.models.Data;

import java.util.List;

public class GridViewHolder extends RecyclerView.ViewHolder {
    private ExpandableGridView gridView;


    public GridViewHolder(View itemView) {
        super(itemView);
        gridView = itemView.findViewById(R.id.grid_view);

    }

    public void bindData(Component component) {
        GridAdapter gridAdapter = new GridAdapter(itemView.getContext(),component.getData());
        gridView.setExpanded(true);
        gridView.setNumColumns(component.getColumns());
        gridView.setAdapter(gridAdapter);

    }
}