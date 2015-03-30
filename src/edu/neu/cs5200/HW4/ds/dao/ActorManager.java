package edu.neu.cs5200.HW4.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.cs5200.HW4.ds.model.*;

public class ActorManager {
	
	DataSource ds;
	
	//constructor	
	public ActorManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200HW4DB");
			System.out.println(ds);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//create a Actor
	public void createActor(Actor newActor) {
		String sql = "insert into Actor values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newActor.getFirstName());
			statement.setString(2, newActor.getLastName());
			statement.setDate(3,newActor.getDateOfBirth());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//retrieve all Actors 
	
	public List<Actor> readAllActors()   {
		List<Actor> actors = new ArrayList<Actor>();
		String sql = "select * from Actor";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Actor actor = new Actor();
				actor.setId(results.getInt("id"));
				actor.setFirstName(results.getString("firstName"));
				actor.setLastName(results.getString("lastName"));
				actor.setDateOfBirth(results.getDate("dateOfBirth"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return actors;
	}

	//retrieve a actor by id 
	
	public Actor readActor(int id)
	{
		Actor actor = new Actor();
		//如果这里不new出来一个新的actor对象，下面调用actor.setId的时候就会有空指针报错
		
		String sql = "select * from Actor where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			//若想循环用while
			if(result.next())
			{
				actor.setId(result.getInt("id"));
				actor.setFirstName(result.getString("firstName"));
				actor.setLastName(result.getString("lastName"));
				actor.setDateOfBirth(result.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return actor;
	}
	
	//update a actor by id
	//可以更改除了id以外所有的field
	public void updateActor(int id, Actor actor)
	{
		String sql = "update actor set firstName=?, lastName=?, dateOfBirth=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, actor.getFirstName());
			statement.setString(2, actor.getLastName());
			statement.setDate(3, actor.getDateOfBirth());
			statement.setInt(4, id);//如果不传id的话就都改了
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void deleteActor(int id)
	{
		String sql = "delete from actor where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
