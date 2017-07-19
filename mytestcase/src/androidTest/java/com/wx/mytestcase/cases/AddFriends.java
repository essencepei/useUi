package com.wx.mytestcase.cases;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.widget.TextView;

import com.wx.mytestcase.bases.Base;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class AddFriends extends Base {

   @Test
    public void add() throws UiObjectNotFoundException {
       findTextAndClick("通讯录");
       UiObject more = mUIDevice.findObject(new UiSelector().description("更多功能按钮"));
       more.clickAndWaitForNewWindow();
       ClickAndWait("添加朋友");

      List<String> lists = new ArrayList<>();
      lists.add("13657296691");
      searchAdd(lists);
   }

   public void  searchAdd(List<String> lists){
      for(String list : lists){
         mUIDevice.findObject(By.clazz(TextView.class)).clickAndWait(Until.newWindow(),2000);
         mUIDevice.findObject(By.text("搜索")).setText(list);
      }
   }

}
