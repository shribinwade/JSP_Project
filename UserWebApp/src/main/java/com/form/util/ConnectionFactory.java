package com.form.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	
	private static DataSource ds=null;

	public static Connection getConnetion() throws SQLException, IOException {
		Connection con=null;

	try{
		
		if(ds == null) {
		
		File f= new File("E:\\JSP_Project\\UserWebApp\\dbconfig.properties");
		FileInputStream fis = new FileInputStream(f);
		
		Properties p =new Properties();
		p.load(fis);
		
		String Username =p.getProperty("db.username");
		String Password =p.getProperty("db.password");
		String URL= p.getProperty("db.url");
		String Driver=p.getProperty("db.driver");
		
		
		
		HikariConfig config= new HikariConfig();
		config.setUsername(Username);
		config.setPassword(Password);
		config.setJdbcUrl(URL);
		config.setDriverClassName(Driver);
		
		ds = new HikariDataSource(config);

	    }
		con=ds.getConnection();

	
	  }catch(Exception e) {
		e.printStackTrace();
		
	}
	return con;

  }
} 
