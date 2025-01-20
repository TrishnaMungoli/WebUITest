package com.framework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	
	public  Connection con;
	public  Statement stmt;
	
    public  Statement getStatement()  {
		String driver ="";
		String connection="";
		String userName="";
		String password="";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(connection, userName, password);
			stmt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
			
	}
	
	/***
	 * 
	 * 
	 * @param query
	 * This method will help to insert data in the database by giving insert query
	 */
	
	public  void insertData(String query) {
		Statement sta= getStatement();
		try {
			sta.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 * This method will get the data from the database 
	 */
	public ResultSet getdata(String query) {
		ResultSet data = null;
		try {
			data = getStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;	
	}
	
   /**
   * 
   * @param query
   * @return
   * To update any query this method can be used
   * 
   */
	public ResultSet updatedata(String query){
		ResultSet data=null;
		try {
			data = getStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * To execute query like delete this method can be used	
	 */
	
	public void executeQuery(String query){
		try {
			getStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * This is method can be used to close connection of the database
	 */
	
	public void closeConnection() {
		try {
			getStatement().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
