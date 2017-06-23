package com.wx.mytestcase;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
@RunWith(AndroidJUnit4.class)
public class OpenWx {
    private UiDevice mUIDevice = null;
    private Context mContext = null;
    String APP = "com.tencent.mm";

    @Before
    public void setUp() throws Exception{
        mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        mContext = InstrumentationRegistry.getContext();

        if(!mUIDevice.isScreenOn()){  //唤醒屏幕
            mUIDevice.wakeUp();
        }
        mUIDevice.pressHome();  //按home键
    }
    @After
    public void tearDown(){
        try {
            mUIDevice.executeShellCommand("am force-stop com.tencent.mm");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void openWX(){
        Log.i("start","start....");
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);  //启动app
        mContext.startActivity(myIntent);
//        mUIDevice.waitForWindowUpdate(APP, 5 * 1000);
//        mUIDevice.waitForWindowUpdate(APP, 5 * 1000);
        mUIDevice.wait(Until.findObject(By.text("通讯录")), 20000);
        UiObject2 tongxunlu = mUIDevice.findObject(By.text("通讯录"));   //定位通讯录搜索
        try {
            tongxunlu.click();  //点击按键
        }catch (Exception e){
            e.printStackTrace();
        }

        UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
        List<UiObject2> friends = listview.findObjects(By.clazz(View.class));
        String name = null;
        for (UiObject2 friend:friends){
            name = friend.getText();
            friend.click();
            try{
                mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/h4")).click();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        UiObject2 faxian = mUIDevice.findObject(By.text("发现"));   //定位通讯录搜索
        try {
            faxian.click();  //点击按键
        }catch (Exception e){
            e.printStackTrace();
        }
        UiObject2 wo = mUIDevice.findObject(By.text("我"));   //定位通讯录搜索
        try {
            wo.click();  //点击按键
        }catch (Exception e){
            e.printStackTrace();
        }
        UiObject2 wx = mUIDevice.findObject(By.text("微信"));   //定位通讯录搜索
        try {
            wx.click();  //点击按键
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
