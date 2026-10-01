package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class userDAO {
	
	String sql;
	
	public boolean select(String user_id) throws ClassNotFoundException, SQLException{
		sql = "SELECT user_id FROM m_user WHERE user_id = ?";
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			return res.next();
		}
	}
	
	public UserBean check(String user_id, String password) throws ClassNotFoundException, SQLException {
		sql = "SELECT user_id, name, role FROM m_user WHERE user_id = ? AND password = ?";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, user_id);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			UserBean userBean = new UserBean();
			if(res.next()) {
				userBean.setUser_id(res.getString("user_id"));
				userBean.setName(res.getString("name"));
				userBean.setRole(res.getString("role"));
			}
			return userBean;
			
		}
	}
	
	public int userEntry(UserBean userBean) throws ClassNotFoundException, SQLException {
		sql = "INSERT INTO m_user VALUES (?, ?, ?, ?)";
		try(Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, userBean.getUser_id());
			pstmt.setString(2, userBean.getPassword());
			pstmt.setString(3, userBean.getName());
			pstmt.setString(4, userBean.getRole());
			int count = pstmt.executeUpdate();
			return count;
		}
	}
}
