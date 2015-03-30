package edu.neu.cs5200.HW4.ds.model;

import java.sql.Date;

public class Comment {
	private int id;
	private String user;
	private int movieId;
	private String comment;
	private Date date;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String user, int movieId, String comment, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.movieId = movieId;
		this.comment = comment;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
