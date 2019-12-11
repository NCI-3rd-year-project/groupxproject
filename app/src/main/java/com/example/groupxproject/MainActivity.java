package com.example.groupxproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mRecyclerView = findViewById(R.id.recyclerView);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

       myAdapter = new MyAdapter(this,getMyList());

       mRecyclerView.setAdapter(myAdapter);
    }
    private ArrayList<Model> getMyList(){
        ArrayList<Model> model = new ArrayList<>();
        Model m = new Model ();
        m.setTitle("Lloyds Pharmacy");
        m.setDescription("This is the Lloyds pharmacy descriptions..");
        m.setImg(R.drawable.logo);
        model.add(m);

        m = new Model ();
        m.setTitle("Boots Pharmacy");
        m.setDescription("This is the Boots pharmacy descriptions..");
        m.setImg(R.drawable.boots1);
        model.add(m);

        m = new Model ();
        m.setTitle("Pure Pharmacy");
        m.setDescription("This is the Pure pharmacy descriptions..");
        m.setImg(R.drawable.pure);
        model.add(m);

        m = new Model ();
        m.setTitle("Haven Pharmacy");
        m.setDescription("This is the Haven pharmacy descriptions..");
        m.setImg(R.drawable.havenpharmacy);
        model.add(m);

        m = new Model ();
        m.setTitle("Meaghers Pharmacy");
        m.setDescription("This is the Meaghers pharmacy descriptions..");
        m.setImg(R.drawable.meaghers);
        model.add(m);

        m = new Model ();
        m.setTitle("Hickey's Pharmacy");
        m.setDescription("This is the Hickey's pharmacy descriptions..");
        m.setImg(R.drawable.hickeys);
        model.add(m);

        return model;
    }




}