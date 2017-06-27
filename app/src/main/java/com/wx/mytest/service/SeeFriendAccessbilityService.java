package com.wx.mytest.service;

import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

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
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();

        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("通讯录");
            if (list != null && list.size() > 0) {
                for (AccessibilityNodeInfo n : list) {
                    if (n.getClassName().equals("android.widget.TextView")) {
                        AccessibilityNodeInfo parent =n.getParent();
                        while(parent != null){
                            if(parent.isClickable()){
                                performViewClick(parent);
//                                查看朋友信息
                                seeFriends ();
                                break;
                            }
                            parent = parent.getParent();
                        }
                    }
                }
            }
        }
    }
//顺序点击好友
    public void seeFriends (){
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        List<AccessibilityNodeInfo> listView = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/hy");
        AccessibilityNodeInfo first = listView.get(0).getChild(1);

//            打开个人信息页面
        getFriendsInfo();
//            个人信息页面点击返回到通讯录列表页面
        goback();

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
