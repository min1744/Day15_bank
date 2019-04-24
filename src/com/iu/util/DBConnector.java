package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	public static Connection getConnect() throws Exception {
		Connection con = null;
		//1. 4가지 정보
		String user="user02";
		String password="user02";
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		
		//2. driver 로딩
		Class.forName(driver);
		
		//3. Connection
		con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public static void disConnect(PreparedStatement st, Connection con)throws Exception{
		st.close();
		con.close();
	}
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con)throws Exception{
		rs.close();
		DBConnector.disConnect(st, con);
	}
}