package cn.bdqn.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bdqn.entity.PageBean;
import cn.bdqn.entity.Role;
import cn.bdqn.entity.User1;
import cn.bdqn.services.IUserServices1;
import net.sf.json.JSONArray;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application*.xml"})
public class Test1 {
	@Autowired
	IUserServices1 iUserServices1;
	
	@Test
	public void test2(){
		User1 user2 =new User1("java1234","1");
		User1 user1=iUserServices1.getLogin(user2.getUserName(),user2.getPassword());
		System.out.println(user1.getUserName());
	}
	@Test
	public void test3(){
		User1 user2 =new User1();
		user2.setuId(1);
		user2.setPassword("123");
		int i=iUserServices1.getModifyPassword(user2);
		System.out.println(i);
	}
	@Test
	public void test4(){
		PageBean pageBean=new PageBean(1,1);
		User1 user1=new User1();
		user1.setRoleId(4);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start",pageBean.getStart());
		map.put("pageSize",pageBean.getPageSize());
		map.put("userName","hello");
		map.put("roleId",user1.getRoleId());
		int a=(int)map.get("roleId");
		System.out.println(a);
		List<User1> user2=iUserServices1.getUserList(map);
		for(User1 u:user2){
			System.out.println(u);
		}
		JSONArray jsonArray=JSONArray.fromObject(user2);
			System.out.println("用户名为："+jsonArray);
		int i=iUserServices1.getUserCount(user1);
		System.out.println(i);
	}
}