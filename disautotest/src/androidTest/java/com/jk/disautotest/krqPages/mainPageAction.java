package com.jk.disautotest.krqPages;

public class mainPageAction {
    mainPage mp = new mainPage();
    public void goDevicePage(){
        mp.deviceButton().click();
    }
    public void goProcessPage(){
        mp.jinChengButton().click();
    }
    public void goServicePage(){
        mp.serviceButton().click();
    }
    public void goMePage(){
        mp.meButton().click();
    }
}
