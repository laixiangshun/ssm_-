package cn.bdqn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.entity.JMUser;
import cn.bdqn.entity.PageBean;
import cn.bdqn.entity.User1;
import cn.bdqn.services.IRoleServices;
import cn.bdqn.services.IUserServices1;
import cn.bdqn.util.Const;
import cn.bdqn.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@Transactional
public class JMLoginController {

	@Autowired
	private IUserServices1 iUserServices1;
	@Autowired
	private IRoleServices iRoleServices;
	/** 
     * 访问登录页 
     * @return 
     */  
	@RequestMapping("/role")
	public String view1(){
		
		return "role";
	}
	
    @RequestMapping(value="/login1",method=RequestMethod.GET)  
    public String loginGet(){  
        return "jmlogin";  
    }   
    
    @RequestMapping(value="/login1",method=RequestMethod.POST)
    public ModelAndView tool(ModelAndView mv,@RequestParam String action,HttpServletRequest request,HttpSession session,@RequestParam String userName,@RequestParam String password,@RequestParam String code){
	  if("login".equals(action)){
		  mv=loginPost(mv,request,session,userName,password,code);
		  return mv;
	  }
		return null;
    }

	public ModelAndView loginPost(ModelAndView mv,HttpServletRequest request,HttpSession session,@RequestParam String userName,@RequestParam String password,@RequestParam String code){  
    	
		User1 user1=iUserServices1.getLogin(userName, password);
        System.out.println("$$$$$$$$$$$$$$"+user1.getUserName());
        HttpSession session1=request.getSession();
    	String sessionCode = (String)session.getAttribute(Const.SESSION_SECURITY_CODE);  
        mv=new ModelAndView();
        String errInfo = "";  
        if(sessionCode.equalsIgnoreCase(code)){  
            if(user1!=null && password.equals(user1.getPassword())){  
                session.removeAttribute(Const.SESSION_SECURITY_CODE);  
            }else{
        		errInfo="用户名或密码有误";
        	}
        }else{  
            errInfo = "验证码输入有误！";  
        }  
        if(null==errInfo || "".equals(errInfo) ||"null".equals(errInfo)){
        		String roleName=iRoleServices.getRoleNameById(user1.getRoleId());
        		System.out.println(roleName);
            	if("超级管理员".equals(roleName)){
            		session1.setAttribute("username","欢迎"+user1.getUserName()+"登录成功");
                	mv.setViewName("index");  
        	  }
            	if("前台".equals(roleName)){
            		session1.setAttribute("username","欢迎"+user1.getUserName()+"登录成功");
                	mv.setViewName("find");
            	}
            	if("加盟商".equals(roleName)){
            		session1.setAttribute("username","欢迎"+user1.getUserName()+"登录成功");
                	mv.setViewName("main");
            	}
        }else{  
            mv.addObject("errInfo", errInfo);  
            mv.addObject("loginname",userName);  
            mv.addObject("password",password);  
            mv.setViewName("jmlogin");  
        }
		return mv;
    }  
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/l")
	public String tes(){
		return "users";
	}
	
    @RequestMapping(value="/list")  
//    @ResponseBody  
    public String selectAllUser(@RequestParam(value="page",required=false) String page,@RequestParam(value="rows",required=false) String rows,String username,HttpServletResponse response,JMUser jmuser) throws Exception{ 
    	List<JMUser> listUser=new ArrayList<>();
    	PageBean pageBean=new PageBean(Integer.parseInt((page==null||page=="0")?"1":page),Integer.parseInt((rows == null || rows == "0") ? "10":rows));
    	Map<String,Object> map=new HashMap<String,Object>();
		JSONObject result=new JSONObject();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		map.put("username",username);
		if(map.get(username)==null&map.get(username)==""){
//        	listUser=iuserServices.getSelAllUser();
        	listUser=iUserServices1.getSeleAllUserFen(pageBean);
        	JSONArray jsonArray=JSONArray.fromObject(listUser);
        	int total=iUserServices1.getSelAllUserNum();
        	result.put("rows", jsonArray);
        	result.put("total", total);
        	for(JMUser u:listUser){
        	System.out.println(u.getJmid());
        	}
        }else{
//        	Map<String,Object> map1=new HashMap<>();
        	listUser=iUserServices1.getFind(map);
        	JSONArray jsonArray=JSONArray.fromObject(listUser);
        	int total=iUserServices1.getSelAllUserNum1(username);
        	result.put("rows",jsonArray);
        	result.put("total",total);
        	for(JMUser u:listUser){
        		System.out.println(u.getLoginname());
        	}
        }
    	ResponseUtil.write(response,result);
        return null;
    }  
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(JMUser jmuser,HttpServletRequest request){
    	boolean i=false;
    	Map<String,Object> data=new HashMap<>();
    	String jmid=request.getParameter("jmid");
    	System.out.println("行是多少："+jmid);
    	String loginname=request.getParameter("loginname");
    	String password=request.getParameter("password");
    	String username=request.getParameter("username");
    	String rights=request.getParameter("rights");
    	String status=request.getParameter("status");
    	String roleid=request.getParameter("roleId");
    	if(jmid==null){
    		if(loginname!=null&password!=null&username!=null&rights!=null&status!=null&roleid!=null){
    			jmuser=new JMUser(null,loginname,username,password,rights,Integer.valueOf(status),Integer.valueOf(roleid));
    			i=iUserServices1.getAdd(jmuser);
    			System.out.println("密码为:"+jmuser.getPassword());
    		}
    	}else{
    		if(loginname!=null&password!=null&username!=null&rights!=null&status!=null&roleid!=null){
    			jmuser=new JMUser(Integer.valueOf(jmid),loginname,username,password,rights,Integer.valueOf(status),Integer.valueOf(roleid));
    			i=iUserServices1.getUpdate(jmuser);
    			System.out.println("密码为:"+jmuser.getPassword());
    		}
    	}
    	
    	data.put("result1", i);
    	System.out.println("map的值为"+data.get("result1"));
//    	String json=JSON.toJSONString(data);
		return data;
    }
    
    @RequestMapping(value="/delete")
    @ResponseBody
    public Map<String,Object> delect(HttpServletRequest request,@RequestParam(value="jmid") String jmid){
    	Map<String,Object> data=new HashMap<>();
    	String[] idstr=jmid.split(",");
    	for(String s:idstr){
    		boolean i=iUserServices1.getDelete(Integer.valueOf(s));
    		System.out.println("是否删除成功呢"+i);
    		data.put("result1",i);
    	}
		return data;
    }
}