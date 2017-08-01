package cn.bdqn.services;

import java.util.List;
import java.util.Map;

import cn.bdqn.entity.JMUser;
import cn.bdqn.entity.PageBean;
import cn.bdqn.entity.User1;

public interface IUserServices1 {

	public int getModifyPassword(User1 user1);
	
	public List<User1> getUserList(Map<String,Object> map);
	
	public int getUserCount(User1 user1);
	
	public int getUserAdd(User1 user);
	
	public int getUserUpdate(User1 user);
	
	public boolean getExistUserWithUserName(String userName);
	
	public User1 getLogin(String userName, String password);
	
	
	
	public List<JMUser> getSeleAllUserFen(PageBean pageBean); 
	
	public List<JMUser> getSelAllUser();  
	    //查询所有用户数量  
	 public int getSelAllUserNum();  
	 
	 public boolean getUpdate(JMUser jmuser);
	 
	 public boolean getAdd(JMUser jmuser);
	
	 public boolean getDelete(Integer id);
	 
	 public List<JMUser> getFind(Map<String,Object> map);

	 public int getSelAllUserNum1(String username);
	 
}