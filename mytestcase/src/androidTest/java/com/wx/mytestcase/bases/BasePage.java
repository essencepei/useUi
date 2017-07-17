package com.wx.mytestcase.bases;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class BasePage {
    protected UiDevice mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    public UiObject2 myFindObjectByText(String text){
        return  mUIDevice.findObject(By.text(text));
    }
    public UiObject2 myFindObjectByDesc(String desc){
        return  mUIDevice.findObject(By.desc(desc));
    }
    public UiObject2 myFindObjectById(String id){
        return  mUIDevice.findObject(By.res(id));
    }

    public UiObject2 myFindObjectByClassName(String className){
        return  mUIDevice.findObject(By.clazz(className));
    }

    public UiObject2 myFindObjectByClass(Class clazz){
        return  mUIDevice.findObject(By.clazz(clazz));
    }

    public List<UiObject2> myFindObjects(BySelector by){
        return  mUIDevice.findObjects(by);
    }
    public Boolean myWait(BySelector by){
        return mUIDevice.wait(Until.hasObject(by),2000);
    }
}
