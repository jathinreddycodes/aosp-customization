package android.os;

import android.annotation.NonNull;
import android.util.Log;
import android.content.Context;
import android.os.RemoteException;
import com.android.internal.jathin.ICarFuelData;

/** @hide */
// using hide because  we are using ICarFuelData which is hidden in internal, if we use it , it will throw error
public class CarFuelManager {

    private static final String TAG = "CarFuelManager";
    private final ICarFuelData mService;
    private final Context mContext;
    /** @hide */
    public CarFuelManager(Context context, @NonNull ICarFuelData service) {
        mService = service;
        mContext = context;
    }

    public String getFuelData() {
        try {
            return mService.getFuelData();
        } catch (Exception e) {
            Log.e(TAG, "Failed to get fuel data", e);
            return null;
        }
    }
}

