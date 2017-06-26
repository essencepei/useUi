package com.wx.mytest.service;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * 自动安装
 * <p>
 */

public class AutoInstallAccessibilityService extends BaseAccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        super.onAccessibilityEvent(event);
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&
                event.getPackageName().equals("com.android.packageinstaller")) {
            AccessibilityNodeInfo nodeInfo = findViewByText("安装", true);
            if (nodeInfo != null) {
                performViewClick(nodeInfo);
            }
        }
    }
}
