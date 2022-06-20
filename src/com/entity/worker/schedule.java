package com.entity.worker;

public class schedule {
    private String xingqiji;
    private String baoan;
    private String baojie;
    private String chengxu;
    private String weixiu;

    public schedule(){
        xingqiji = "无";
        baoan = "无";
        baojie = "无";
        chengxu = "无";
        weixiu = "无";
    }

    public String getXingqiji() {
        return xingqiji;
    }

    public void setXingqiji(String xingqiji) {
        this.xingqiji = xingqiji;
    }

    public String getBaoan() {
        return baoan;
    }

    public void setBaoan(String baoan) {
        this.baoan = baoan;
    }

    public String getBaojie() {
        return baojie;
    }

    public void setBaojie(String baojie) {
        this.baojie = baojie;
    }

    public String getChengxu() {
        return chengxu;
    }

    public void setChengxu(String chengxu) {
        this.chengxu = chengxu;
    }

    public String getWeixiu() {
        return weixiu;
    }

    public void setWeixiu(String weixiu) {
        this.weixiu = weixiu;
    }
}
