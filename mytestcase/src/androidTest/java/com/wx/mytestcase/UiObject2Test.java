package com.wx.mytestcase;
import android.app.Instrumentation;
import android.graphics.Point;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
/**
 * Created by Administrator on 2017/6/16 0016.
 */
@RunWith(AndroidJUnit4.class)
public class UiObject2Test {
    UiDevice uiDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }


    @Test
    public void testSetText(){
        UiObject2 mmsSendObject = uiDevice.findObject(By.res("com.android.mms:id/embedded_text_editor"));
        mmsSendObject.setText("我的东西在哪里？");
        sleep(1000);
        mmsSendObject.clear();
    }

    @Test
    public void testDrag(){
        UiObject2 settingsObj = uiDevice.findObject(By.text("Settings"));
        Point p = new Point();
        p.x = 116;
        p.y = 497;
        settingsObj.drag(p, 500);
        sleep(2000);
        settingsObj.clickAndWait(Until.newWindow(), 5000);
    }

    @Test
    public void testScroll(){
        UiObject2 listViewObj = uiDevice.findObject(By.clazz(ListView.class));
        listViewObj.scroll(Direction.DOWN, 0.8f, 500);
    }


    @Test
    public void testPinch(){
        UiObject2 viewObj = uiDevice.findObject(By.res("com.android.gallery3d:id/gl_root_view"));
        viewObj.pinchClose(0.8f, 500);
        sleep(2000);
        viewObj.pinchOpen(0.8f, 500);
    }

    @Test
    public void testFling(){
        UiObject2 msg = uiDevice.findObject(By.res("com.android.contacts:id/message"));
        msg.fling(Direction.LEFT, 500);
    }

    @Test
    public void testSwipe(){
        UiObject2 msg = uiDevice.findObject(By.res("com.android.contacts:id/message"));
        msg.swipe(Direction.RIGHT, 0.8f, 500);
    }

    @Test
    public void testWifiSwitch(){
        UiObject2 wifiSwitchObj = uiDevice.findObject(By.res("com.android.settings:id/switch_widget"));
        if(!wifiSwitchObj.isChecked()){
            wifiSwitchObj.click();
        }
    }

    @Test
    public void testChild(){
        UiObject2 listViewObj = uiDevice.findObject(By.clazz(ListView.class));
        UiObject2 child = listViewObj.findObject(By.clazz(TextView.class));
        Log.i("mqqzt", child.getText());

        List<UiObject2> listChild = listViewObj.findObjects(By.clazz(TextView.class));
        Log.i("mqqzt", listChild.size() + "");
        for(UiObject2 uiObject2 : listChild){
            Log.i("mqqzt", uiObject2.getText());
        }

        List<UiObject2> getChild = listViewObj.getChildren();
        Log.i("mqqzt", getChild.size() + "");
        for(UiObject2 uiObject2 : getChild){
            Log.i("mqqzt", uiObject2.getClassName());
        }

        Log.i("mqqzt", listViewObj.getParent().getClassName());
        Log.i("mqqzt", listViewObj.getChildCount() + "");

        UiObject2 childEqual = listViewObj.findObject(By.text("Alarms"));
        Log.i("mqqzt", child.equals(childEqual) + "");

        Log.i("mqqzt", child.hasObject(By.text("Alarms")) + "");
        Log.i("mqqzt", child.hasObject(By.text("Alarms12")) + "");

        childEqual.recycle();
        childEqual = listViewObj.findObject(By.text("Alarms"));
        childEqual.click();
    }


    public void sleep(int sleep){
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
