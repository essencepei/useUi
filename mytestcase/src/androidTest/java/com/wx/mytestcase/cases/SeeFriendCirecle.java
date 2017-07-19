package com.wx.mytestcase.cases;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.widget.ListView;

import com.wx.mytestcase.bases.Base;

import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class SeeFriendCirecle extends Base {

    @Test
    public void friendcircle() throws InterruptedException {
        findTextAndClick("发现");
//        findTextAndClick("朋友圈");
//        UiObject pyq = mUIDevice.findObject(new UiSelector().resourceId("android:id/title"));
//        点击朋友圈并等待新的窗口出现再执行下一步
        UiObject2 pyq1 = mUIDevice.findObject(By.text("朋友圈"));
        pyq1.clickAndWait(Until.newWindow(),2000);

        comment();
        for (int i = 0; i < 10; i++) {
            UiObject2 listview = mUIDevice.findObject(By.clazz(ListView.class));
            listview.scroll(Direction.DOWN, 1f, 500);
            comment();
        }
    }

    public void comment(){
//        获取背景的高度，滚动过去

        UiObject miny = mUIDevice.findObject(new UiSelector().description("更多功能按钮"));
        UiObject maxy = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/co6"));

        int min_y = 0;
        int max_y = 0;
        try {
            min_y = miny.getBounds().bottom;
            max_y = maxy.getBounds().bottom;
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }


        List<UiObject2> buttons = mUIDevice.findObjects(By.desc("评论"));

        if(buttons.size()> 0) {
            for (UiObject2 button : buttons) {
                int y1 = button.getVisibleBounds().centerY();
                if(y1 > min_y && y1 < max_y){
                    button.click();
                    UiObject zan = mUIDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/co2"));
//                等到元素出现之后执行下一步
                    zan.waitForExists(2000);
                    if (zan.exists()) {
                        try {
                            String target = zan.getText().toString();
                            if (target.equals("赞")){
                                zan.click();
                            }else {
                                button.click();
                            }
                        } catch (UiObjectNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
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
