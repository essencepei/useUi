package com.wx.mytestcase;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class Base {
    protected UiDevice mUIDevice = null;
    protected Context mContext = null;
    String APP = "com.tencent.mm";

    public void findTextAndClick(String text){
        mUIDevice.findObject(By.text(text)).click();
    }

    public void ClickAndWait(String text){
        mUIDevice.findObject(By.text(text)).clickAndWait(Until.newWindow(),2000);
    }

    public void findIdAndClick(String id){
        UiObject obj = mUIDevice.findObject(new UiSelector().resourceId(id));
        if(obj.exists()){
            try {
                obj.click();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        mContext = InstrumentationRegistry.getContext();
        if (!mUIDevice.isScreenOn()) {  //唤醒屏幕
            mUIDevice.wakeUp();
        }
        mUIDevice.pressHome();  //按home键
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);  //启动app
        mContext.startActivity(myIntent);
//        mUIDevice.waitForWindowUpdate(APP, 5 * 1000);
        mUIDevice.wait(Until.findObject(By.text("通讯录")), 20000);
    }

    @After
    public void tearDown() {
        try {
            mUIDevice.executeShellCommand("am force-stop com.tencent.mm");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
