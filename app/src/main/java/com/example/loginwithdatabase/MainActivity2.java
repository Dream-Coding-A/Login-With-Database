package com.example.loginwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView email, username;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email = findViewById(R.id.showEmailID);
        username = findViewById(R.id.showUsernameID);

        email.setText(getIntent().getStringExtra("value"));
        username.setText(getIntent().getStringExtra("username"));
        String img = getIntent().getStringExtra("Image");


    }
}