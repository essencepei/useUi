package com.wx.mytestcase.cases;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.wx.mytestcase.bases.Base;
import com.wx.mytestcase.pages.UserDetailInfoPage;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
@RunWith(AndroidJUnit4.class)
public class OpenWx extends Base {

    @Test
    public void openWX() {

        Log.i("start", "start....");
        List<Map<String, String>> usersinfo = new ArrayList<>();
        findTextAndClick("通讯录");
        try {
            getUsersInfo(usersinfo);
            //循环完通讯录之后双击顶部，回到顶部
            Configurator.getInstance().setActionAcknowledgmentTimeout(0);
            UiObject2 top = mUIDevice.findObject(By.res("com.tencent.mm:id/h8"));
            top.click();
            top.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUsersInfo(List<Map<String, String>> usersinfo) throws Exception {
        UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
        List<UiObject2> friends = listview.findObjects(By.clazz(View.class));
        Boolean bottom = mUIDevice.hasObject(By.res("com.tencent.mm:id/aft"));
        for (UiObject2 friend : friends) {
//            在通讯录列表点击用户名字
            friend.clickAndWait(Until.newWindow(),5000);
//            从用户详细页面获取用户信息
            usersinfo.add(getUserInfo());
        }
        if (!bottom) {
            listview.scroll(Direction.DOWN, 1f, 500);
            getUsersInfo(usersinfo);
        }
    }

    public Map<String, String> getUserInfo() {
        UserDetailInfoPage userinfopage = new UserDetailInfoPage();

        UiObject2 usernameObj = userinfopage.wxName();
        UiObject2 wxNObj = userinfopage.wxNo();
        UiObject2 nickObj = userinfopage.nickname();
        UiObject2 areaObj = userinfopage.area();
        UiObject2 goback = userinfopage.back();

        String username = userinfopage.hasWxName() ? usernameObj.getText() : "";
        String wxNo = userinfopage.hasWxNO()? wxNObj.getText() : "";
        String nickname = userinfopage.hasNickName() ? nickObj.getText() : "";
        String area = userinfopage.hasArea()? areaObj.getText() : "";

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", username);
        userInfo.put("wxNO", wxNo);
        userInfo.put("nickname", nickname);
        userInfo.put("area", area);
        goback.clickAndWait(Until.newWindow(),5000);

        return userInfo;
    }

    /*    public Map<String, String> getUserInfo() {
        Map<String, String> userinfo = new HashMap<>();
        UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
        UiObject2 personInfo = listview.getChildren().get(1);
        List<UiObject2> infos = personInfo.findObjects(By.clazz(TextView.class));
        for(UiObject2 info : infos){
            String ss = info.getText();
            System.out.println(ss);
        }
        return  userinfo;
    }*/
}
