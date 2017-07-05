package com.wx.mytestcase.actions;

import android.support.test.uiautomator.UiObjectNotFoundException;

import com.wx.mytestcase.pages.SouSuoPage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class SouSuoPageAction {
    SouSuoPage ssp = new SouSuoPage();
    public void goSearch(String searchcontent){
        ssp.sousuoInput().click();
        ssp.sousuoInput().setText(searchcontent);
        try {
            ssp.search().clickAndWaitForNewWindow();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
}
