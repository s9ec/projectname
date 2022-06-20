package com.entity.resident;
 
public class User {
    private int id;
    private String name;
    private String pwd;
	private int level;
	private String kind;
	String userName;
	String gender;
	public String getKind() {
		return kind;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setKinds(){
		if(this.level == 1)
			kind = "管理员";
		else if(this.level == 2)
			kind = "员工";
		else if(this.level == 3)
			kind = "住户";
		else
			kind = "禁用";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}