<%@page import="java.sql.Date"%>
<%@page import="edu.neu.cs5200.HW4.ds.model.*"%>
<%@page import="edu.neu.cs5200.HW4.ds.dao.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>	
	<h1>
	Hello world
	</h1>

<%
// test createUser

/* 	UserManager userManager = new UserManager();

	User user = new User();
	user.setUsername("rui");
	user.setPassword("1");
	user.setFirstName("Mingrui");
	user.setLastName("Jia");
	user.setEmail("jia.mi@husky.neu.edu");
	
	String strDate  = "1989-11-25";      
	StringTokenizer st = new StringTokenizer(strDate, "-");      
	java.sql.Date date = new java.sql.Date
			(Integer.parseInt(st.nextToken())-1900,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));  

	user.setDateOfBirth(date);

	userManager.createUser(user);
	out.println(user.getUsername()); 
	out.println(user.getDateOfBirth()); */
	
// test readAllUsers	

/* 	UserManager userManager = new UserManager();
	
	List<User> users = userManager.readAllUsers();
	
	for(User user : users) {
		out.println(user.getUsername());
	} */
	
// test readUser		

/* 	UserManager userManager = new UserManager();
	User user = userManager.readUser("rui");
	out.println(user.getUsername());
 */
	
//test updateUser	

/* 	UserManager userManager = new UserManager();
	User user = userManager.readUser("rui");
	user.setEmail("j19891125@sina.com");
	userManager.updateUser("rui", user);
	out.println(user.getEmail()); */
	
//test deleteUser		

/* 	UserManager userManager = new UserManager();
	userManager.deleteUser("rui");
	 */

	// test createMovie

/* 	  	MovieManager movieManager = new MovieManager();

		Movie movie = new Movie();
		movie.setTitle("Avatar");
		movie.setPosterImage("a");
	 	
	 	String strDate  = "2005-11-25";      
	 	StringTokenizer st = new StringTokenizer(strDate, "-");      
	 	java.sql.Date date = new java.sql.Date
	 			(Integer.parseInt(st.nextToken())-1900,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));  

	 	movie.setReleaseDate(date);

	 	movieManager.createMovie(movie);
	 	out.println(movie.getTitle()); 
	 	out.println(movie.getReleaseDate());  */
	 	
	 // test readAllMovies	

/* 	 	MovieManager movieManager = new MovieManager();
	 	
	 	List<Movie> movies = movieManager.readAllMovies();
	 	
	 	for(Movie movie : movies) {
	 		out.println(movie.getTitle());
	 	} 
	 	 */
	 	 
	 // test readMovie		

/* 	  	MovieManager movieManager = new MovieManager();
	 	Movie movie = movieManager.readMovie(1);
	 	out.println(movie.getTitle());
	   */
	 	
	 //test updateMovie	

	 	/* MovieManager movieManager = new MovieManager();
	    Movie movie = movieManager.readMovie(1);
	    movie.setPosterImage("B");
	    movieManager.updateMovie(1, movie);
	 	out.println(movie.getPosterImage());  */
	 	
	 //test deleteMovie	

/* 	  	MovieManager movieManager = new MovieManager();
	 	movieManager.deleteMovie(1); */
	 	
		// test createActor

/* 	 	 	  	ActorManager actorManager = new ActorManager();

	 			Actor actor = new Actor();
	 			actor.setFirstName("Wenruo");
	 			actor.setLastName("Wang");

	 		 	
	 		 	String strDate  = "1990-10-12";      
	 		 	StringTokenizer st = new StringTokenizer(strDate, "-");      
	 		 	java.sql.Date date = new java.sql.Date
	 		 			(Integer.parseInt(st.nextToken())-1900,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));  

	 		 	actor.setDateOfBirth(date);

	 		 	actorManager.createActor(actor);
	 		 	out.println(actor.getFirstName()); 
	 		 	out.println(actor.getDateOfBirth());   */
	 		 	
	 		 // test readAllActors	

/* 	 	 	 	ActorManager actorManager = new ActorManager();
	 		 	
	 		 	List<Actor> actors = actorManager.readAllActors();
	 		 	
	 		 	for(Actor actor : actors) {
	 		 		out.println(actor.getFirstName());
	 		 	} 
	 		 	  */
	 		 	 
	 		 // test readActor		

/* 	 	 	  	ActorManager actorManager = new ActorManager();
	 		 	Actor actor = actorManager.readActor(1);
	 		 	out.println(actor.getFirstName()); */
	 		   
	 		 	
	 		 //test updateActor	
/* 
	 		    ActorManager actorManager = new ActorManager();
	 		 	Actor actor = actorManager.updateActor(1);
	 		 	actor.setFirstName("ruoruo");
	 		 	actorManager.updateActor(1, actor);
	 		 	out.println(actor.getFirstName());  
	 		 	 */
	 		 	 
	 		 //test deleteActor

