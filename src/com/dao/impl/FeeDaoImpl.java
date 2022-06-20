package com.dao.impl;

import com.dao.FeeDao;
import com.entity.record.EleRecord;
import com.entity.record.WaterRecord;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeeDaoImpl implements FeeDao {
    public List<WaterRecord> getWaterRecordAll() throws SQLException {
        String sql = "SELECT * FROM water_record";
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        List<WaterRecord> waterRecords = new ArrayList<>();//列表
        while(rs.next()){
            WaterRecord waterRecord = new WaterRecord();
            waterRecord.setRecord_id(rs.getInt("record_id"));
            waterRecord.setHid(rs.getInt("hid"));
            waterRecord.setMonth(rs.getInt("month"));
            waterRecord.setConsumption(rs.getInt("water_consumption"));
            waterRecord.setFee(rs.getInt("water_fee"));
            waterRecord.setStatus(rs.getString("status"));
            waterRecords.add(waterRecord);
        }
    return waterRecords;//得到了所有用户的集合
    }

    public List<EleRecord>getEleRecordAll() throws SQLException {
        String sql = "SELECT * FROM electricity_record";
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        List<EleRecord> eleRecords = new ArrayList<>();
        while(rs.next()){
            EleRecord eleRecord = new EleRecord();
            eleRecord.setHid(rs.getInt("hid"));
            eleRecord.setRecord_id(rs.getInt("record_id"));
            eleRecord.setMonth(rs.getInt("month"));
            eleRecord.setConsumption(rs.getInt("ele_consumption"));
            eleRecord.setFee(rs.getInt("ele_fee"));
            eleRecord.setStatus(rs.getString("status"));
            eleRecords.add(eleRecord);
        }
        return eleRecords;
    }

    public  List<EleRecord>getEleByHid(int hid, int m) throws SQLException {
        List<EleRecord> eleRecords = new ArrayList<>();
        String sql = null;
        if(m == 1)
        sql = "Select * from electricity_record where hid =" + hid;
        else {
            sql = "Select * from electricity_record where  month =" + hid;
        }
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        while(rs.next()){
            EleRecord eleRecord = new EleRecord();
            eleRecord.setRecord_id(rs.getInt("record_id"));
            eleRecord.setHid(rs.getInt("hid"));
            eleRecord.setMonth(rs.getInt("month"));
            eleRecord.setConsumption(rs.getInt("ele_consumption"));
            eleRecord.setFee(rs.getInt("ele_fee"));
            eleRecord.setStatus(rs.getString("status"));
            eleRecords.add(eleRecord);
        }
        DBconn.closeConn();
        return eleRecords;
    }
    public List<WaterRecord>getWaByHid(int hid, int m) throws SQLException {
        String sql = null;
        if(m == 1)
            sql = "SELECT * FROM water_record WHERE hid = " + hid;
        else{
            sql = "SELECT * FROM water_record WHERE month = " + hid;
        }
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        List<WaterRecord> waterRecords = new ArrayList<>();//列表
        while(rs.next()){
            WaterRecord waterRecord = new WaterRecord();
            waterRecord.setRecord_id(rs.getInt("record_id"));
            waterRecord.setHid(rs.getInt("hid"));
            waterRecord.setMonth(rs.getInt("month"));
            waterRecord.setConsumption(rs.getInt("water_consumption"));
            waterRecord.setFee(rs.getInt("water_fee"));
            waterRecord.setStatus(rs.getString("status"));
            waterRecords.add(waterRecord);
        }
        return waterRecords;
    }
    public WaterRecord editWaterById(int i) throws SQLException {
        WaterRecord waterRecord = new WaterRecord();
        String sql = "SELECT * from water_record where record_id =" + i;
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        if(rs.next()){
            waterRecord.setRecord_id(rs.getInt("record_id"));
            waterRecord.setHid(rs.getInt("hid"));
            waterRecord.setMonth(rs.getInt("month"));
            waterRecord.setConsumption(rs.getInt("water_consumption"));
            waterRecord.setFee(rs.getInt("water_fee"));
            waterRecord.setStatus(rs.getString("status"));
        }

        return waterRecord;//返回一条记录
    }

    public EleRecord editEleById(int i) throws SQLException {
        EleRecord eleRecord = new EleRecord();
        String sql = "SELECT * from electricity_record where record_id =" + i;
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        if(rs.next()){
            eleRecord.setRecord_id(rs.getInt("record_id"));
            eleRecord.setHid(rs.getInt("hid"));
            eleRecord.setMonth(rs.getInt("month"));
            eleRecord.setConsumption(rs.getInt("ele_consumption"));
            eleRecord.setFee(rs.getInt("ele_fee"));
            eleRecord.setStatus(rs.getString("status"));
        }

        return eleRecord;
    }


    public boolean update(String sql){
        DBconn.init();
        int count = DBconn.addUpdDel(sql);
        if(count == 0){
            return false;
        }
        DBconn.closeConn();
        return true;
    }



}
