package com.wx.mytestcase;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.widget.ListView;

import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class SeeFriendCirecle extends Base{

    @Test
    public void friendcircle(){
        UiObject2 find = mUIDevice.findObject(By.text("发现"));
        find.click();
        mUIDevice.findObject(By.text("朋友圈")).click();
        String comment = "这只是一个实验";
        comment(comment);
    }

    public void comment(String comment){
        List<UiObject2> lists = mUIDevice.findObjects(By.desc("评论"));
        if(lists.size()> 0) {
            for (UiObject2 list : lists) {
                pinglun(comment);
            }
        }else {
            UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
            listview.scroll(Direction.DOWN, 1f, 500);
            pinglun(comment);
        }
    }

    public void pinglun(String comment){
        UiObject pinglun = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/co3"));
        if (pinglun.exists()) {
            try {
                pinglun.click();
                UiObject content = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/cp8"));
                content.setText(comment);
                UiObject send = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/cp_"));
                send.click();
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
//    com.tencent.mm:id/cts  朋友圈发的内容的id
//    com.tencent.mm:id/coj  或者  com.tencent.mm:id/crj朋友圈文章的id
//    com.tencent.mm:id/coz  评论按钮的id
//    com.tencent.mm:id/co2  取字是赞还是取消
//    com.tencent.mm:id/co3  评论打开按钮
//    com.tencent.mm:id/cp8  输入评论内容的位置
//    com.tencent.mm:id/cp_  发送按钮
//    com.tencent.mm:id/cu4  朋友圈加载的圈圈


}
