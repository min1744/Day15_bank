package com.iu.ti;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TranDAO {
	
	
	//insert
	public int insert(TranDTO tranDTO, Connection con, String id)throws Exception{
		int result=0;
		String sql="insert into TRANSACTIONINFO values(TRANSACTIONINFO_SEQ.nextval,(select accountnum from account where id=?), ?, ?, sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tranDTO.getAccountnum());
		st.setInt(2, tranDTO.getAmount());
		st.setInt(3, tranDTO.getKind());
		result = st.executeUpdate();
		
		return result;
	}

}