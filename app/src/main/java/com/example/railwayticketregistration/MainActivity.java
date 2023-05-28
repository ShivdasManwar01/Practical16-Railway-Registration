package com.example.railwayticketregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup destinations;
    EditText name,phoneNo;
    Spinner berths;
    CheckBox veg,non_veg;
    Button register;
    String destination,berth,meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        berths.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "Select valid option", Toast.LENGTH_SHORT).show();
                }
                else{
                    berth=parent.getItemAtPosition(position).toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        destinations.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.pune:
                        destination="Pune";
                        break;
                    case R.id.sangali:
                        destination="Sangli";
                        break;
                    case R.id.mumbai:
                        destination="mumbai";
                        break;

                }
            }
        });
        veg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    meal="Veg";
                }
            }
        });
        non_veg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                meal="Non Veg";
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowDetails.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("phoneno",phoneNo.getText().toString());
                intent.putExtra("berth",berth);
                intent.putExtra("destination",destination);
                intent.putExtra("meal",meal);
                startActivity(intent);

            }
        });

    }
    public void init(){
        destinations=findViewById(R.id.destinations);
        name=findViewById(R.id.name);
        phoneNo=findViewById(R.id.phoneno);
        berths=findViewById(R.id.berths);
        veg=findViewById(R.id.veg);
        non_veg=findViewById(R.id.non_veg);
        register=findViewById(R.id.register);
    }

}
