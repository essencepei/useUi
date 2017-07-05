package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class UserDetailInfoPage extends BasePage {
    public UiObject wxName(){
        return  mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/mh"));
    }

    public UiObject wxNo(){
        return  mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aeq"));
    }

    public UiObject nickname(){
        return  mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/af0"));
    }

    public UiObject area(){
        return  mUIDevice.findObject(new UiSelector().resourceId("android:id/summary"));
    }

    public UiObject goback(){
        return  mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/h4"));
    }

    public UiObject2 tjdtxl(){
        return  mUIDevice.findObject(By.text("添加到通讯录"));
    }
}
