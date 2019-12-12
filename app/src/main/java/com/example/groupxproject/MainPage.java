package com.example.groupxproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    private Button buttonLogin;
    private Button post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        buttonLogin = (Button) findViewById(R.id.ButtonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogIn();
            }
        });

        post = (Button) findViewById(R.id.BtnPost);
        post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openPostActivity();
            }
        });
    }

    public void openLogIn() {
        Intent login = new Intent(MainPage.this, LogIn.class);
        startActivity(login);
    }

    public void openPostActivity() {
        Intent login = new Intent(MainPage.this, PostActivity.class);
        startActivity(login);
    }
}
