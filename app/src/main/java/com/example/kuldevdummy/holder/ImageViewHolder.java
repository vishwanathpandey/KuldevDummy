package com.example.kuldevdummy.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kuldevdummy.R;
import com.example.kuldevdummy.models.Component;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView nameTextView;
    private TextView valueTextView;
    private TextView descriptionTextView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view);
//        nameTextView = itemView.findViewById(R.id.name_text_view);
//        valueTextView = itemView.findViewById(R.id.value_text_view);
//        descriptionTextView = itemView.findViewById(R.id.description_text_view);
    }

    public void bindData(Component imageComponent) {
        Glide.with(itemView.getContext())
                .load(imageComponent.getImageUrl())
                .into(imageView);
    }
}
