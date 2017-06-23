package com.wx.mytestcase;

import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
@RunWith(AndroidJUnit4.class)
public class UiDeviceTest {
    UiDevice uiDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp(){
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice.pressBack();
        uiDevice.pressBack();
        uiDevice.pressBack();
        uiDevice.pressBack();
    }

    @After
    public void tearDown(){
        uiDevice.pressBack();
        uiDevice.pressBack();
        uiDevice.pressBack();
        uiDevice.pressBack();
    }

    @Test
    public void testInstrumentation(){
        //InstrumentationRegistry类
        //获取运行Intrumentation命令时，传入的参数
        Bundle bundle = InstrumentationRegistry.getArguments();
        //把获取到的参数发送到测试结果中
        instrumentation.sendStatus(888, bundle);
        Context curContext = InstrumentationRegistry.getContext();
        Context tarContext = InstrumentationRegistry.getTargetContext();
        PackageManager pm = curContext.getPackageManager();
        Bundle contextBundle = new Bundle();
        contextBundle.putString("CUR_CONTEXT", pm.getInstalledPackages(PackageManager.GET_ACTIVITIES).get(0).packageName);
        InstrumentationRegistry.registerInstance(instrumentation, contextBundle);
        Bundle b2 = InstrumentationRegistry.getArguments();
        instrumentation.sendStatus(889, b2);

    }

    @Test
    public void testUiDeviceNewAPI() throws IOException, UiObjectNotFoundException {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "uidump.xml");
        if(file.exists()){
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        OutputStream os = new FileOutputStream(file);
        uiDevice.dumpWindowHierarchy(os);

        uiDevice.executeShellCommand("am start -n com.android.settings/.Settings");

        uiDevice.wait(Until.findObject(By.text("显示")), 20000);
        UiObject2 uiObject2 = uiDevice.findObject(By.text("显示"));
        uiObject2.click();

        UiObject uiObject = uiDevice.findObject(new UiSelector().text("壁纸"));
        uiObject.clickAndWaitForNewWindow();

        Bundle bundle = new Bundle();
        List<UiObject2> list = uiDevice.findObjects(By.clazz(TextView.class));
        for(UiObject2 uiObject21: list){
            bundle.putString("UIDEVICE", uiObject21.getText());
        }
        InstrumentationRegistry.registerInstance(instrumentation, bundle);
        instrumentation.sendStatus(111, bundle);
    }

    @Test
    public void testLauncherAPP(){
        Context context = InstrumentationRegistry.getContext();
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> list = pm.getInstalledApplications(0);
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(mainIntent, 0);
        for(ResolveInfo resolveInfo : resolveInfoList){
            String activityName = resolveInfo.activityInfo.name;
            String packageName = resolveInfo.activityInfo.packageName;

            Intent launcherIntent = new Intent();
            launcherIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launcherIntent.setComponent(new ComponentName(packageName, activityName));
            context.startActivity(launcherIntent);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            uiDevice.pressBack();
            uiDevice.pressBack();
            uiDevice.pressBack();
            uiDevice.pressBack();
        }
    }
}
