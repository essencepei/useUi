package com.wx.mytestcase.cases;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.wx.mytestcase.bases.Base;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2017/7/19 0019.
 */
@RunWith(AndroidJUnit4.class)
public class CountFriend extends Base{
    @Test
    public int count() throws UiObjectNotFoundException {
        findTextAndClick("通讯录");
        UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
        listScrollable.setAsVerticalList();
        listScrollable.scrollIntoView(new UiSelector().resourceId("com.tencent.mm:id/aft"));
        String numtext = mUIDevice.findObject(By.res("com.tencent.mm:id/aft")).getText();
        Integer num = Integer.valueOf(numtext.substring(0,numtext.length()-4));
        return num;
    }
}
