package cn.bdqn.entity;

public class JMUser {
	private Integer jmid;  
    private String loginname;  
    private String username;  
    private String password;  
    private String rights;  
    private Integer status;  
    private Integer roleId;  
    
	public JMUser(String loginname, String username, String password, String rights, Integer status, Integer roleId) {
		super();
		this.loginname = loginname;
		this.username = username;
		this.password = password;
		this.rights = rights;
		this.status = status;
		this.roleId = roleId;
	}
	public JMUser(Integer jmid, String loginname, String username, String password, String rights, Integer status,
			Integer roleId) {
		this.jmid = jmid;
		this.loginname = loginname;
		this.username = username;
		this.password = password;
		this.rights = rights;
		this.status = status;
		this.roleId = roleId;
	}
	public JMUser() {
	}
	
	
	public Integer getJmid() {
		return jmid;
	}
	public void setJmid(Integer jmid) {
		this.jmid = jmid;
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
	
}