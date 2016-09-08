package com.mentorMentee.connectionPool;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import static com.mentorMentee.interfaceProvider.Provider.DRIVER;
import static com.mentorMentee.interfaceProvider.Provider.CONNECTION_URL;
import static com.mentorMentee.interfaceProvider.Provider.USERNAME;
import static com.mentorMentee.interfaceProvider.Provider.PASSWORD;

public class DataSourceConnectionPool {
	public BasicDataSource DataSRC(){
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName(DRIVER);
		bds.setUrl(CONNECTION_URL);
		bds.setUsername(USERNAME);
		bds.setPassword(PASSWORD);
		bds.setMaxTotal(15);
		bds.setMaxIdle(5);
		bds.setMaxWaitMillis(5000);
		return bds;
	}
}
