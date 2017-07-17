package com.wx.mytestcase.actions;

import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.wx.mytestcase.pages.VerifyApplyPage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class VerifyApplyPageAction {
    VerifyApplyPage vap = new VerifyApplyPage();
    public void goBack(){
        vap.back().clickAndWait(Until.newWindow(),3000);
    }
    public void goSend(){
        vap.back().clickAndWait(Until.newWindow(),3000);
    }

    public void verifycontent(String verifycontent){
        UiObject2 content = vap.verifycontent();
        content.setText(verifycontent);
    }

    public void clearVerify(){
        UiObject2 content = vap.verifycontent();
        content.clear();
    }
}
