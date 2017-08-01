package cn.bdqn.dao;

import java.util.List;
import java.util.Map;

import cn.bdqn.entity.JMUser;
import cn.bdqn.entity.PageBean;
import cn.bdqn.entity.User1;

public interface IUserDao1 {

	public User1 login(User1 user1);
	
	public int modifyPassword(User1 user1);
	
	public List<User1> userList(Map<String,Object> map);

	public int userCount(User1 user1);
	
	public int userAdd(User1 user1);
	
	public int userUpdate(User1 user1);
	
	public boolean existUserWithUserName(String userName);
	
	
	
public List<JMUser> selAllUserFen(PageBean pageBean);
	
	public List<JMUser> selAllUser();  
	    //查询所有用户数量  
	 public int selAllUserNum();
	 
	 public int selAllUserNum(String username);
	    //根据用户名和密码来判断该用户是否存在  
	 public User1 selUser(User1 User);
	 
	 public JMUser SelJMUser(JMUser jmuser);
	    
	    /**
	     * 修改用户
	     * @param user
	     * @return影响的记录数
	     */
	    public boolean update(JMUser jmuser);
	    
	    /**
	     * 添加用户
	     * @param user
	     * @return影响的记录数
	     */
	    public boolean add(JMUser jmuser);
	    
	    /**
	     * 删除用户
	     * @param id
	     * @return
	     */
	    public boolean delete(Integer jmid);
	    /**
	     * 查找用户
	     * @param username
	     * @returen list<JMUser>集合
	     */
	    public List<JMUser> find(Map<String,Object> map);
}