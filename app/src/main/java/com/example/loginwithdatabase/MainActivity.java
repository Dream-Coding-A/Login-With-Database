package com.example.loginwithdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText emailEdit, passEdit;
    Button sign_in;
    API_Interface api_interface;
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdit = findViewById(R.id.emailID);
        passEdit = findViewById(R.id.passID);
        sign_in = findViewById(R.id.btnID);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://soft14.bdtask.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api_interface = retrofit.create(API_Interface.class);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmailPass();
            }
        });
    }

    public void getEmailPass() {
        api_interface.getDATA(emailEdit.toString(),passEdit.toString()).enqueue(new Callback<Model_Class_DataPassing>() {
            @Override
            public void onResponse(Call<Model_Class_DataPassing> call, Response<Model_Class_DataPassing> response) {

                if(response.body().getStatusCode()==1){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("value",emailEdit.getText().toString());
                    intent.putExtra("Image",response.body().getData().getUserPictureURL());
                    intent.putExtra("username",response.body().getData().getFirstname() + response.body().getData().getLastname());
                    //Log.d("test", "onResponse: "+response.body().getData().getEmail());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Authentication Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Model_Class_DataPassing> call, Throwable t) {

            }
        });
    }
}