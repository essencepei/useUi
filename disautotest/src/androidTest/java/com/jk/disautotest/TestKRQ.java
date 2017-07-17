package com.jk.disautotest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jk.disautotest.krqPages.DeviceListPage;
import com.jk.disautotest.krqPages.devicePage;
import com.jk.disautotest.krqPages.mainPage;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
@RunWith(AndroidJUnit4.class)
public class TestKRQ {
    protected static UiDevice mUIDevice = null;
    protected static Context mContext = null;
    static String APP = "com.kongrongqi.shopmall";

    //    启动并登录app
    @BeforeClass
    public static void setUp() throws Exception {
        mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        mContext = InstrumentationRegistry.getContext();
        if (!mUIDevice.isScreenOn()) {
            mUIDevice.wakeUp();
        }
        mUIDevice.pressHome();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);  //启动app
        mContext.startActivity(myIntent);
        mUIDevice.wait(Until.findObject(By.text("登录")), 10000);
        List<UiObject2> inputs =  mUIDevice.findObjects(By.clazz(EditText.class));
        if(inputs.size() > 0){
            UiObject2 phone = inputs.get(0);
            UiObject2 password = inputs.get(1);
            phone.clear();
            phone.setText("14544991164");
            password.clear();
            password.setText("123456");
        }
        UiObject2 loginbutton = mUIDevice.findObject(By.res("com.kongrongqi.shopmall:id/login_enter"));
        Log.v("login text","login text"+loginbutton.getText());

        //验证是否登录成功
        Assert.assertTrue(loginbutton.clickAndWait(Until.newWindow(),5000));
        mainPage mp = new mainPage();
        Assert.assertTrue(mp.waitToSheBei());
        Assert.assertTrue(mp.waitToJinCheng());
        Assert.assertTrue(mp.waitToFuWu());
        Assert.assertTrue(mp.waitToWo());
    }

    @Test
    public void test_01_accountList(){
        devicePage dp = new devicePage();
        Assert.assertTrue(dp.accountlistButton().clickAndWait(Until.newWindow(),3000));
        mUIDevice.findObject(By.desc("转到上一层级")).clickAndWait(Until.newWindow(),2000);
    }

    @Test
    public void test_02_checkDeviceList(){
        devicePage dp = new devicePage();
//1号机、2号机、3号机按钮
        UiObject2 devices = dp.devices();
        List<UiObject2> device = devices.findObjects(By.clazz(TextView.class));
        System.out.println(device.size());
            for (int i = 0; i < device.size(); i++) {
                UiObject2 nimei = device.get(i);
                String ss = nimei.getText().toString();
                Assert.assertTrue(dp.devicelistButton().clickAndWait(Until.newWindow(),3000));
                DeviceListPage dpp = new DeviceListPage();
                String text = dpp.devicesist().get(i).getText();
                Assert.assertEquals(ss,text);
//                Assert.assertTrue(dpp.back().clickAndWait(Until.newWindow(),2000));
                dpp.back().click();
            }
    }

    @Test
    public void test_03_addWechatAccount(){
        devicePage dp = new devicePage();

    }
    @Test
    public void test_04_addDevice(){
        devicePage dp = new devicePage();
        Assert.assertTrue(dp.addButton().clickAndWait(Until.newWindow(),3000));
        if(mUIDevice.hasObject(By.text("请填写您的设备IMEI码"))){
            mUIDevice.findObject(By.text("请填写您的设备IMEI码")).setText("201707140015");
            Assert.assertTrue(mUIDevice.findObject(By.text("确定添加")).clickAndWait(Until.newWindow(),2000));
            Assert.assertEquals("添加成功",mUIDevice.findObject(By.text("添加成功")).getText());
//            mUIDevice.findObject(By.text("已成功添加4号机，您可以在我的设备里查看"));
            Assert.assertTrue(mUIDevice.findObject(By.clazz(Button.class)).clickAndWait(Until.newWindow(),2000));
            mUIDevice.wait(Until.hasObject(By.text("4号机")),10000);
            Assert.assertTrue(mUIDevice.hasObject(By.text("9号机")));
        }

    }

    @AfterClass
    public static void tearDown() {
        mainPage mp = new mainPage();
        mp.meButton().click();
        UiObject2 scroll = mUIDevice.findObject(By.clazz(ScrollView.class));
        scroll.scroll(Direction.DOWN,0.5f,1000);
        UiObject2 logoutButton = mUIDevice.findObject(By.text("退出"));
        Assert.assertTrue(logoutButton.clickAndWait(Until.newWindow(),2000));
        UiObject2 confirm = mUIDevice.findObject(By.text("确定"));
        Assert.assertTrue(confirm.clickAndWait(Until.newWindow(),2000));
        try {
            mUIDevice.executeShellCommand("am force-stop " + APP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
