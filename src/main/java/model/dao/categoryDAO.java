package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class categoryDAO {
	String sql;
	public List<CategoryBean> categoryList(String user_id){
		sql = "SELECT category_id,item_category FROM m_category WHERE user_id = ?";
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				CategoryBean catBean = new CategoryBean();
				catBean.setCategory_id(res.getInt("category_id"));
				catBean.setItem_category(res.getString("item_category"));
				categoryList.add(catBean);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return categoryList;
	}
}
