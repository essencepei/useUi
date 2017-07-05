package com.wx.mytestcase.actions;

import android.support.test.uiautomator.Until;

import com.wx.mytestcase.pages.AddFriendPage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class AddFriendPageAction {
    AddFriendPage add = new AddFriendPage();

    public void goSousuo(){
        add.sousuo().clickAndWait(Until.newWindow(),2000);
    }

    public void goSjlxr(){
        add.sjlxr().clickAndWait(Until.newWindow(),2000);
    }

    public void goLdjpy(){
        add.ldjpy().clickAndWait(Until.newWindow(),2000);
    }

    public void goMdmjq(){
        add.mdmjq().clickAndWait(Until.newWindow(),2000);
    }

    public void goBack(){
        add.back().click();
    }
}
