package com.ims.flow.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AbstractDao {

	Context initCtx = null;
	static DataSource ds = null;
	
	public AbstractDao() {
		try {
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/flow");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public void ReleaseConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Finalize() {
		try {
			ds = null;
			try {initCtx.close();} catch (Exception e) {}
			initCtx = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
