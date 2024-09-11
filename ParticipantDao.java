package com.cisco.funfit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ParticipantDao 
{
      private Connection connection;
      
      public ParticipantDao()
      {
    	  connection = MainConfig.getConnection();
      }
      
      //add participant
      public void addParticipant(Participant participant)
      {
    	  try 
    	  {
    		  PreparedStatement preparedStatement = connection.prepareStatement("insert into participant(participantname,participantage,participantHeight,participantweight,participantnumber,participantemail,participanttime,participantdate)values(?, ?, ?, ?,?,?,?,? )");
              preparedStatement.setString(1, participant.getName());
              preparedStatement.setInt(2, participant.getAge());
              preparedStatement.setInt(3, participant.getHeight());
              preparedStatement.setInt(4, participant.getWeight());
              preparedStatement.setInt(5, participant.getPhonenumber());
              preparedStatement.setString(6, participant.getEmail());
              preparedStatement.setTime(7, participant.getTime());
              preparedStatement.setString(8,participant.getJdate());
              preparedStatement.executeUpdate();
              
    	  }
    	  catch(SQLException e)
    	  {
    		  e.printStackTrace();
    	  }
      }
      
      //delete participant
      public void deleteParticipant(int id)
      {
    	  try 
    	  {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from participant where id=?");
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		  } 
    	  catch (SQLException e) 
    	  {
    		  e.printStackTrace();
		}
      }
      
      //update participant
      public void updateParticipant(Participant participant)
      {
    	  try 
    	  {
			PreparedStatement preparedStatement = connection.prepareStatement("update participant set participantname=?,participantage=?,participantHeight=?,participantweight=?,participantnumber=?,participantemail=?,participanttime=?,participantdate=?"+"where id=?");
			 preparedStatement.setString(1, participant.getName());
             preparedStatement.setInt(2, participant.getAge());
             preparedStatement.setInt(3, participant.getHeight());
             preparedStatement.setInt(4, participant.getWeight());
             preparedStatement.setInt(5, participant.getPhonenumber());
             preparedStatement.setString(6, participant.getEmail());
             preparedStatement.setTime(7, participant.getTime());
             preparedStatement.setString(8, participant.getJdate());
             preparedStatement.executeUpdate();
    	  
    	  } 
    	  catch (SQLException e) 
    	  {
			
    		  e.printStackTrace();
		  }
      }
      
      public List<Participant> getAllParticipant()
      {
    	  List<Participant> participants = new ArrayList<Participant>();
    	  try 
    	  {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from participant");
			
			while(rs.next())
			{
				Participant partici = new Participant();
				partici.setId(rs.getInt("id"));
				partici.setName(rs.getString("participantname"));
				partici.setAge(rs.getInt("participantage"));
				partici.setHeight(rs.getInt("participantHeight"));
				partici.setWeight(rs.getInt("participantweight"));
				partici.setPhonenumber(rs.getInt("participantnumber"));
				partici.setEmail(rs.getString("participantemail"));
				partici.setTime(rs.getTime("participanttime"));
				partici.setJdate(rs.getString("participantDate"));
				participants.add(partici);
			}
		  } 
    	  catch (SQLException e) 
    	  {
    		  e.printStackTrace();
		}
    	  return participants;
    	  
      }
      
      //getparticipantId
      public Participant getParticipantById(int id)
      {
    	  Participant partici = new Participant();
    	  try 
    	  {
			PreparedStatement preparedStatement =connection.prepareStatement("select * from participant where id=?");
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				partici.setId(rs.getInt("id"));
				partici.setName(rs.getString("participantname"));
				partici.setAge(rs.getInt("participantage"));
				partici.setHeight(rs.getInt("participantHeight"));
				partici.setWeight(rs.getInt("participantweight"));
				partici.setPhonenumber(rs.getInt("participantnumber"));
				partici.setEmail(rs.getString("participantemail"));
				partici.setTime(rs.getTime("participanttime"));
				partici.setJdate(rs.getString("participantDate"));
				
			}
			
		  } 
    	  catch (SQLException e) 
    	  {
    		  e.printStackTrace();
		}
    	  return partici;
      }
      
}
