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

public class CommentManager {

	DataSource ds;

	//constructor	
	public CommentManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200HW4DB");
			System.out.println(ds);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//create a Comment
	public void createComment(Comment newComment) {
		String sql = "insert into Comment values (null,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getUser());
			statement.setInt(2, newComment.getMovieId());
			statement.setString(3, newComment.getComment());
			statement.setDate(4, newComment.getDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//retrieve all Comments 
	
	public List<Comment> readAllComments()   {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from Comment";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Comment comment = new Comment();
				comment.setId(results.getInt("id"));
				comment.setUser(results.getString("user"));
				comment.setMovieId(results.getInt("movieId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return comments;
	}
	
	//retrieve all Comments for username
	
	public List<Comment> readAllCommentsForUsername(String username)   {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from Comment where username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				Comment comment = new Comment();
				comment.setId(results.getInt("id"));
				comment.setUser(results.getString("user"));
				comment.setMovieId(results.getInt("movieId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return comments;
	}
	
	//retrieve all Comments for movie
	
	public List<Comment> readAllCommentsForMovie(int movieId)   {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "select * from Comment where movieId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				Comment comment = new Comment();
				comment.setId(results.getInt("id"));
				comment.setUser(results.getString("user"));
				comment.setMovieId(results.getInt("movieId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return comments;
	}
	
	//retrieve a comment by id 
	
	public Comment readAllCommentForId(int id)
	{
		Comment comment = new Comment();
		//如果这里不new出来一个新的Comment对象，下面调用Comment.setId的时候就会有空指针报错
		
		String sql = "select * from Comment where id = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			//若想循环用while
			if(result.next())
			{
				comment.setId(result.getInt("id"));
				comment.setUser(result.getString("user"));
				comment.setMovieId(result.getInt("movieId"));
				comment.setComment(result.getString("comment"));
				comment.setDate(result.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return comment;
	}	

	//update a comment by id
	//可以更改除了id以外所有的field
	public void updateComment(int id, Comment newComment)
	{
		String sql = "update comment set user=?, movieId=?, comment=?, date=? where id=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getUser());
			statement.setInt(2, newComment.getMovieId());
			statement.setString(3, newComment.getComment());
			statement.setDate(4, newComment.getDate());
			
			statement.setInt(5, id);//如果不传id的话就都改了
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
	//delete comment by id
	//return是否delete成功，给出受到影响的row的数量
	
	public void deleteComment(int id)
	{
		String sql = "delete from Comment where id=?";
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
