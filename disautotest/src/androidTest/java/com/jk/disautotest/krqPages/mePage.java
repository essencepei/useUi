package com.jk.disautotest.krqPages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.v4.view.ScrollingView;

import com.jk.disautotest.bases.BasePage;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class mePage extends BasePage {
    String exchange = "交易记录";
    String tihuanshebei = "替换设备";
    public UiObject2 scrollView = myFindObjectByClass(ScrollingView.class);
    public UiObject2 countAddFriend(){
        return scrollView.getChildren().get(0);
    }

    public UiObject2 countAddGroup(){
        return scrollView.getChildren().get(2);
    }

    public UiObject2 countAccountManage(){
        return scrollView.getChildren().get(4);
    }
    public UiObject2 countDevice(){
        return scrollView.getChildren().get(6);
    }
    public UiObject2 countBuyedService(){
        return scrollView.getChildren().get(8);
    }
    public UiObject2 exchangeHistory(){
        return mUIDevice.findObject(By.text(exchange));
    }
    public UiObject2 tihuanSheBei(){
        return mUIDevice.findObject(By.text(tihuanshebei));
    }

}
