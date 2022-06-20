package com.entity;

public class facility {
    private int facility_id;
    private String facility_name;
    private String facility_business;
    private String phone;
    private String duty_people;
    private String control_people;
    private int money;

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_business() {
        return facility_business;
    }

    public void setFacility_business(String facility_business) {
        this.facility_business = facility_business;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDuty_people() {
        return duty_people;
    }

    public void setDuty_people(String duty_people) {
        this.duty_people = duty_people;
    }

    public String getControl_people() {
        return control_people;
    }

    public void setControl_people(String control_people) {
        this.control_people = control_people;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "facility{" +
                "facility_id=" + facility_id +
                ", facility_name='" + facility_name + '\'' +
                ", facility_business='" + facility_business + '\'' +
                ", phone='" + phone + '\'' +
                ", duty_people='" + duty_people + '\'' +
                ", control_people='" + control_people + '\'' +
                ", money=" + money +
                '}';
    }
}

