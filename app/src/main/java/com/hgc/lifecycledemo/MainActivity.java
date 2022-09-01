package com.hgc.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.hgc.lifecycledemo.observer.MyObserver;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Lifecycle_Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyObserver myObserver = new MyObserver(getLifecycle());
        getLifecycle().addObserver(myObserver);
        Utils.checkUserStatus((flag) -> {
            if (flag) {
                myObserver.enable();
            }
        });
        Log.i(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }
}