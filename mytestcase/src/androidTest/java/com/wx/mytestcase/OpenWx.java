package com.wx.mytestcase;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

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
        UiObject2 tongxunlu = mUIDevice.findObject(By.text("通讯录"));   //定位通讯录搜索

        List<Map<String, String>> usersinfo = new ArrayList<>();
        try {
            tongxunlu.click();  //进入通讯录列表
            getUsersInfo(usersinfo);
            //循环完通讯录之后双击顶部，回到顶部
//            UiObject top = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/h5"));
            Configurator.getInstance().setActionAcknowledgmentTimeout(0);
            UiObject2 top = mUIDevice.findObject(By.res("com.tencent.mm:id/h5"));
            top.click();
            top.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUsersInfo(List<Map<String, String>> usersinfo) throws Exception {
        UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
        List<UiObject2> friends = listview.findObjects(By.clazz(View.class));
        Boolean bottom = mUIDevice.hasObject(By.res("com.tencent.mm:id/a7e"));
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


    public Map<String, String> getUserInfo() {
        Map<String, String> userInfo = new HashMap<>();
        UiObject2 usernameObj = mUIDevice.findObject(By.res("com.tencent.mm:id/hu"));
        UiObject2 wxNObj = mUIDevice.findObject(By.res("com.tencent.mm:id/a7w"));
        UiObject2 nickObj = mUIDevice.findObject(By.res("com.tencent.mm:id/a86"));
        UiObject2 areaObj = mUIDevice.findObject(By.res("android:id/summary"));
        UiObject2 goback = mUIDevice.findObject(By.desc("返回"));
        String username = mUIDevice.hasObject(By.res("com.tencent.mm:id/hu")) ? usernameObj.getText() : "";
        String wxNo = mUIDevice.hasObject(By.res("com.tencent.mm:id/a7w")) ? wxNObj.getText() : "";
        String nickname = mUIDevice.hasObject(By.res("com.tencent.mm:id/a86")) ? nickObj.getText() : "";
        String area = mUIDevice.hasObject(By.res("android:id/summary"))? areaObj.getText() : "";
        userInfo.put("username", username);
        userInfo.put("wxNO", wxNo);
        userInfo.put("nickname", nickname);
        userInfo.put("area", area);
        goback.clickAndWait(Until.newWindow(),5000);
        return userInfo;
    }
}
