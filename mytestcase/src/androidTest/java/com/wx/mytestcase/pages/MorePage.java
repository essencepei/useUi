package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class MorePage extends BasePage{
    public UiObject2 fqql(){
        return mUIDevice.findObject(By.text("发起群聊"));
    }

    public UiObject2 tjpy(){
        return mUIDevice.findObject(By.text("添加朋友"));
    }
}
