package com.wx.mytestcase.bases;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
@RunWith(AndroidJUnit4.class)
public class TestBase {
    public UiDevice mDevice;
    public Instrumentation instrumentation;

    @Before
    public void setUp() {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @After
    public void tearDown(){

    }
}