/* 	 	 	  	ActorManager actorManager = new ActorManager();
	 		 	actorManager.deleteActor(1);  */

	 		 	
	 			// test createComment
	 			
/*  UserManager userManager = new UserManager();

	User user = new User();
	user.setUsername("rui");
	user.setPassword("1");
	user.setFirstName("Mingrui");
	user.setLastName("Jia");
	user.setEmail("jia.mi@husky.neu.edu");
	
	String strDate0  = "1989-11-25";      
	StringTokenizer st0 = new StringTokenizer(strDate0, "-");      
	java.sql.Date date0 = new java.sql.Date
			(Integer.parseInt(st0.nextToken())-1900,Integer.parseInt(st0.nextToken())-1,Integer.parseInt(st0.nextToken()));  

	user.setDateOfBirth(date0);

	userManager.createUser(user);
	out.println(user.getUsername()); 
	out.println(user.getDateOfBirth());
	
	
	MovieManager movieManager = new MovieManager();

	Movie movie = new Movie();
	movie.setTitle("Avatar");
	movie.setPosterImage("a");
 	
 	String strDate1  = "2005-11-25";      
 	StringTokenizer st1 = new StringTokenizer(strDate1, "-");      
 	java.sql.Date date1 = new java.sql.Date
 			(Integer.parseInt(st1.nextToken())-1900,Integer.parseInt(st1.nextToken())-1,Integer.parseInt(st1.nextToken()));  

 	movie.setReleaseDate(date1);

 	movieManager.createMovie(movie);
 	out.println(movie.getTitle()); 
 	out.println(movie.getReleaseDate()); */
 	
	 		 	 	 	   /*	CommentManager commentManager0 = new CommentManager();

	 		 					Comment comment0 = new Comment();
	 		 					comment0.setUser("rui");
	 		 		 			comment0.setMovieId(1);
	 		 		 			comment0.setComment("good comment");

	 		 		 			
	 		 		 		 	String strDate  = "2015-10-12";      
	 		 		 		 	StringTokenizer st = new StringTokenizer(strDate, "-");      
	 		 		 		 	java.sql.Date date = new java.sql.Date
	 		 		 		 			(Integer.parseInt(st.nextToken())-1900,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));  

	 		 		 			comment0.setDate(date);

	 		 		 			commentManager0.createComment(comment0);
	 		 		 		 	out.println(comment0.getComment()); 
	 		 		 		 	out.println(comment0.getDate());  */  
	 		 		 		 	
	 		 		 		 // test readAllComments	

/* 	 		 	 	 	 	 	CommentManager commentManager = new CommentManager();
	 		 		 		 	
	 		 		 		 	List<Comment> comments = commentManager.readAllComments();
	 		 		 		 	
	 		 		 		 	for(Comment comment : comments) {
	 		 		 		 		out.println(comment.getComment());
	 		 		 		 	}  */
	 		 		 		 
	 		 		 		 	
	 		 		 		 // test readAllCommentsForUsername	
	 		 		 		 
/* 	 		 		 		 	CommentManager commentManager = new CommentManager();
	 		 		 			List<Comment> comments = commentManager.readAllCommentsForUsername("rui");
	 		 		 		 	for(Comment comment : comments) {
	 		 		 		 		out.println(comment.getComment());
	 		 		 		 	} 
	 		 		 		  */
	 		 		 		 
	 		 		 		 // test readAllCommentsForMovie
	 		 		 		 
/* 	 		 		 			CommentManager commentManager = new CommentManager();
	 		 		 			List<Comment> comments = commentManager.readAllCommentsForMovie(2);
	 		 		 		 	for(Comment comment : comments) {
	 		 		 		 		out.println(comment.getComment());
	 		 		 		 	}  */
	 		 		 		 	 
	 		 		 		 // test readAllCommentForId		

/* 	 		 	 	 	 	  	CommentManager commentManager = new CommentManager();
	 		 		 			Comment comment = commentManager.readAllCommentForId(1);
	 		 		 		 	out.println(comment.getComment()); 
	 		 		 		    */
	 		 		 		 	
	 		 		 		 //test updateComment
	 		 	
	 		 		 		    CommentManager commentManager = new CommentManager();
	 		 		 			Comment newComment = commentManager.updateComment(1, newComment);
	 		 		 			
	 		 		 			comment.setComment("new comment");
	 		 		 		    commentManager.updateComment(1, newComment);
	 		 		 		 	out.println(comment.getComment());  
	 		 		 		 	 
	 		 		 		 	 
	 		 		 		 //test deleteActor

	 		 	/* 	 	 	  	ActorManager actorManager = new ActorManager();
	 		 		 		 	actorManager.deleteActor(1);  */
	 		 		 	 
	 		 		
%>
</body>
</html>