package com.android.server.jathin;

import com.android.internal.jathin.ICarFuelData;
import android.os.RemoteException;
import android.util.Log;

public class CarFuelService extends ICarFuelData.Stub
{
	private static final String TAG = "CarFuelService";
	
	public CarFuelService(){
	 Log.i(TAG, "Car Fuel Service created");
	}

	@Override
	public String getFuelData() throws RemoteException{
	return "6 Liters left";
	}
}
