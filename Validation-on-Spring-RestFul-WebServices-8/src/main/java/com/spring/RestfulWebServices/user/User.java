package com.spring.RestfulWebServices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


public class User
{
   private Integer  id;
   @Size(min=2)
    private String name;
   @Past
   private Date birthdate;
   public User() {
	   super();
   }
public User(int id, String name, Date birthdate) {
	super();
	this.id = id;
	this.name = name;
	this.birthdate = birthdate;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id=id;
}
public String getName() {
	return name;
}
public Date getBirthdate() {
	return birthdate;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
}
   
   
}
