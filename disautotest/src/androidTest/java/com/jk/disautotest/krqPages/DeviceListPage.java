package com.jk.disautotest.krqPages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;
import android.widget.TextView;

import com.jk.disautotest.bases.BasePage;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */

public class DeviceListPage extends BasePage {
    BySelector addButton = By.res("com.kongrongqi.shopmall:id/xRecyclerView");
    BySelector backButton = By.desc("转到上一层级");
    public List<UiObject2> devicesist(){
        return mUIDevice.findObject(addButton).findObjects(By.clazz(TextView.class));
    }

    public UiObject2 back(){
        return  mUIDevice.findObject(backButton);
    }
}
