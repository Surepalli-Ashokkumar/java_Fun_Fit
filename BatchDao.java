package com.cisco.funfit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BatchDao 
{
	    private Connection connection;

	    public BatchDao() {
	        connection = MainConfig.getConnection();
	    }

	    // Add Batch
	    public void addBatch(Batch batch) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into batch(batchname, batchtime) values (?, ?)");
	            preparedStatement.setString(1, batch.getName());
	            preparedStatement.setTime(2, batch.getTime());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Delete Batch
	    public void deleteBatch(int id) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from batch where id=?");
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Update Batch
	    public void updateBatch(Batch batch) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update batch set batchname=?, batchtime=? where id=?");
	            preparedStatement.setString(1, batch.getName());
	            preparedStatement.setTime(2, batch.getTime());
	            preparedStatement.setInt(3, batch.getId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Get All Batches
	    public List<Batch> getAllBatches() {
	        List<Batch> batches = new ArrayList<>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from batch");

	            while (rs.next()) {
	                Batch batch = new Batch();
	                batch.setId(rs.getInt("id"));
	                batch.setName(rs.getString("batchname"));
	                batch.setTime(rs.getTime("batchtime"));
	                batches.add(batch);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return batches;
	    }

	    // Get Batch by Id
	    public Batch getBatchById(int id) {
	        Batch batch = new Batch();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from batch where id=?");
	            preparedStatement.setInt(1, id);

	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                batch.setId(rs.getInt("id"));
	                batch.setName(rs.getString("batchname"));
	                batch.setTime(rs.getTime("batchtime"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return batch;
	    }
	

}
