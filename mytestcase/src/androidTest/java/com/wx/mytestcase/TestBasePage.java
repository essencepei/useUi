package com.wx.mytestcase;

import android.support.test.runner.AndroidJUnit4;

import com.wx.mytestcase.actions.AddFriendPageAction;
import com.wx.mytestcase.actions.MainPageAction;
import com.wx.mytestcase.actions.MorePageAction;
import com.wx.mytestcase.actions.SouSuoPageAction;
import com.wx.mytestcase.actions.UserDetailInfoPageAction;
import com.wx.mytestcase.actions.VerifyApplyPageAction;
import com.wx.mytestcase.pages.UserDetailInfoPage;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@RunWith(AndroidJUnit4.class)
public class TestBasePage extends Base {
    @Test
    public void basepage(){
        MainPageAction mpc = new MainPageAction();
        MorePageAction mpc1= new MorePageAction();
        AddFriendPageAction afpa = new AddFriendPageAction();
        SouSuoPageAction sspa = new SouSuoPageAction();
        UserDetailInfoPage  userpage = new UserDetailInfoPage();
        UserDetailInfoPageAction  udipa = new UserDetailInfoPageAction();
        VerifyApplyPageAction verifya = new VerifyApplyPageAction();

        mpc.goMoreAndWaitUntilNewWindow();
        mpc1.goTjpy();
        afpa.goSousuo();
        sspa.goSearch("13657296691");
        if(userpage.tjdtxl().exists()){
            udipa.addToTxl();
            verifya.goBack();
        }
        udipa.goBack();
        sspa.goBack();
        afpa.goBack();

    }
}
