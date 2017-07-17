package com.jk.disautotest.krqPages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;
import com.jk.disautotest.bases.BasePage;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class devicePage extends BasePage {
    BySelector addButton = By.res("com.kongrongqi.shopmall:id/right_icon");
    BySelector accountlist = By.clazz("android.widget.ImageButton");
    BySelector devicelist = By.res("com.kongrongqi.shopmall:id/more_equipment");
    BySelector devices =By.clazz("android.widget.HorizontalScrollView");

    public UiObject2 addButton(){
        return mUIDevice.findObject(addButton);
    }

    public Boolean hasAddButton(){
        return mUIDevice.hasObject(addButton);
    }

    public UiObject2 accountlistButton(){
        return mUIDevice.findObject(accountlist);
    }

    public Boolean hasAccountlistButton(){
        return mUIDevice.hasObject(accountlist);
    }

    public UiObject2 devicelistButton(){
        return mUIDevice.findObject(devicelist);
    }

    public Boolean hasDevicelistButton(){
        return mUIDevice.hasObject(devicelist);
    }

    public UiObject2 devices(){
        return mUIDevice.findObject(devices);
    }

}
