package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class SouSuoPage extends BasePage {
    public UiObject2 sousuoInput(){
        return mUIDevice.findObject(By.text("搜索"));
    }

    public UiObject2 search(){
        return mUIDevice.findObject(By.res("com.tencent.mm:id/ja"));
    }
    public UiObject2 back(){
        return mUIDevice.findObject(By.res("com.tencent.mm:id/gw"));
    }
}
