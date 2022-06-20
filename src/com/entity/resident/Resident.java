package com.entity.resident;

import java.util.ArrayList;
import java.util.List;

public class Resident {
    private Address address;
    private Resi_info resi_info;
    List<Member_info> member_infos = new ArrayList<>();
    private int id;
    private String name;
    private String pwd;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Resi_info getResi_info() {
        return resi_info;
    }

    public void setResi_info(Resi_info resi_info) {
        this.resi_info = resi_info;
    }

    public List<Member_info> getMember_infos() {
        return member_infos;
    }

    public void addMember_infos(Member_info m){
        member_infos.add(m);//添加家庭成员
    }

    public void setMember_infos(List<Member_info> member_infos) {
        this.member_infos = member_infos;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "address=" + address +
                ", resi_info=" + resi_info +
                ", member_infos=" + member_infos +
                '}';
    }
}
