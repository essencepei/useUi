package com.wx.mytestcase.bases;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class BasePage {
    protected UiDevice mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
}
