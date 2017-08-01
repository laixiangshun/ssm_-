package cn.bdqn.services;

import java.util.List;

import cn.bdqn.entity.User;

public interface IChatUserServices {
	
	public User getUserById(int userId);  
	
    public int insertUser(List<User> users);
    
    public String login(String loginname,String password);
}
