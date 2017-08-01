package cn.bdqn.entity;

import java.util.Date;

public class User {
	
		private Integer userId;  
	    private String loginname;  
	    private String username;  
	    private String password;  
	    private String rights;  
	    private Integer status;  
	    private Integer roleId;  
	    private Date lastLogin;
	    
	    private Date lastLoginStart;  
	    private Date lastLoginEnd;
	    
		public User(Integer userId, String loginname, String username, String password, String rights, Integer status,
				Integer roleId, Date lastLogin, Date lastLoginStart, Date lastLoginEnd) {
			super();
			this.userId = userId;
			this.loginname = loginname;
			this.username = username;
			this.password = password;
			this.rights = rights;
			this.status = status;
			this.roleId = roleId;
			this.lastLogin = lastLogin;
			this.lastLoginStart = lastLoginStart;
			this.lastLoginEnd = lastLoginEnd;
		}
		
		public User(String loginname, String password) {
			super();
			this.loginname = loginname;
			this.password = password;
		}



		public User() {
			super();
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
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
		public String getRights() {
			return rights;
		}
		public void setRights(String rights) {
			this.rights = rights;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public Date getLastLogin() {
			return lastLogin;
		}
		public void setLastLogin(Date lastLogin) {
			this.lastLogin = lastLogin;
		}
		public Date getLastLoginStart() {
			return lastLoginStart;
		}
		public void setLastLoginStart(Date lastLoginStart) {
			this.lastLoginStart = lastLoginStart;
		}
		public Date getLastLoginEnd() {
			return lastLoginEnd;
		}
		public void setLastLoginEnd(Date lastLoginEnd) {
			this.lastLoginEnd = lastLoginEnd;
		}
	    
}