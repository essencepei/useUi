package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class SouSuoPage extends BasePage {
    public UiObject2 sousuoInput(){
        return mUIDevice.findObject(By.text("搜索"));
    }

    public UiObject search(){
        return mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/ja"));
    }
    public UiObject back(){
        return mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/gw"));
    }
}
