package com.entity.resident;

public class Address {

    private int unitNumber;
    private int buildingNumber;
    private int communityNumber;
    private int roomNumber;


    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getCommunityNumber() {
        return communityNumber;
    }

    public void setCommunityNumber(int communityNumber) {
        this.communityNumber = communityNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber=" + unitNumber +
                ", buildingNumber=" + buildingNumber +
                ", communityNumber=" + communityNumber +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
