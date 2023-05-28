package com.example.kuldevdummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kuldevdummy.adapters.ExpandableGridView;
import com.example.kuldevdummy.adapters.GridAdapter;
import com.example.kuldevdummy.adapters.RecyclerViewAdapter;
import com.example.kuldevdummy.databinding.ActivityMainBinding;
import com.example.kuldevdummy.models.BaseModel;
import com.example.kuldevdummy.models.Component;
import com.example.kuldevdummy.models.Data;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private  String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        InputStream inputStream = getResources().openRawResource(R.raw.component);
        Reader reader = new InputStreamReader(inputStream);


        Gson gson = new Gson();
        BaseModel dataModel = gson.fromJson(reader, BaseModel.class);


        for (Component component : dataModel.getComponents()) {
            switch (component.getType()) {
                case "image":

                    View imageLayout = LayoutInflater.from(this).inflate(R.layout.image_layout, binding.parentLayout, false);
                    ImageView imageView = imageLayout.findViewById(R.id.image_view);


                    String imageUrl = component.getImageUrl();

                    Log.d(TAG,"image url is - "+imageUrl);



                    Glide.with(this)
                            .load(imageUrl)
                            .into(imageView);


                   binding.parentLayout.addView(imageLayout);
                    break;

                case "grid":

                    View gridLayout = LayoutInflater.from(this).inflate(R.layout.grid_layout, binding.parentLayout, false);

                    ExpandableGridView gridView = gridLayout.findViewById(R.id.grid_view);


                    int columns = component.getColumns();
                    gridView.setNumColumns(columns);
                    gridView.setExpanded(true);


                    List<Data> gridItems = component.getData();

                    Log.d(TAG,"number of column is - "+columns +" number of data is - "+gridItems.size());

                    GridAdapter adapter = new GridAdapter(this, gridItems);
                    gridView.setAdapter(adapter);


                    binding.parentLayout.addView(gridLayout);
                    break;

                case "recycler":

                    View recyclerLayout = LayoutInflater.from(this).inflate(R.layout.recycler_layout, binding.parentLayout, false);

                    RecyclerView recyclerView = recyclerLayout.findViewById(R.id.recycler_view);


                    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(component.getData());
                    recyclerView.setAdapter(recyclerViewAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));


                    binding.parentLayout.addView(recyclerLayout);
                    break;
            }
        }




    }


}