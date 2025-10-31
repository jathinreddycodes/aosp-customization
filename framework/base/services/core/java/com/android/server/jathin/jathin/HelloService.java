package com.android.server.jathin;

import com.android.internal.jathin.IHelloService;
import android.os.RemoteException;
import android.util.Log;

public class HelloService extends IHelloService.Stub {
    private static final String TAG = "HelloService";

    public HelloService() {
        Log.i(TAG, "HelloService created");
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from Jathin's System Service!";
    }
}
