package com.wx.mytest.service;

import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class SeeFriendAccessbilityService extends BaseAccessibilityService{
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        super.onAccessibilityEvent(event);
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence className = event.getClassName();
            if (className.equals("com.tencent.mm.ui.LauncherUI")) {
                openTXL();
            }
        }
    }

//    点击通讯录
    @SuppressLint("NewApi")
    private void openTXL() {
        List<Map<String, String>> usersinfo = new ArrayList<>();
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        int wxWindowId = nodeInfo.getWindowId();
        System.out.println("---------微信聊天窗口"+wxWindowId);

        clickTextViewByText("发现");

        clickTextViewByText("朋友圈");
        AccessibilityNodeInfo nodeInfo21 = getRootInActiveWindow();
        int pyqWindowId = nodeInfo21.getWindowId();
        System.out.println("-------发现窗口id"+pyqWindowId);
        AccessibilityNodeInfo back = nodeInfo21.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/h4").get(0);
        performViewClick(back);



//        seeFriends (usersinfo);
    }
//顺序点击好友
    public void seeFriends (List<Map<String, String>> usersinfo){
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();

        int txlWindowId = nodeInfo.getWindowId();
        System.out.println("---------通讯录id"+txlWindowId);

        AccessibilityNodeInfo listView = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/hy").get(0);

        int childcount = listView.getChildCount();
        for(int i =1 ;i<childcount;i++){
            AccessibilityNodeInfo user = listView.getChild(i);
            System.out.println("看一下是啥"+user.getClassName().toString());
                performViewClick(user);
                usersinfo.add(getUserInfo());

        }
//        if (!bottom.exists()) {
//            listview.scroll(Direction.DOWN, 1f, 500);
//            getUsersInfo(usersinfo);
//        }
    }

    public Map<String, String> getUserInfo(){
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        int userInfoWindowId = nodeInfo.getWindowId();
        System.out.println("---------用户详细信息window id"+userInfoWindowId);
        Map<String, String> userinfo = new HashMap<>();
        AccessibilityNodeInfo mh = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/mh").get(0);
        AccessibilityNodeInfo aeq = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/aeq").get(0);
        AccessibilityNodeInfo af0 = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/af0").get(0);
        AccessibilityNodeInfo summary = nodeInfo.findAccessibilityNodeInfosByViewId("android:id/summary").get(0);
        AccessibilityNodeInfo h4 = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/h4").get(0);

        String username = (mh!=null) ? mh.getText().toString() : "";
        String wxNo = (aeq!=null) ? aeq.getText().toString() : "";
        String nickname = (af0!=null) ? af0.getText().toString() : "";
        String area = (summary!=null) ? summary.getText().toString() : "";
        userinfo.put("username",username);
        userinfo.put("wxNo",wxNo);
        userinfo.put("nickname",nickname);
        userinfo.put("area",area);
        performViewClick(h4);

        return userinfo;
    }
//个人信息页面返回
    public  void goback(){
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        AccessibilityNodeInfo clickable =  nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/h4").get(0).getParent();
        if(clickable.isClickable()){
            performViewClick(clickable);
        }
    }
//    个人信息页面获取个人信息
    public Map<String,String> getFriendsInfo(){
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        Map<String,String> userinfo = new HashMap<String,String>();
        String username = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/mh").get(0).getText().toString();
        String wxNO = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/aeq").get(0).getText().toString();
        String nickname = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/af0").get(0).getText().toString();
        String area = nodeInfo.findAccessibilityNodeInfosByViewId("android:id/summary").get(0).getText().toString();
        userinfo.put("username",username);
        userinfo.put("wxNO",wxNO);
        userinfo.put("nickname",nickname);
        userinfo.put("area",area);
        return  userinfo;
    }

    private  boolean isSeeWx(AccessibilityNodeInfo nodeInfo){
        nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("微信");
            return  true;
        }
        else{
            return false;
        }
    }

    private  boolean isSeeTXL(AccessibilityNodeInfo nodeInfo){
        nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("通讯录");
            return  true;
        }
        else{
            return false;
        }
    }

    private  boolean isSeeFX(AccessibilityNodeInfo nodeInfo) {
        nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("发现");
            return true;
        } else {
            return false;
        }
    }

    private  boolean isSeeMe(AccessibilityNodeInfo nodeInfo){
        nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("我");
            return  true;
        }
        else{
            return false;
        }
    }

}
