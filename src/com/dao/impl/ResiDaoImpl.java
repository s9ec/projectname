package com.dao.impl;

import com.dao.ResiDao;
import com.entity.resident.Address;
import com.entity.resident.Member_info;
import com.entity.resident.Resi_info;
import com.entity.resident.Resident;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResiDaoImpl implements ResiDao {
    public List<Resident> getResiAll() {
        List<Resident> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from household_information a left join position_of_user b on a.hid = b.hid left join work_information c on a.work = c.work");
            while(rs.next()){
                int hid = 0;
                Resident resident = new Resident();
                Address address = new Address();
                address.setCommunityNumber(rs.getInt("community_id"));
                address.setBuildingNumber(rs.getInt("building_id"));
                address.setUnitNumber(rs.getInt("unit_id"));
                address.setRoomNumber(rs.getInt("room_id"));
                resident.setAddress(address);
                Resi_info resi_info = new Resi_info();
                hid = rs.getInt("hid");
                resi_info.setHid(rs.getInt("hid"));
                resi_info.setHouseOwnerName(rs.getString("household_name"));
                resi_info.setHouseOwnerGender(rs.getString("sex"));
                resi_info.setHousePhoneNumber1(rs.getString("family_phone1"));
                resi_info.setHousePhoneNumber2(rs.getString("family_phone2"));
                resi_info.setHouseOwnerChuanHu(rs.getString("fax"));
                resi_info.setMobileNumber(rs.getString("mobile_phone"));
                resi_info.setWorkName(rs.getString("work"));
                resi_info.setWorkPhoneNumber(rs.getString("work_phone"));
                resi_info.setWorkAddress(rs.getString("work_position"));
                resident.setResi_info(resi_info);
                ResultSet rs1 = DBconn.selectSql("select id,fname,msex,frelation,wplace,mp,fn from familymember_information  where hid =" + hid);
                while(rs1.next()){//当它有家庭成员时
                    Member_info member_info = new Member_info();
                    member_info.setId(rs1.getInt("id"));
                    member_info.setName(rs1.getString( "fname"));
                    member_info.setGender(rs1.getString("msex"));
                    member_info.setFamilyRelation(rs1.getString("frelation"));
                    member_info.setWorkPlace(rs1.getString("wplace"));
                    member_info.setMobileNumber(rs1.getString("mp"));
                    member_info.setChuanHu(rs1.getString("fn"));
                    resident.addMember_infos(member_info);
                }
                resident.setName(resi_info.getHouseOwnerName());
                resident.setId(address.getUnitNumber());
                resident.setPwd(resi_info.getHousePhoneNumber1());

                list.add(resident);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ResiDaoImpl{}";
    }

    public List<Member_info> getFamily(int hid) throws SQLException {
        List<Member_info> list = new ArrayList<>();
        DBconn.init();
        String sql = "SELECT * from familymember_information where hid = " + hid;//找到它的家庭成员
        ResultSet rs = DBconn.selectSql(sql);
        while(rs.next()){
            Member_info m = new Member_info();
            m.setId(rs.getInt("id"));//得到id啦
            m.setName(rs.getString("fname"));
            m.setGender(rs.getString("msex"));
            m.setFamilyRelation(rs.getString("frelation"));
            m.setWorkPlace(rs.getString("wplace"));
            m.setMobileNumber(rs.getString("mp"));
            m.setChuanHu(rs.getString("fn"));
            list.add(m);
        }
        DBconn.closeConn();
        return list;
    }

    public Member_info FamilyMember(int id) throws SQLException {
        Member_info m = new Member_info();
        DBconn.init();
        String sql = "SELECT * from familymember_information where id = " + id;//找到它的家庭成员
        ResultSet rs = DBconn.selectSql(sql);
        if(rs.next()) {
            m.setId(rs.getInt("id"));//得到id啦
            m.setHid(rs.getInt("hid"));//得到Hid啦
            m.setName(rs.getString("fname"));
            m.setGender(rs.getString("msex"));
            m.setFamilyRelation(rs.getString("frelation"));
            m.setWorkPlace(rs.getString("wplace"));
            m.setMobileNumber(rs.getString("mp"));
            m.setChuanHu(rs.getString("fn"));
        }
        DBconn.closeConn();
        return m; //返回一个成员信息
    }

    public boolean exist(Address address) throws SQLException {
        boolean flag = false;//本不存在
        int community = address.getCommunityNumber();
        int building = address.getBuildingNumber();
        int unit = address.getUnitNumber();
        int room = address.getRoomNumber();
        String sql =  "select count(*) from position_of_user where community_id = " + community + " and building_id = " + building
                + " and unit_id = " + unit + " and room_id = " + room;
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        int count = 0;
        if(rs.next()){
             count = rs.getInt("count(*)");
             if(count != 0){
                 flag = true;//有重复的啦
             }
        }
        return flag;
    }

    public boolean update(String sql){
        boolean flag = true;
        DBconn.init();
        int count  = DBconn.addUpdDel(sql);
        DBconn.closeConn();
        if(count == 0){
            flag = false;
        }
        return flag;
    }

    public List<Resident> queryInfo(String info,String method) throws SQLException {
        String sql = "SELECT * FROM household_information a join position_of_user b on a.hid = b.hid ";
        if(method.equals("1"))//以楼宇号查找
        {
            sql += "where building_id = " + info;
        }
        else if( method.equals("2")){//以单元号查找
            sql += "where unit_id = " + info;
        }
        else if (method.equals("3")){ //以房间号查找
            sql += "where room_id = " + info;
        }else if (method.equals("4")){ //以住户编号查找
            sql += "where a.hid = " + info;
        }else if (method.equals("5")){ //以户主姓名查找
            sql += "where household_name = '" + info + "'";
        }
    List<Resident> residents = new ArrayList<>();
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);//得到列表
        while(rs.next()){
            Resident resident = new Resident();
            Address address = new Address();
            address.setCommunityNumber(rs.getInt("community_id"));
            address.setBuildingNumber(rs.getInt("building_id"));
            address.setUnitNumber(rs.getInt("unit_id"));
            address.setRoomNumber(rs.getInt("room_id"));
            resident.setAddress(address);
            Resi_info resi_info = new Resi_info();
            resi_info.setHid(rs.getInt("hid"));
            resi_info.setWorkName(rs.getString("work"));
            resi_info.setHousePhoneNumber1(rs.getString("family_phone1"));
            resi_info.setHousePhoneNumber2(rs.getString("family_phone2"));
            resi_info.setHouseOwnerName(rs.getString("household_name"));
            resi_info.setMobileNumber(rs.getString("mobile_phone"));
            resi_info.setHouseOwnerGender(rs.getString("sex"));
            resident.setResi_info(resi_info);
            List<Member_info> list = getFamily(resi_info.getHid());//得到家庭成员列表
            resident.setMember_infos(list);
            residents.add(resident);
        }
        DBconn.closeConn();
        return residents;//返回这个住户信息
    }

    public  boolean delete(int hid){
        String sql = "DELETE FROM household_information where hid = " + hid;
        String sql2 = "DELETE FROM familymember_information where hid = " + hid;
        String sql3 = "DELETE FROM position_of_user where hid = " + hid;
        DBconn.init();
        int count1 = DBconn.addUpdDel(sql);
        int count2 = DBconn.addUpdDel(sql2);
        int count3 = DBconn.addUpdDel(sql3);
        return true;
    }

    public  boolean deleteMember(int id){
        String sql = "DELETE FROM familymember_information where id = " + id;
        DBconn.init();
        int count = DBconn.addUpdDel(sql);
        System.out.println(count);
        DBconn.closeConn();
        return true;
    }

}
