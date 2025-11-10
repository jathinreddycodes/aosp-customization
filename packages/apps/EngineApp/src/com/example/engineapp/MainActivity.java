package com.example.engineapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import android.os.CarFuelManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.Activity;

public class MainActivity extends Activity {

    public Button button3, button1, button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
	button3 = findViewById(R.id.button3);
        button1.setOnClickListener(view->
        {
            startService(new Intent(this, Bservice.class));
        });

        button2.setOnClickListener(view ->
        {
            stopService(new Intent(this,Bservice.class));
        });


	button3.setOnClickListener(view ->
        {
            try{
                CarFuelManager carFuelManager = (CarFuelManager) getSystemService(Context.CARFUEL_SERVICE);
                if(carFuelManager != null)
                {
                    String fuel  = carFuelManager.getFuelData();
                    Toast.makeText(this,"Fuel data : " + fuel, Toast.LENGTH_SHORT).show();
                    Log.i("Mainactivity", "Fuel data :" + fuel);
                }
                else {
                    Toast.makeText(this,"carfuelmanager not available",Toast.LENGTH_SHORT).show();
                    Log.i("Mainactivity", "Fuel data not availabel");
                }
            }
            catch (Exception e)
            {
                Log.e("Mainactivity","Failed to get data from manager");
                Toast.makeText(this,"Error : " + e, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
