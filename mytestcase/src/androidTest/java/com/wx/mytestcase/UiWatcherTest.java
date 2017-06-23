package com.wx.mytestcase;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import android.util.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * Created by Administrator on 2017/6/16 0016.
 */
@RunWith(AndroidJUnit4.class)
public class UiWatcherTest {
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
                Log.i("mqqzt", "phone监听器被触发了！！！");
                UiObject2 incomingCallObj = uiDevice.findObject(By.text("Incoming call"));
                if (incomingCallObj.hasObject(By.text("Incoming call"))) {
                    UiObject2 viewObj = uiDevice.findObject(By.res("com.android.dialer:id/glow_pad_view"));
                    viewObj.fling(Direction.RIGHT, 1000);
                    return true;
                }
                return false;
            }
        });

        uiDevice.registerWatcher("sms", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                Log.i("mqqzt", "短信监听器被触发了！！！");
                return false;
            }
        });

        //2. 执行测试步骤
        UiObject2 displayObj = uiDevice.findObject(By.text("Display"));
        displayObj.clickAndWait(Until.newWindow(), 20000);
        uiDevice.wait(Until.findObject(By.desc("Navigate up")), 20000);
        UiObject2 returnObj = uiDevice.findObject(By.desc("Navigate up"));
        returnObj.clickAndWait(Until.newWindow(), 20000);

        displayObj = uiDevice.findObject(By.text("Display"));
        displayObj.clickAndWait(Until.newWindow(), 20000);
        uiDevice.wait(Until.findObject(By.desc("Navigate up")), 20000);
        returnObj = uiDevice.findObject(By.desc("Navigate up"));
        returnObj.clickAndWait(Until.newWindow(), 20000);

//        uiDevice.removeWatcher("phone");

        displayObj = uiDevice.findObject(By.text("Display"));
        displayObj.clickAndWait(Until.newWindow(), 20000);
        uiDevice.wait(Until.findObject(By.desc("Navigate up")), 20000);
        returnObj = uiDevice.findObject(By.desc("Navigate up"));
        returnObj.clickAndWait(Until.newWindow(), 20000);

        displayObj = uiDevice.findObject(By.text("Display"));
        displayObj.clickAndWait(Until.newWindow(), 20000);
        uiDevice.wait(Until.findObject(By.desc("Navigate up")), 20000);
        returnObj = uiDevice.findObject(By.desc("Navigate up"));
        returnObj.clickAndWait(Until.newWindow(), 20000);

        displayObj = uiDevice.findObject(By.text("Display"));
        displayObj.clickAndWait(Until.newWindow(), 20000);
        uiDevice.wait(Until.findObject(By.desc("Navigate up")), 20000);
        returnObj = uiDevice.findObject(By.desc("Navigate up"));
        returnObj.clickAndWait(Until.newWindow(), 20000);
//检查是否有监听器触发过
        Log.i("mqqzt", "hasAnyWatcherTriggered:" + uiDevice.hasAnyWatcherTriggered());
        Log.i("mqqzt", "hasWatcherTriggered(\"phone\"):" + uiDevice.hasWatcherTriggered("phone"));
        Log.i("mqqzt", "hasWatcherTriggered(\"sms\")" + uiDevice.hasWatcherTriggered("sms"));
    }
}
