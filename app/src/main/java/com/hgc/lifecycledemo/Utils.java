package com.hgc.lifecycledemo;

import android.os.Handler;
import android.os.Looper;

/**
 * @Description TODO
 * @systemUser gchan2
 * @Author hanguangchuan
 * @Date 09-01-2022 周四 16:49
 */
public class Utils {

    private final static Handler mHandler = new Handler(Looper.getMainLooper());

    public static void checkUserStatus (MyCallback callback) {
        /* 模拟耗时 10S 操作 */
        new Thread(() -> {
            try {
                Thread.sleep(10 * 1000);
                mHandler.post(() -> {
                    callback.doSomething(true);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
