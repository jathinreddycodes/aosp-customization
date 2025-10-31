package com.example.customapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ServiceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.internal.bunty.IFuelService;

public class MainActivity extends Activity {
    private IFuelService mFuelService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get binder for fuel service
        IBinder binder = ServiceManager.getService("Fuel");
        if (binder != null) {
            mFuelService = IFuelService.Stub.asInterface(binder);
        }

        Button button = findViewById(R.id.Buttonone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFuelService != null) {
                    try {
                        String level = mFuelService.fuel();
                        Toast.makeText(MainActivity.this, "Fuel: " + level, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Fuel Service not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
