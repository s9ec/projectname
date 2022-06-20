package com.entity;

public class record_info {
    private int record_id;
    private String use_name ;
    private int use_number;
    private String use_state;
    private int use_money;
    private int month;
    private int day;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    public int getUse_number() {
        return use_number;
    }

    public void setUse_number(int use_number) {
        this.use_number = use_number;
    }

    public String getUse_state() {
        return use_state;
    }

    public void setUse_state(String use_state) {
        this.use_state = use_state;
    }

    public int getUse_money() {
        return use_money;
    }

    public void setUse_money(int use_money) {
        this.use_money = use_money;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "facility_record{" +
                "record_id=" + record_id +
                ", use_name='" + use_name + '\'' +
                ", use_number=" + use_number +
                ", use_state='" + use_state + '\'' +
                ", use_money=" + use_money +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

