package com.data.model;

import java.sql.Timestamp;

public class tb_adminModel {
	private String Aid;
	private String Account;
	private String Password;
	private String Email;
	private String Privilege;
	private String Sid;
	private String Del;
	private String CreateTime;
	private String ChangeTime;
	private String DelTime;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDel() {
		return Del;
	}
	public void setDel(String del) {
		Del = del;
	}
	
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getChangeTime() {
		return ChangeTime;
	}
	public void setChangeTime(String changeTime) {
		ChangeTime = changeTime;
	}
	public String getDelTime() {
		return DelTime;
	}
	public void setDelTime(String delTime) {
		DelTime = delTime;
	}
	public String getAid() {
		return Aid;
	}
	public void setAid(String aid) {
		Aid = aid;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPrivilege() {
		return Privilege;
	}
	public void setPrivilege(String privilege) {
		Privilege = privilege;
	}
	public String getSid() {
		return Sid;
	}
	public void setSid(String sid) {
		Sid = sid;
	}
	
}
