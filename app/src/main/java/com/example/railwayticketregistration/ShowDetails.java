package com.example.railwayticketregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {
    TextView name,phoneno,meal,destination,berth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        init();

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        phoneno.setText(intent.getStringExtra("phoneno"));
        berth.setText(intent.getStringExtra("berth"));
        destination.setText(intent.getStringExtra("destination"));
        meal.setText(intent.getStringExtra("meal"));

    }
    public void init(){
        name=findViewById(R.id.name);
        phoneno=findViewById(R.id.phoneNo);
        destination=findViewById(R.id.destination);
        meal=findViewById(R.id.meal);
        berth=findViewById(R.id.berth);
    }
}