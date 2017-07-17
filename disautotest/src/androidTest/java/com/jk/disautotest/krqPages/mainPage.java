package com.jk.disautotest.krqPages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;

import com.jk.disautotest.bases.BasePage;

public class mainPage extends BasePage {
    BySelector sheBeiButton = By.text("设备");
    BySelector jinChentButton = By.text("进程");
    BySelector fuWuButton = By.text("服务");
    BySelector woButton = By.text("我");
    public UiObject2 deviceButton(){
        return mUIDevice.findObject(sheBeiButton);
    }
    public UiObject2 jinChengButton(){
        return mUIDevice.findObject(jinChentButton);
    }
    public UiObject2 serviceButton(){
        return mUIDevice.findObject(fuWuButton);
    }
    public UiObject2 meButton(){
        return mUIDevice.findObject(woButton);
    }
    public Boolean waitToSheBei(){
        return myWait(sheBeiButton);
    }
    public Boolean waitToJinCheng(){
        return myWait(jinChentButton);
    }
    public Boolean waitToFuWu(){
        return myWait(fuWuButton);
    }
    public Boolean waitToWo(){
        return myWait(woButton);
    }

}
