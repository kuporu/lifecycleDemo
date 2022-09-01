package com.hgc.lifecycledemo.observer;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @Description 观察生命周期
 * @systemUser gchan2
 * @Author hanguangchuan
 * @Date 09-01-2022 周四 14:27
 */
public class MyObserver implements LifecycleObserver {

    private Lifecycle lifecycle;

    private boolean enabled = false;

    public MyObserver (Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public static final String TAG = "Lifecycle_Test";

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    public void connect () {
        if (enabled) {
            Log.i(TAG, "connect: ");
        }
    }

    public void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Log.i(TAG, "connect: ");
        }
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    public void disConnect () {
        Log.i(TAG, "disConnect: ");
    }
}
