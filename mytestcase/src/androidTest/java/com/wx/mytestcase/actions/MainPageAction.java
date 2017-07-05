package com.wx.mytestcase.actions;

import android.support.test.uiautomator.Until;

import com.wx.mytestcase.pages.MainPage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class MainPageAction {
    MainPage mp = new MainPage();
    public void goFx(){
        mp.getFx().click();
    }

    public void  goTxl(){
        mp.getTxl().click();
    }

    public void  goWx(){
        mp.getWx().click();
    }

    public void goWo(){
        mp.getWo().click();
    }

    public void goSearchAndWaitUntilNewWindow(){
        mp.getSearch().clickAndWait(Until.newWindow(),2000);
    }

    public void goMoreAndWaitUntilNewWindow(){
        mp.getMore().clickAndWait(Until.newWindow(),2000);
    }
}
