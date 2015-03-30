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

public class CastManager {
	DataSource ds;

	//constructor	
	public CastManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200HW4DB");
			System.out.println(ds);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//create a Cast
	public void createCast(Cast newCast) {
		String sql = "insert into Cast values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, newCast.getMovieId());
			statement.setInt(2, newCast.getActorId());
			statement.setString(3, newCast.getCharacterName());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//retrieve all Casts 
	
	public List<Cast> readAllCasts()   {
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				cast.setCharacterName(results.getString("characterName"));
				casts.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return casts;
	}
	
	//retrieve all casts for Actor
	
	public List<Cast> readAllCastForActor(int actorId)   {
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast where actorId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, actorId);
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				cast.setCharacterName(results.getString("characterName"));
				casts.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return casts;
	}
	
	//retrieve all casts for movieId
	
	public List<Cast> readAllCastForMovie(int movieId)   {
		List<Cast> casts = new ArrayList<Cast>();
		String sql = "select * from Cast where movieId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				Cast cast = new Cast();
				cast.setId(results.getInt("id"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				cast.setCharacterName(results.getString("characterName"));
				casts.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return casts;
	}
	
	//retrieve a cast by id 
	
	public Cast readAllCastForId(int id)
	{
		Cast cast = new Cast();
		//如果这里不new出来一个新的Cast对象，下面调用Cast.setId的时候就会有空指针报错
		
		String sql = "select * from Cast where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			//若想循环用while
			if(result.next())
			{
				cast.setId(result.getInt("id"));
				cast.setMovieId(result.getInt("movieId"));
				cast.setActorId(result.getInt("actorId"));
				cast.setCharacterName(result.getString("characterName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cast;
	}	

	//update a cast by id
	//可以更改除了id以外所有的field
	public void updateCast(int id, Cast newCast)
	{
		String sql = "update cast set movieId=?, actorId=?, characterName=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, newCast.getMovieId());
			statement.setInt(2, newCast.getActorId());
			statement.setString(3, newCast.getCharacterName());
			
			statement.setInt(4, id);//如果不传id的话就都改了
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	//delete comment by id
	//return是否delete成功，给出受到影响的row的数量
	
	public void deleteCast(int id)
	{
		String sql = "delete from Cast where id=?";
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
