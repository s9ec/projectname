package com.dao;

import com.entity.record.EleRecord;
import com.entity.record.WaterRecord;

import java.sql.SQLException;
import java.util.List;

public interface FeeDao {
    List<WaterRecord> getWaterRecordAll() throws SQLException;
    List<EleRecord>getEleRecordAll()throws SQLException;
    List<EleRecord>getEleByHid(int hid, int m) throws SQLException;
    List<WaterRecord>getWaByHid(int hid, int m) throws SQLException;
    WaterRecord editWaterById(int i) throws SQLException;
    boolean update(String sql);
    EleRecord editEleById(int i) throws SQLException;
}
