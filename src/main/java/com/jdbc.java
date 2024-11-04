package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	
	private static String url="jdbc:mysql://localhost/school";
	private static Connection conn;
	private  static Statement stat;
	public static void connect() {
		try {
			//chargement du pilot
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {System.out.println("hi");}
			//etablissement de la connection
			
			try {
				conn=DriverManager.getConnection(url,"root","");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//creation de statement
			
			try {
				stat=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	public static void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  static int Maj(String sql) {
		int nb=0;
		
		try {
			nb=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
public static ResultSet  select(String sql) {
	ResultSet rs=null;
	try {
		rs=stat.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return rs;
}
}
