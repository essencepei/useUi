package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class AddFriendPage extends BasePage {
    public UiObject2 sousuo(){
        return mUIDevice.findObject(By.text("微信号/QQ号/手机号"));
    }

    public UiObject2 ldjpy(){
        return mUIDevice.findObject(By.text("雷达加朋友"));
    }

    public  UiObject2 mdmjq(){
        return mUIDevice.findObject(By.text("面对面建群"));
    }
    public UiObject2 sjlxr(){
        return mUIDevice.findObject(By.text("手机联系人"));
    }
}
