package com.mentorMentee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.mentorMentee.connectionPool.DataSourceConnectionPool;

public class TestConnection {
	
	public static void testMethod(){
		System.out.println("=====In TestMethod=====");
		try{
			DataSourceConnectionPool instance=new DataSourceConnectionPool();
			BasicDataSource bds=instance.DataSRC();
			Connection con=bds.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM LoginTable");
			ResultSet rs;
			rs=ps.executeQuery();
			if(rs.next()){
				
				System.out.println("========rs.getInt(1);======="+rs.getInt(1));
				System.out.println("========rs.getString(2);======="+rs.getString(2));
				System.out.println("========rs.getString(3);======="+rs.getString(3));
				System.out.println("========rs.getString(4);======="+rs.getString(4));
			}
		}catch(Exception e){
			System.out.println("========Exception======="+e);
		}
	}
}
