package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.User;

public interface IChatUserDao {

	public User getUserById(int userId);  
	
    public int insertUser(List<User> users);
    
    public User login(User user);
}
