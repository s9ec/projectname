package com.entity.resident;

public class Resi_info {
    private String houseOwnerName;
    private String houseOwnerGender;
    private String housePhoneNumber1;
    private String HousePhoneNumber2;
    private String houseOwnerChuanHu;
    private String mobileNumber;
    private String workName;
    private String workPhoneNumber;
    private String workAddress;
    private Time checkInTime;
    private int hid;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHouseOwnerName() {
        return houseOwnerName;
    }

    public void setHouseOwnerName(String houseOwnerName) {
        this.houseOwnerName = houseOwnerName;
    }

    public String getHouseOwnerGender() {
        return houseOwnerGender;
    }

    public void setHouseOwnerGender(String houseOwnerGender) {
        this.houseOwnerGender = houseOwnerGender;
    }

    public String getHousePhoneNumber1() {
        return housePhoneNumber1;
    }

    public void setHousePhoneNumber1(String housePhoneNumber1) {
        this.housePhoneNumber1 = housePhoneNumber1;
    }

    public String getHousePhoneNumber2() {
        return HousePhoneNumber2;
    }

    public void setHousePhoneNumber2(String housePhoneNumber2) {
        HousePhoneNumber2 = housePhoneNumber2;
    }

    public String getHouseOwnerChuanHu() {
        return houseOwnerChuanHu;
    }

    public void setHouseOwnerChuanHu(String houseOwnerChuanHu) {
        this.houseOwnerChuanHu = houseOwnerChuanHu;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Time getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return "Resi_info{" +
                "houseOwnerName='" + houseOwnerName + '\'' +
                ", houseOwnerGender='" + houseOwnerGender + '\'' +
                ", housePhoneNumber1='" + housePhoneNumber1 + '\'' +
                ", HousePhoneNumber2='" + HousePhoneNumber2 + '\'' +
                ", houseOwnerChuanHu='" + houseOwnerChuanHu + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", workName='" + workName + '\'' +
                ", workPhoneNumber='" + workPhoneNumber + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", checkInTime=" + checkInTime +
                '}';
    }
}
