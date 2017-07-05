package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class FxPage extends BasePage{
   public UiObject2 pyq(){
       return mUIDevice.findObject(By.text("朋友圈"));
   }
    public UiObject2 yyy(){
        return mUIDevice.findObject(By.text("摇一摇"));

    }

    public UiObject2 fjdr(){
        return mUIDevice.findObject(By.text("附近的人"));
    }

}
