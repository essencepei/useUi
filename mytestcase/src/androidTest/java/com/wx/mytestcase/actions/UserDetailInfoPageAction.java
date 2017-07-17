package com.wx.mytestcase.actions;

import android.support.test.uiautomator.UiObject2;

import com.wx.mytestcase.pages.UserDetailInfoPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class UserDetailInfoPageAction {
    UserDetailInfoPage usp = new UserDetailInfoPage();
    public void addToTxl(){
        usp.tjdtxl().click();
    }
    public void goBack(){
        usp.back().click();
    }
    public Map<String,String> getUserInfoAndBack(){
        Map<String, String> userinfo = new HashMap<>();
        UiObject2 usernameObj = usp.wxName();
        UiObject2 wxNObj = usp.wxNo();
        UiObject2 nickObj = usp.nickname();
        UiObject2 areaObj = usp.area();
        String username =  usp.hasWxName() ? usernameObj.getText() : "";
        String wxNo = usp.hasWxNO() ? wxNObj.getText() : "";
        String nickname = usp.hasNickName() ? nickObj.getText() : "";
        String area = usp.hasArea() ? areaObj.getText() : "";
        userinfo.put("username", username);
        userinfo.put("wxNO", wxNo);
        userinfo.put("nickname", nickname);
        userinfo.put("area", area);
        usp.back().click();
        return userinfo;
    }
}
