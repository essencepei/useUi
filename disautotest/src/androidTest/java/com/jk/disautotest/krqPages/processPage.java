package com.jk.disautotest.krqPages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;
import com.jk.disautotest.bases.BasePage;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class processPage extends BasePage {
    BySelector toBeUsed =By.res("未使用");
    BySelector doing = By.res("进行中");
    BySelector done =By.res("已完成");

    public UiObject2 toBeUsedButton(){
        return mUIDevice.findObject(toBeUsed);
    }

    public Boolean hasToBeUsedButton(){
        return mUIDevice.hasObject(toBeUsed);
    }

    public UiObject2 doingButton(){
        return mUIDevice.findObject(doing);
    }

    public Boolean hasDoingButton(){
        return mUIDevice.hasObject(doing);
    }

    public UiObject2 doneButton(){
        return mUIDevice.findObject(done);
    }

    public Boolean hasDonedButton(){
        return mUIDevice.hasObject(done);
    }
}
