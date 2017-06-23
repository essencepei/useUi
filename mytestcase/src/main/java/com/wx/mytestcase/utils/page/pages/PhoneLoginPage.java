package com.wx.mytestcase.utils.page.pages;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class PhoneLoginPage {
    private UiDevice mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    public UiObject2 accountInput(){
        return  mUIDevice.findObject(By.text("你的手机号码"));
    }
    public UiObject2 pwdInput(){
//        resource-id:com.tencent.mm:id/gz
        return  null;
    }
}
