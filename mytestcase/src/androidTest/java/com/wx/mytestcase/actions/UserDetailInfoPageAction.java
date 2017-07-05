package com.wx.mytestcase.actions;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.wx.mytestcase.pages.UserDetailInfoPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class UserDetailInfoPageAction {
    UserDetailInfoPage usp = new UserDetailInfoPage();
    public void addToTxl(){
        try {
            usp.tjdtxl().click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void goBack(){
        try {
            usp.back().click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Map<String,String> getUserInfoAndBack(){
        Map<String, String> userinfo = new HashMap<>();
        try{
        UiObject usernameObj = usp.wxName();
        UiObject wxNObj = usp.wxNo();
        UiObject nickObj = usp.nickname();
        UiObject areaObj = usp.area();
        String username = usernameObj.exists() ? usernameObj.getText() : "";
        String wxNo = wxNObj.exists() ? wxNObj.getText() : "";
        String nickname = nickObj.exists() ? nickObj.getText() : "";
        String area = areaObj.exists() ? areaObj.getText() : "";
        userinfo.put("username", username);
        userinfo.put("wxNO", wxNo);
        userinfo.put("nickname", nickname);
        userinfo.put("area", area);
        usp.back().click();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userinfo;
    }
}
