package com.dao;

import com.entity.worker.Absent;
import com.entity.worker.Worker;
import com.entity.worker.schedule;

import java.sql.SQLException;
import java.util.*;
public interface WorkerDao {
    List<Worker> getWorkerAll() throws SQLException;

    boolean update(String sql);

    Worker getWorker(String sql) throws SQLException;

    List<Worker> searchWorker(String sql) throws SQLException;

    List<Absent> getUnapproved(String sql) throws SQLException;

    boolean pi(String sql);

    List<schedule> getSchedule() throws SQLException;

    int getDay();

    boolean getWorkerId(String name, int day) throws SQLException;

    String job(String name) throws SQLException;

}