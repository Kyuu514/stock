package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.StockCategoryBean;

public class stockDAO {
	String sql;
	
	public List<StockCategoryBean> stockList(String user_id) {
		sql = "SELECT c.item_category,st.category_id,st.stock_id,st.item_name,st.item_count,st.alert_count "
				+ "FROM m_stock st INNER JOIN m_category c "
				+ "ON st.category_id = c.category_id AND st.user_id = c.user_id "
				+ "WHERE st.user_id = ?";
		List<StockCategoryBean> stockList = new ArrayList<StockCategoryBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, user_id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				StockCategoryBean stcgBean = new StockCategoryBean();
				stcgBean.setItem_category(res.getString("item_category"));
				stcgBean.setCategory_id(res.getInt("category_id"));
				stcgBean.setStock_id(res.getInt("stock_id"));
				stcgBean.setItem_name(res.getString("item_name"));
				stcgBean.setItem_count(res.getInt("item_count"));
				stcgBean.setAlert_count(res.getInt("alert_count"));
				stockList.add(stcgBean);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return stockList;
	}
}
