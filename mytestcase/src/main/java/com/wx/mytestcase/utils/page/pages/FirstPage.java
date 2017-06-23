package com.wx.mytestcase.utils.page.pages;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class FirstPage {
    private UiDevice mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    public UiObject2 loginButton(){
        return  mUIDevice.findObject(By.text("登录"));
    }

    public UiObject2 register(){
        return  mUIDevice.findObject(By.text("注册"));
    }
}
