package com.xp.template.framework.bean;

/**
 * describe
 * date 2018/5/18
 * author xugaopan
 */

public class CityBean {
    private String id;
    private String province;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
