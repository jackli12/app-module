package com.xp.app.template.bean;

/**
 * describe
 * date 2018/5/21
 * author xugaopan
 */

public class Water {
    private String ph;
    private String phquality;/*PH水质类别*/
    private String belong;/*属于流域*/

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPhquality() {
        return phquality;
    }

    public void setPhquality(String phquality) {
        this.phquality = phquality;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}
