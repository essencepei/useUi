package com.wx.mytestcase;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.wx.mytestcase.utils.page.bases.TestBase;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class OpenSettings extends TestBase{
//    private UiDevice mDevice;

   @Test
    public void demo() throws UiObjectNotFoundException {
//        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        mDevice.pressHome();
        UiObject x=mDevice.findObject(new UiSelector().text("设置"));
        x.click();
        mDevice.pressBack();
        mDevice.pressBack();

       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   }

}
