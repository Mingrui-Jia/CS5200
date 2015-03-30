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





public class MovieManager {

	DataSource ds;

	//constructor	
	public MovieManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200HW4DB");
			System.out.println(ds);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//create a Movie
	public void createMovie(Movie newmovie) {
		String sql = "insert into Movie values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newmovie.getTitle());
			statement.setString(2, newmovie.getPosterImage());
			statement.setDate(3, newmovie.getReleaseDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//retrieve all movies 
	
	public List<Movie> readAllMovies()   {
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from Movie";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Movie movie = new Movie();
				movie.setId(results.getInt("id"));
				movie.setTitle(results.getString("title"));
				movie.setPosterImage(results.getString("posterImage"));
				movie.setReleaseDate(results.getDate("releaseDate"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return movies;
	}

	//retrieve a movie by id 
	
	public Movie readMovie(int id)
	{
		Movie movie = new Movie();
		//如果这里不new出来一个新的movie对象，下面调用movie.setId的时候就会有空指针报错
		
		String sql = "select * from Movie where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			//若想循环用while
			if(result.next())
			{
				movie.setId(result.getInt("id"));
				movie.setTitle(result.getString("title"));
				movie.setPosterImage(result.getString("posterImage"));
				movie.setReleaseDate(result.getDate("releaseDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return movie;
	}
	
	//update a movie by id
	//可以更改除了id以外所有的field
	public void updateMovie(int id, Movie movie)
	{
		String sql = "update movie set title=?, posterImage=?, releaseDate=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getPosterImage());
			statement.setDate(3, movie.getReleaseDate());
			statement.setInt(4, id);//如果不传id的话就都改了
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	//delete movie by id
	//return是否delete成功，给出受到影响的row的数量
	
	public void deleteMovie(int id)
	{
		String sql = "delete from Movie where id=?";
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
