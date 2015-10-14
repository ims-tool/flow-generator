package com.ims.flow.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;


public class FlowDao {

	public static String execPlpgsql(String pl) {
		AbstractDao dao = null;
		Connection conn = null;
		Boolean ret = false;
		try {
			dao = new AbstractDao();
			conn = dao.getConnection();
			Statement stmt = conn.createStatement();
			if (stmt.execute(pl)) {
				ret = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.ReleaseConnection(conn);
			dao.Finalize();
		}
		
		return ret.toString();
	}
	
	public static String getFormList() {
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		AbstractDao dao = null;
		Connection conn = null;
		try {
			dao = new AbstractDao();
			conn = dao.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from flow.form order by id");
			while (rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rs.getLong("id"));
				jobj.put("name", rs.getString("name"));
				jarr.put(jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.ReleaseConnection(conn);
			dao.Finalize();
		}
		
		json.put("forms", jarr);
		
		return json.toString();
	}


	public static String getTagList() {
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		AbstractDao dao = null;
		Connection conn = null;
		try {
			dao = new AbstractDao();
			conn = dao.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from flow.tag order by id");
			while (rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rs.getLong("id"));
				jobj.put("description", rs.getString("description"));
				jarr.put(jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.ReleaseConnection(conn);
			dao.Finalize();
		}
		
		json.put("tags", jarr);
		
		return json.toString();
	}

	public static String getTagTypesList() {
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		AbstractDao dao = null;
		Connection conn = null;
		try {
			dao = new AbstractDao();
			conn = dao.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from flow.tagtype order by id");
			while (rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rs.getLong("id"));
				jobj.put("name", rs.getString("name"));
				jarr.put(jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.ReleaseConnection(conn);
			dao.Finalize();
		}
		
		json.put("tagTypes", jarr);
		
		return json.toString();
	}

	public static String getNoInputList() {
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		AbstractDao dao = null;
		Connection conn = null;
		try {
			dao = new AbstractDao();
			conn = dao.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from flow.NoMatchInput where type='NoInput' order by id");
			while (rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rs.getLong("id"));
				jobj.put("name", rs.getString("name"));
				jarr.put(jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.ReleaseConnection(conn);
			dao.Finalize();
		}
		
		json.put("noinputs", jarr);
		
		return json.toString();
	
	}
	
	public static String getNoMatchList() {
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		AbstractDao dao = null;
		Connection conn = null;
		try {
			dao = new AbstractDao();
			conn = dao.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from flow.NoMatchInput where type='NoMatch' order by id");
			while (rs.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("id", rs.getLong("id"));
				jobj.put("name", rs.getString("name"));
				jarr.put(jobj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.ReleaseConnection(conn);
			dao.Finalize();
		}
		
		json.put("nomatchs", jarr);
		
		return json.toString();
	
	}
	
	
	
}
