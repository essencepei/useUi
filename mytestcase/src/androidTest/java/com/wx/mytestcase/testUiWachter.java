package com.wx.mytestcase;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2017/6/21 0021.
 */
@RunWith(AndroidJUnit4.class)
public class testUiWachter {
    UiDevice uiDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testUiwatcher() {
        //1. 首先注册监听器
        uiDevice.registerWatcher("phone", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                Log.i("mqqzt", "自动回复监听器被触发了！！！");
                UiObject2 incomingCallObj = uiDevice.findObject(By.text("Incoming call"));
                if (incomingCallObj.hasObject(By.text("Incoming call"))) {
                    UiObject2 viewObj = uiDevice.findObject(By.res("com.android.dialer:id/glow_pad_view"));
                    viewObj.fling(Direction.RIGHT, 1000);
                    return true;
                }
                return false;
            }
        });
    }
}
