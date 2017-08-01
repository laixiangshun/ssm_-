package cn.bdqn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.IChatUserDao;
import cn.bdqn.entity.User;

@Service
public class ChatUserServices implements IChatUserServices{
	@Autowired
	IChatUserDao iUserDao;

	@Override
	public User getUserById(int userId) {
		return iUserDao.getUserById(userId);
	}

	@Override
	public int insertUser(List<User> users) {
		return iUserDao.insertUser(users);
	}

	@Override
	public String login(String loginname, String password) {
		User user=new User(loginname,password);
		User user1=iUserDao.login(user);
		if(user1==null){
			return "false";
		}else{
			return "success";
		}
	}
}