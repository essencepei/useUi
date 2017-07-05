package com.wx.mytestcase.actions;

import android.support.test.uiautomator.Until;

import com.wx.mytestcase.pages.MorePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class MorePageAction {
    MorePage more = new MorePage();
    public void goFqql(){
        more.fqql().clickAndWait(Until.newWindow(),2000);
    }
    public void goTjpy(){
        more.tjpy().clickAndWait(Until.newWindow(),2000);
    }
}
