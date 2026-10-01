package model.entity;

public class UserBean {
	
	private String user_id;
	private String password;
	private String name;
	private String role;
	
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
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role セットする role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
}
