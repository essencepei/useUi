package com.wx.mytestcase.actions;

import android.support.test.uiautomator.Until;

import com.wx.mytestcase.pages.SouSuoPage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class SouSuoPageAction {
    SouSuoPage ssp = new SouSuoPage();
    public void goSearch(String searchcontent){
        ssp.sousuoInput().click();
        ssp.sousuoInput().setText(searchcontent);
        ssp.search().clickAndWait(Until.newWindow(),5000);
    }
    public void goBack(){
            ssp.back().click();
    }
}
