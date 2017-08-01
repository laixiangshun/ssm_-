package cn.bdqn.entity;

public class User1 {
	
	private int uId;
	private String userName;
	private String password;
	private int userType;
	private int roleId=-1;
	private String userDescription;
	private Role role;
	
	public User1() {
		super();
	}

	public User1(int uId) {
		super();
		this.uId = uId;
	}

	public User1(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
	public User1(int uId, String userName, String password, int userType, int roleId,
			String userDescription, Role role) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.roleId = roleId;
		this.userDescription = userDescription;
		this.role = role;
	}

	public User1(String userName, String password, int roleId,
			String userDescription) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.userDescription = userDescription;
	}

	
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
}