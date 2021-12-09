package com.infoserver.domain;

public class AuthorizedVO {
	private String id;
	private String name;
	private String position;
	private String date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AutorizedVO [id=" + id + ", name=" + name + ", position=" + position + ", date=" + date + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getPosition()=" + getPosition() + ", getDate()=" + getDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
