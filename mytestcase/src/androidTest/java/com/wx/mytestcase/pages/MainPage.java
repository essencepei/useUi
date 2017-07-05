package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class MainPage extends BasePage {
    public UiObject2 getWx(){
        return  mUIDevice.findObject(By.text("微信"));
    }
    public UiObject2 getTxl(){
        return  mUIDevice.findObject(By.text("通讯录"));
    }

    public UiObject2 getFx(){
        return mUIDevice.findObject(By.text("发现"));
    }
    public UiObject2 getWo(){
        return  mUIDevice.findObject(By.text("我"));
    }
    public UiObject2 getSearch(){
        return  mUIDevice.findObject(By.text("通讯录"));
    }
    public UiObject2 getMore(){
        return  mUIDevice.findObject(By.desc("更多功能按钮"));
    }
}
