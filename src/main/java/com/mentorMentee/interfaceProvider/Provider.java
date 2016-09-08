package com.mentorMentee.interfaceProvider;

public interface Provider {
	String DRIVER="org.postgresql.Driver";  
	String CONNECTION_URL="jdbc:postgresql://localhost:5432/MentorMentee";  
	String USERNAME="postgres";  
	String PASSWORD="preeth"; 
	
	//MYSQL Statements
	/*
		String INS_RegMetaData="INSERT INTO regmetadata VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		String INS_FPSiteSpecTable="INSERT INTO fp_sitespec_table VALUES(?,?,?,?);";
		String INS_APISiteSpecTable="INSERT INTO api_sitespec_table VALUES(?,?,?,?,?,?,?);";
		String ForFK="SELECT LAST_INSERT_ID()";
		String SEL_RegID="SELECT Reg_ID FROM regmetadata WHERE RegNum=?";
		String SEL_RegMetaDataAll="SELECT * FROM regmetadata;";
		String SEL_RegMetaData="SELECT * FROM regmetadata WHERE Reg_ID=?";
		String SEL_FPSiteSpecTableAll="SELECT * FROM fp_sitespec_table;";
		String SEL_FPSiteSpecTable="SELECT * FROM fp_sitespec_table WHERE Reg_ID=?";
		String SEL_APISiteSpecTableAll="SELECT * FROM api_sitespec_table;";
		String SEL_APISiteSpecTable="SELECT * FROM api_sitespec_table WHERE Reg_ID=?";
		String SHOW_RegMetaData="SHOW FIELDS FROM regmetadata;";
		String SHOW_FPSiteSpecTable="SHOW FIELDS FROM fp_sitespec_table;";
		String SHOW_APISiteSpecTable="SHOW FIELDS FROM api_sitespec_table;";
		String DEL_RegMetaData="DELETE FROM regmetadata WHERE Reg_ID=?";
		*/
}
