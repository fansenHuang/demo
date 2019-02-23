package com.system.entity;

//用户详情
public class User extends BaseEntity {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;//用户名
 
    private String password;//密码
    
    private String phone;//手机号
    
    private String email;//邮箱
    
    private Integer status;//状态 0 停用  1 启用
    
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", status=" + status + "]";
	}
 


}
