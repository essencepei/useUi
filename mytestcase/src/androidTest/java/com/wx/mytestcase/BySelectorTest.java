package com.wx.mytestcase;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.widget.Button;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.regex.Pattern;


/**
 * Created by Administrator on 2017/6/16 0016.
 */
@RunWith(AndroidJUnit4.class)
public class BySelectorTest {
    UiDevice uiDevice;
    Instrumentation instrumentation;

    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }

    @Test
    public void testBySelectBy(){
        UiObject2 uiObject2 = uiDevice.findObject(By.text("设置"));
        uiObject2.click();
    }

    @Test
    public void testDepth(){
        UiObject2 uiObject2 = uiDevice.findObject(By.depth(7));
        uiObject2.click();

        UiObject2 uiObject3 = uiDevice.findObject(By.text("1").depth(3, 7));
        uiObject3.click();

        UiObject2 uiObject4 = uiDevice.findObject(By.text("1").maxDepth(7));
        uiObject4.click();

        UiObject2 uiObject5 = uiDevice.findObject(By.text("1").minDepth(3));
        uiObject5.click();
    }

    @Test
    public void testNormal(){
        Pattern p = Pattern.compile("[2-9]");
        UiObject2 uiObject2 = uiDevice.findObject(By.text(p).clazz(Button.class));
        uiObject2.click();
    }

    @Test
    public void testBoolean(){
        UiObject2 uiObject2 = uiDevice.findObject(By.checkable(true));
        uiObject2.click();
        sleep(1000);
        uiObject2.click();
    }


    public void sleep(int sleep){
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
