package com.wx.mytestcase;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
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
//    private UiDevice mUIDevice = null;
//    private Context mContext = null;
//    String APP = "com.tencent.mm";
//    Boolean Flag = true;


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
            UiObject top = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/h5"));
            top.click();
            top.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUsersInfo(List<Map<String, String>> usersinfo) throws Exception {
        UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
        List<UiObject2> friends = listview.findObjects(By.clazz(View.class));
        UiObject bottom = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/ae8"));
        for (UiObject2 friend : friends) {
//            在通讯录列表点击用户名字
            friend.click();
//            从用户详细页面获取用户信息
            usersinfo.add(getUserInfo());
        }
        if (!bottom.exists()) {
            listview.scroll(Direction.DOWN, 1f, 500);
            getUsersInfo(usersinfo);
        }

//           滑动，再取用户数据
//        UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
//        if (listScrollable.scrollForward()) {
//            getUsersInfo(usersinfo);
//        } else {
//            if (Flag) {
//                Flag = false;
//                getUsersInfo(usersinfo);
//            } else {
//                return;
//            }
//        }
    }


    public Map<String, String> getUserInfo() {
        Map<String, String> userinfo = new HashMap<>();
        try {
            UiObject usernameObj = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/mh"));
            UiObject wxNObj = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/aeq"));
            UiObject nickObj = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/af0"));
            UiObject areaObj = mUIDevice.findObject(new UiSelector().resourceId("android:id/summary"));
            UiObject goback = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/h4"));
            String username = usernameObj.exists() ? usernameObj.getText() : "";
            String wxNo = wxNObj.exists() ? wxNObj.getText() : "";
            String nickname = nickObj.exists() ? nickObj.getText() : "";
            String area = areaObj.exists() ? areaObj.getText() : "";
            userinfo.put("username", username);
            userinfo.put("wxNO", wxNo);
            userinfo.put("nickname", nickname);
            userinfo.put("area", area);
            goback.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userinfo;
    }
}
