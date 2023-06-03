package com.example.kuldevdummy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kuldevdummy.R;
import com.example.kuldevdummy.holder.GridViewHolder;
import com.example.kuldevdummy.holder.ImageViewHolder;
import com.example.kuldevdummy.holder.RecyclerViewHolder;
import com.example.kuldevdummy.models.Component;
import com.example.kuldevdummy.models.Data;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_IMAGE = 1;
    private static final int VIEW_TYPE_GRID = 2;
    private static final int VIEW_TYPE_RECYCLER = 3;
    private List<Component> items;

    public RecyclerViewAdapter(List<Component> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case VIEW_TYPE_IMAGE:
                view = inflater.inflate(R.layout.image_layout, parent, false);
                return new ImageViewHolder(view);
            case VIEW_TYPE_GRID:
                view = inflater.inflate(R.layout.grid_layout, parent, false);
                return new GridViewHolder(view);
            case VIEW_TYPE_RECYCLER:
                view = inflater.inflate(R.layout.recycler_layout, parent, false);
                return new RecyclerViewHolder(view);
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public int getItemViewType(int position) {
        Component item = items.get(position);
        if (item.getType().equals( "image")) {
            return VIEW_TYPE_IMAGE;
        } else if (item.getType().equals( "grid")) {
            return VIEW_TYPE_GRID;
        } else if (item.getType().equals( "recycler")) {
            return VIEW_TYPE_RECYCLER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Component item = items.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_IMAGE:
                ((ImageViewHolder) holder).bindData((Component) item);
                break;
            case VIEW_TYPE_GRID:
                ((GridViewHolder) holder).bindData((Component) item);
                break;
            case VIEW_TYPE_RECYCLER:
                ((RecyclerViewHolder) holder).bindData((List<Data>) item.getData());
                break;
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
