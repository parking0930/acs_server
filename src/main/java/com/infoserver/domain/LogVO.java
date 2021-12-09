package com.infoserver.domain;

public class LogVO {
	private String id;
	private String uid;
	private String name;
	private String picture;
	private String allow;
	private String date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAllow() {
		return allow;
	}
	public void setAllow(String allow) {
		this.allow = allow;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "LogVO [id=" + id + ", uid=" + uid + ", name=" + name + ", picture=" + picture + ", allow=" + allow
				+ ", date=" + date + ", getId()=" + getId() + ", getUid()=" + getUid() + ", getName()=" + getName()
				+ ", getPicture()=" + getPicture() + ", getAllow()=" + getAllow() + ", getDate()=" + getDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
