package com.wx.mytestcase;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class TestClass01 {
    public UiDevice mDevice;
    public Instrumentation instrumentation;

    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testCase01() throws IOException {
        //获取运行时的参数
        Bundle args = InstrumentationRegistry.getArguments();
        //输出到运行报告中
        instrumentation.sendStatus(100, args);

        //获取测试包的Context
        Context testContext = InstrumentationRegistry.getContext();
        //获取被测应用的Context
        Context testedContext = InstrumentationRegistry.getTargetContext();

        //通过Context来启动一个Activity,e.g.浏览器
        String url = "https://www.baidu.com";
        Intent i1 = new Intent(Intent.ACTION_VIEW);
        i1.setData(Uri.parse(url));
        i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        testContext.startActivity(i1);

        //通过目标Context来启动拨号功能
        Intent i2 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + 10086));
        i2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        testedContext.startActivity(i2);

        Bundle inputBundle = new Bundle();
        inputBundle.putString("key", "value");
        //注入一个Bundle
        InstrumentationRegistry.registerInstance(instrumentation, inputBundle);
        //获取运行参数
        Bundle outBundle = InstrumentationRegistry.getArguments();
        //输出到结果报告中
        instrumentation.sendStatus(110,outBundle);


    }
}
