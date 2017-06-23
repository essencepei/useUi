package com.wx.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button runBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * 打开微信对应的方法
     * @param v
     */
    public void seeCircle(View v) {
        Log.i(TAG, "runSeeCircle: ");
        String command = "am instrument --user 0 -w -r   -e debug false -e class com.wx.mytestcase.OpenWx com.wx.mytestcase.test/android.support.test.runner.AndroidJUnitRunner";
        execRootCmd(command);
    }
    public void addFromPhone(View v) {
        Log.i(TAG, "runAddFromPhone: ");
        String command = "am instrument --user 0 -w -r   -e debug false -e class com.wx.mytestcase.OpenWx com.wx.mytestcase.test/android.support.test.runner.AndroidJUnitRunner";
        execRootCmd(command);
    }
    public void addFromWx(View v) {
        Log.i(TAG, "runAddFromWx: ");
        String command = "am instrument --user 0 -w -r   -e debug false -e class com.wx.mytestcase.OpenWx com.wx.mytestcase.test/android.support.test.runner.AndroidJUnitRunner";
        execRootCmd(command);
    }
    public void runMyUiautomator(View v) {
        Log.i(TAG, "runMyUiautomator: ");
//        String command ="am instrument --user 0 -w -r   -e debug false -e class com.wx.mytestcase.OpenSettings com.wx.mytestcase.test/android.support.test.runner.AndroidJUnitRunner";
/*        String command = "am start -n com.tencent.mm/.ui.LauncherUI";
         try {
                    Runtime.getRuntime().exec(command);
                }catch (Exception e){
                    System.out.println("完了");
                    e.printStackTrace();
                }*/
//                UiautomatorThread uimator = new UiautomatorThread();
//                uimator.start();

        String command = "am instrument --user 0 -w -r   -e debug false -e class com.wx.mytestcase.OpenWx com.wx.mytestcase.test/android.support.test.runner.AndroidJUnitRunner";

        execRootCmd(command);
    }
    /**
     * 运行uiautomator是个费时的操作，不应该放在主线程，因此另起一个线程运行
     */

    class UiautomatorThread extends Thread {
        @Override
        public void run() {
            super.run();
            String command = "am start -n com.tencent.mm/.ui.LauncherUI";
//            String command ="am start -n com.android.settings/.Settings";
//            String command ="am instrument --user 0 -w -r   -e debug false -e class com.wx.mytestcase.OpenSettings com.wx.mytestcase.test/android.support.test.runner.AndroidJUnitRunner";
//            String command = generateCommand("com.wx.mytestcase", "OpenSettings", "demo");
            CMDUtils.CMD_Result rs = CMDUtils.runCMD(command, true, true);
            Log.e(TAG, "run: " + rs.error + "-------" + rs.success);
        }
        /**
         * 生成命令
         * @param pkgName 包名
         * @param clsName 类名
         * @param mtdName 方法名
         * @return
         */
        public String generateCommand(String pkgName, String clsName, String mtdName) {
            String command = "am instrument  --user 0 -w -r   -e debug false -e class "
                    + pkgName + "." + clsName + "#" + mtdName + " "
                    + pkgName + ".test/android.support.test.runner.AndroidJUnitRunner";
            Log.e("test1: ", command);
            return command;
        }
    }

    class myThread extends  Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("線程啟動成功");
        }
    }

    public static String execRootCmd(String cmd) {
        String result = "";
        DataOutputStream dos = null;
        DataInputStream dis = null;

        try {
            // 经过Root处理的android系统即有su命令
            Process p = Runtime.getRuntime().exec("su");
            dos = new DataOutputStream(p.getOutputStream());
            dis = new DataInputStream(p.getInputStream());

            Log.i(TAG, cmd);
            dos.writeBytes(cmd + "\n");
            dos.flush();
            dos.writeBytes("exit\n");
            dos.flush();
            String line = null;
            while ((line = dis.readLine()) != null) {
                Log.d(TAG + "result： ", line);
                result += line;
            }
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
