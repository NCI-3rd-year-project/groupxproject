package com.example.groupxproject;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyHolder> {


    Context c;
    ArrayList<Model> model;

    public MyAdapter(Context c, ArrayList<Model> model) {
        this.c = c;
        this.model = model;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, int position) {

        myHolder.mTitle.setText(model.get(position).getTitle());
        myHolder.mDes.setText(model.get(position).getDescription());
        myHolder.mImageView.setImageResource(model.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}


