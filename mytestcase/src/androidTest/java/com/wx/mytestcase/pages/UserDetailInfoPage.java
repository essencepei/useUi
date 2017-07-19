package com.wx.mytestcase.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.bases.BasePage;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class UserDetailInfoPage extends BasePage {
    String wxNameID ="com.tencent.mm:id/hu";
    String wxNOID= "com.tencent.mm:id/a7w";
    String nickNameID = "com.tencent.mm:id/a86";
    String areaID ="android:id/summary";
    String backDesc = "返回";
    String addToTXL = "添加到通讯录";
    BySelector wxName =By.res(wxNameID);
    BySelector wxNo =By.res(wxNOID);
    BySelector nickName =By.res(nickNameID);
    BySelector area =By.res(areaID);
    BySelector back =By.desc(backDesc);
    BySelector add =By.res(addToTXL);

    public Boolean hasWxName(){
        return mUIDevice.hasObject(wxName);
    }
    public UiObject2 wxName(){
        return  mUIDevice.findObject(wxName);
    }
    public Boolean hasWxNO(){
        return mUIDevice.hasObject(wxNo);
    }
    public UiObject2 wxNo(){
        return  mUIDevice.findObject(wxNo);
    }
    public Boolean hasNickName(){
        return mUIDevice.hasObject(nickName);
    }
    public UiObject2 nickname(){
        return  mUIDevice.findObject(nickName);
    }
    public Boolean hasArea(){
        return mUIDevice.hasObject(area);
    }
    public UiObject2 area(){
        return  mUIDevice.findObject(area);
    }

    public UiObject2 back(){
        return  mUIDevice.findObject(back);
    }

    public UiObject2 tjdtxl(){
        return  mUIDevice.findObject(add);
    }
}
