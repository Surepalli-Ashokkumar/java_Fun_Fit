package com.cisco.funfit;
import java.sql.Time;

public class Batch 
{
      private int id;
      private String name;
      private Time time;
      
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
	public Time getTime() 
	{
		return time;
	}
	public void setTime(Time time) 
	{
		this.time = time;
	}
	
}
