package com.entity.resident;

public class Member_info
{
   private int id;
   private int hid;
   private String name;
   private String gender;
   private String familyRelation;
   private String workPlace;
   private String workPhoneNumber;
   private String mobileNumber;
   private String chuanHu;

   public int getHid() {
      return hid;
   }

   public void setHid(int hid) {
      this.hid = hid;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getFamilyRelation() {
      return familyRelation;
   }

   public void setFamilyRelation(String familyRelation) {
      this.familyRelation = familyRelation;
   }

   public String getWorkPlace() {
      return workPlace;
   }

   public void setWorkPlace(String workPlace) {
      this.workPlace = workPlace;
   }

   public String getWorkPhoneNumber() {
      return workPhoneNumber;
   }

   public void setWorkPhoneNumber(String workPhoneNumber) {
      this.workPhoneNumber = workPhoneNumber;
   }

   public String getMobileNumber() {
      return mobileNumber;
   }

   public void setMobileNumber(String mobileNumber) {
      this.mobileNumber = mobileNumber;
   }

   public String getChuanHu() {
      return chuanHu;
   }

   public void setChuanHu(String chuanHu) {
      this.chuanHu = chuanHu;
   }

   @Override
   public String toString() {
      return "Member_info{" +
              "name='" + name + '\'' +
              ", gender='" + gender + '\'' +
              ", familyRelation='" + familyRelation + '\'' +
              ", workPlace='" + workPlace + '\'' +
              ", workPhoneNumber='" + workPhoneNumber + '\'' +
              ", mobileNumber='" + mobileNumber + '\'' +
              ", chuanHu='" + chuanHu + '\'' +
              '}';
   }
}
