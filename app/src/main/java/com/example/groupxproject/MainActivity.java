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
    private Button buttonHome;

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonHome = (Button) findViewById(R.id.btnHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList());

        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList() {
        ArrayList<Model> model = new ArrayList<>();
        Model m = new Model();
        m.setTitle("Lloyds Pharmacy");
        m.setDescription("LloydsPharmacy is a British pharmacy company, with more than 1,500 pharmacies, the biggest one stores in Dublin at 39 Stoneybatter, Dublin, D07 AE37; Phone: (01) 679 2086");
        m.setImg(R.drawable.logo);
        model.add(m);

        m = new Model();
        m.setTitle("Boots Pharmacy");
        m.setDescription("Boots is a drugstore chain in the UK and Ireland, with stores in major shopping streets, shopping centres and airports in the UK. Currently, boots operate more than 2,500 stores in the UK and Ireland. The main boots store in Dublin at Unit 9, Jervis Shopping Centre, Henry St, North City, Dublin 1, D01 E8H4.");
        m.setImg(R.drawable.boots1);
        model.add(m);

        m = new Model();
        m.setTitle("Pure Pharmacy");
        m.setDescription("Pure Pharmacy first opened its doors in 2011. A 100% Irish-owned company, Pure Pharmacy always strives to provide outstanding services and competitive pricing for its customers.It has 14 stores in Dublin. The official web is: https://www.purepharmacy.ie");
        m.setImg(R.drawable.pure);
        model.add(m);

        m = new Model();
        m.setTitle("Haven Pharmacy");
        m.setDescription("Think of us like you would your family GP. Haven Pharmacy is here for you and your family to help you throughout life’s journey. From nappy rashes, to head lice, to the common cold and beyond, our pharmacists are on hand to look after you and your family’s health and well-being.Haven stores are gathered in the city center of Dublin. Official Web: https://havenpharmacy.ie");
        m.setImg(R.drawable.havenpharmacy);
        model.add(m);

        m = new Model();
        m.setTitle("Meaghers Pharmacy");
        m.setDescription("Meaghers Pharmacy-a leading Dublin pharmacy group with 9 stores & over 60 staff. We offer Pharmacy, Advanced Consultation & Retail services in all stores. Meagher's Pharmacy Group was first opened in Baggot Street in 1921 and operated by the Meagher family. Main Store address: The Mater Misericordiae University Hospital; Phone: (01) 811 7781");
        m.setImg(R.drawable.meaghers);
        model.add(m);

        m = new Model();
        m.setTitle("Hickey's Pharmacy");
        m.setDescription("Hickey's Pharmacy is an Irish-owned Community Pharmacy Group with a proud record of serving our customers for over 20 years. We operate in the heart of communities, catering for the needs of individuals, families and patients in residential care. The main store at  21 Grafton Street, Dublin 2, D02 FW29; Phone:(01) 679 0467");
        m.setImg(R.drawable.hickeys);
        model.add(m);

        return model;

    }

    public void openMainPage() {
        Intent MainPage = new Intent(MainActivity.this, MainPage.class);
        startActivity(MainPage);
    }


}
