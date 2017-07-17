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
    BySelector wxname =By.res(wxNameID);

    public Boolean hasWxName(){
        return mUIDevice.hasObject(wxname);
    }
    public UiObject2 wxName(){
        return  mUIDevice.findObject(By.res(wxNameID));
    }
    public Boolean hasWxNO(){
        return mUIDevice.hasObject(By.res(wxNOID));
    }
    public UiObject2 wxNo(){
        return  mUIDevice.findObject(By.res(wxNOID));
    }
    public Boolean hasNickName(){
        return mUIDevice.hasObject(By.res(nickNameID));
    }
    public UiObject2 nickname(){
        return  mUIDevice.findObject(By.res(nickNameID));
    }
    public Boolean hasArea(){
        return mUIDevice.hasObject(By.res(areaID));
    }
    public UiObject2 area(){
        return  mUIDevice.findObject(By.res(areaID));
    }

    public UiObject2 back(){
        return  mUIDevice.findObject(By.desc(backDesc));
    }

    public UiObject2 tjdtxl(){
        return  mUIDevice.findObject(By.text(addToTXL));
    }
}
