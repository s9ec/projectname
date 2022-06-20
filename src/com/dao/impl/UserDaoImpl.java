package com.dao.impl;

import com.dao.UserDao;
import com.entity.resident.User;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
	
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();//增删改
		int i =DBconn.addUpdDel("insert into user(name,pwd,level,sex,userName) " + "values('"+user.getName()+"','"+
				user.getPwd()+ "',"+user.getLevel()+ ",'" + user.getGender() +"','" + user.getUserName()   + "')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

    public boolean login(String name, String pwd,int level) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"' and level = " + level);//查询
				while(rs.next()){
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<User> getUserAll() {
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user");
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setLevel(rs.getInt("level"));
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getString("sex"));
				user.setKinds();
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(int id,String name, String pwd,int level, String userName, String gender) {
		boolean flag = false;
		DBconn.init();
		String sql ="update user set name ='"+name
				+"',pwd ='"+pwd+"',level="+level + ",userName ='" +userName + "',sex ='" + gender +
				 "' where id ="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public int count() throws SQLException {
		int ans = -1;
		DBconn.init();
		String sql = "select count(*) from user";
		ResultSet rs = DBconn.selectSql(sql);
		if(rs.next()){
			ans = rs.getInt("count(*)");
		}
		DBconn.closeConn();
		return ans;
	}

	public boolean delete(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from user where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public User getById(int id) throws SQLException {
		User user = new User();
		DBconn.init();
		String sql = "SELECT * FROM USER where id = " +id;
		ResultSet rs = DBconn.selectSql(sql);
		if(rs.next()){
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("pwd"));
			user.setLevel(rs.getInt("level"));
			user.setGender(rs.getString("sex"));
			user.setUserName(rs.getString("userName"));
			user.setKinds();
		}
		return user;
	}

	public boolean repeat(String name) throws SQLException {
		String sql = "SELECT * FROM user WHERE name ='" + name+ "'";
		DBconn.init();
		ResultSet rs = DBconn.selectSql(sql);
		if(rs.next()){
			return true;
		}
		return false;
	}

}
