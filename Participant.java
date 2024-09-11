package com.cisco.funfit;
import java.util.Date;
import java.sql.Time;


public class Participant 
{
    private int id;
    private String name;
    private int age;
    private int height;
    private int weight;
    private int phonenumber;
    private String email;
    private Time time;
    private String jdate;
    
    
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	public int getWeight() 
	{
		return weight;
	}
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
	public int getPhonenumber() 
	{
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) 
	{
		this.phonenumber = phonenumber;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public Time getTime() 
	{
		return time;
	}
	public void setTime(Time time) 
	{
		this.time = time;
	}
	public String getJdate() 
	{
		return jdate;
	}
	public void setJdate(String jdate) 
	{
		this.jdate = jdate;
	}
	
}
