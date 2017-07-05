package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class FirstPage extends BasePage {

    public UiObject2 loginButton(){
        return  mUIDevice.findObject(By.text("登录"));
    }

    public UiObject2 register(){
        return  mUIDevice.findObject(By.text("注册"));
    }
}
