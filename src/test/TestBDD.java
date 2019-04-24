package test;

import beans.User;
import dao.ConnexionBDD;
import dao.UserDao;

import java.sql.*;
import java.util.Properties;

public class TestBDD {

	public static void main(String args[]){  
	try{

		/*
		Properties p = new Properties();
		p.load(Thread.currentThread().getContextClassLoader().
				getResourceAsStream("config/confBDD.properties"));



		// chargement du driver
		Class.forName(p.getProperty("driver"));
		Connection con = DriverManager.getConnection(p.getProperty("url"),
				p.getProperty("user"), p.getProperty("pwd"));
				*/
		Connection con = ConnexionBDD.getInstance().getCnx();

		// On recupere l'utilisateur a partir de l'email
		UserDao userManager = new UserDao();
		User user = userManager.findByMail("test@test.fr");


		/*
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection( 
	        "jdbc:mysql://localhost:3306/webj2ee","java","java");
	        */
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from users");
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	con.close();  
	}catch(Exception e){ System.out.println(e);}  
	}  
}
