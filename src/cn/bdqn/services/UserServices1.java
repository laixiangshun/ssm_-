package cn.bdqn.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.IUserDao1;
import cn.bdqn.entity.JMUser;
import cn.bdqn.entity.PageBean;
import cn.bdqn.entity.User1;

@Service
public class UserServices1 implements IUserServices1{
	@Autowired
	IUserDao1 iuserDao1;

	@Override
	public int getModifyPassword(User1 user1) {
		return iuserDao1.modifyPassword(user1);
	}

	@Override
	public List<User1> getUserList(Map<String,Object> map) {
		return iuserDao1.userList(map);
	}

	@Override
	public int getUserAdd(User1 user) {
		return iuserDao1.userAdd(user);
	}

	@Override
	public int getUserUpdate(User1 user) {
		return iuserDao1.userUpdate(user);
	}

	@Override
	public boolean getExistUserWithUserName(String userName) {
		return iuserDao1.existUserWithUserName(userName);
	}


	@Override
	public User1 getLogin(String userName, String password) {
		User1 user1=new User1();
		user1.setUserName(userName);
		user1.setPassword(password);
		return iuserDao1.login(user1);
	}

	@Override
	public int getUserCount(User1 user1) {
		return iuserDao1.userCount(user1);
	}
	
	
	
	@Override
	public List<JMUser> getSelAllUser() {
		return iuserDao1.selAllUser();
	}

	@Override
	public int getSelAllUserNum() {
		return iuserDao1.selAllUserNum();
	}

	

	@Override
	public boolean getUpdate(JMUser jmuser) {
		
		return iuserDao1.update(jmuser);
	}

	@Override
	public boolean getAdd(JMUser jmuser) {
		return iuserDao1.add(jmuser); 
	}

	@Override
	public boolean getDelete(Integer jmid) {
		return iuserDao1.delete(jmid);
	}

	@Override
	public List<JMUser> getFind(Map<String,Object> map) {
		
		return iuserDao1.find(map);
	}

	@Override
	public List<JMUser> getSeleAllUserFen(PageBean pageBean) {
		
		return iuserDao1.selAllUserFen(pageBean);
	}

	@Override
	public int getSelAllUserNum1(String username) {
		return iuserDao1.selAllUserNum(username);
	}
}