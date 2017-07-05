package com.wx.mytestcase.actions;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
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
        UiObject content = vap.verifycontent();
        try {
            content.setText(verifycontent);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearVerify(){
        UiObject content = vap.verifycontent();
        try {
            content.clearTextField();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}
