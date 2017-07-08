package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class UserDetailInfoPage extends BasePage {
    public UiObject2 wxName(){
        return  mUIDevice.findObject(By.res("com.tencent.mm:id/hu"));
    }

    public UiObject2 wxNo(){
        return  mUIDevice.findObject(By.res("com.tencent.mm:id/a7w"));
    }

    public UiObject2 nickname(){
        return  mUIDevice.findObject(By.res("com.tencent.mm:id/a86"));
    }

    public UiObject2 area(){
        return  mUIDevice.findObject(By.res("android:id/summary"));
    }

    public UiObject2 back(){
        return  mUIDevice.findObject(By.desc("返回"));
    }

    public UiObject2 tjdtxl(){
        return  mUIDevice.findObject(By.text("添加到通讯录"));
    }
}
