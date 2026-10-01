package model.entity;

public class StockCategoryBean {

	private int stock_id;
	private String user_id;
	private int category_id;
	private String item_category;
	private String item_name;
	private int item_count;
	private int alert_count;

	/**
	 * @return stock_id
	 */
	public int getStock_id() {
		return stock_id;
	}

	/**
	 * @param stock_id セットする stock_id
	 */
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	/**
	 * @return user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return category_id
	 */
	public int getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id セットする category_id
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return item_category
	 */
	public String getItem_category() {
		return item_category;
	}

	/**
	 * @param item_category セットする item_category
	 */
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	/**
	 * @return item_name
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * @param item_name セットする item_name
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * @return item_count
	 */
	public int getItem_count() {
		return item_count;
	}

	/**
	 * @param item_count セットする item_count
	 */
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	/**
	 * @return alert_count
	 */
	public int getAlert_count() {
		return alert_count;
	}

	/**
	 * @param alert_count セットする alert_count
	 */
	public void setAlert_count(int alert_count) {
		this.alert_count = alert_count;
	}

}
