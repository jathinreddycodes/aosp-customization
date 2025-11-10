package com.example.engineapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Bservice  extends Service
{
    public static boolean isrunning;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Backservice", "Service is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
	isrunning = true;
        Thread t = new Thread(() ->
        {
            while (isrunning)
            {
                try {
                    Log.d("Backservice", "Service is running");
                    Thread.sleep(1000);

                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        t.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        isrunning = false;
        super.onDestroy();
        Log.d("Backservice","Service destroyed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
