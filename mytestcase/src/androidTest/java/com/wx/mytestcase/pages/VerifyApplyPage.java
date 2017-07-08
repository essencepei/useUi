package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

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

    public UiObject2 verifycontent(){
        return mUIDevice.findObject(By.res("com.tencent.mm:id/ce8"));
    }

    public UiObject2 note(){
        return mUIDevice.findObject(By.res("com.tencent.mm:id/ceb"));
    }

    public UiObject2 isSeePyq(){
        return mUIDevice.findObject(By.res("com.tencent.mm:id/fx"));
    }
}
