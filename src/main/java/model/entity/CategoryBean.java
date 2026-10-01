package model.entity;

public class CategoryBean {

	private int category_id;
	private String user_id;
	private String item_category;

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

}
