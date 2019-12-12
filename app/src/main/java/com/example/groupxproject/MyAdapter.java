package com.example.groupxproject;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayOutputStream;
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
    public void onBindViewHolder(final MyHolder myHolder, int position) {

        myHolder.mTitle.setText(model.get(position).getTitle());
        myHolder.mDes.setText(model.get(position).getDescription());
        myHolder.mImageView.setImageResource(model.get(position).getImg());


        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {


                String gTitle = model.get(position).getTitle();
                String gDesc = model.get(position).getDescription();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(c, AnotherActivity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);
            }
        });

       /* myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                if (model.get(position).getTitle().equals("Lloyds Pharmacy")){

                }

                if (model.get(position).getTitle().equals("Boots Pharmacy")){

                }

                if (model.get(position).getTitle().equals("Pure Pharmacy")){

                }

                if (model.get(position).getTitle().equals("Haven Pharmacy")){

                }

                if (model.get(position).getTitle().equals("Meaghers Pharmacy")){

                }

                if (model.get(position).getTitle().equals("Hickey's Pharmacy")){

                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}


