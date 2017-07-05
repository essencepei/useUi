package com.wx.mytestcase.actions;

import android.support.test.uiautomator.Until;

import com.wx.mytestcase.pages.FxPage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class FxPageAction  {
    FxPage fp = new FxPage();

    public void goPyq(){
        fp.pyq().clickAndWait(Until.newWindow(),2000);
    }

    public void goFjdr(){
        fp.fjdr().clickAndWait(Until.newWindow(),2000);
    }
}
