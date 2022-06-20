package com.dao;

import com.entity.resident.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {//接口
	
	public boolean login(String name,String pwd,int level);//登录
	public boolean register(User user);//注册
	public List<User> getUserAll();//返回用户信息集合
	public boolean delete(int id) ;//根据id删除用户
	public boolean update(int id,String name, String pwd, int level,String userName,String gender) ;//更新用户信息
	public int count() throws SQLException;
	User getById(int id) throws SQLException;
	boolean repeat(String name) throws SQLException;
}
