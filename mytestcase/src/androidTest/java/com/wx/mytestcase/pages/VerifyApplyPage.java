package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class VerifyApplyPage extends BasePage {
    public UiObject2 back (){
        return mUIDevice.findObject(By.desc("返回"));
    }

    public UiObject2 send(){
        return mUIDevice.findObject(By.text("发送"));
    }

    public UiObject verifycontent(){
        return mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/ce8"));
    }

    public UiObject note(){
        return mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/ceb"));
    }

    public UiObject isSeePyq(){
        return mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/fx"));
    }
}
