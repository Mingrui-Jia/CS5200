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

import edu.neu.cs5200.HW4.ds.model.User;




public class UserManager {
	
DataSource ds;

//constructor
	public UserManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200HW4DB");
			System.out.println(ds);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//create a User
	public void createUser(User newUser) {
		String sql = "insert into User values (?,?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newUser.getUsername());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());
			statement.setString(5, newUser.getEmail());
			statement.setDate(6, newUser.getDateOfBirth());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//retrieve all Users 
	public List<User> readAllUsers()   {
		List<User> users = new ArrayList<User>();
		String sql = "select * from User"; //注意大小写
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				User user = new User();
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setFirstName(results.getString("firstName"));
				user.setLastName(results.getString("lastName"));
				user.setEmail(results.getString("email"));
				user.setDateOfBirth(results.getDate("dateOfBirth"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return users;
	}
	
	//retrieve a user by username
	
	public User readUser(String username)
	{
		User user = new User();
		//如果这里不new出来一个新的user对象，下面调用user.setUsername的时候就会有空指针报错
		
		String sql = "select * from user where username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			//若想循环用while
			if(result.next())
			{
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setFirstName(result.getString("firstName"));
				user.setLastName(result.getString("lastName"));
				user.setEmail(result.getString("email"));
				user.setDateOfBirth(result.getDate("dateOfBirth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}
	
	//update a user by username
	//可以更改除了username以外所有的field
	public void updateUser(String username, User user)
	{
		String sql = "update user set password=?, firstName=?, lastName=?, email=?, dateOfBirth=? where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getEmail());
			statement.setDate(5, user.getDateOfBirth());
			statement.setString(6, username);//如果不传username的话就都改了
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	//delete user by username
	//return是否delete成功，给出受到影响的row的数量
	
	public void deleteUser(String username)
	{
		String sql = "delete from User where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			//return是否delete成功，给出受到影响的row的数量
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
