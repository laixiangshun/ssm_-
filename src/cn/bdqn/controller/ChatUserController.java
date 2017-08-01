package cn.bdqn.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bdqn.services.IChatUserServices;

@Controller
@Transactional
public class ChatUserController extends HttpServlet{
	
	@Autowired
	private IChatUserServices iChatUserServices;
	
	HttpSession session ;  
    ServletContext application;
    
    @RequestMapping(value="/toLogin.html")
	 public String toLogin(HttpServletRequest request,Model model){  
	        return "chatlogin";  
   }
	 
	 @RequestMapping(value="/login.html",method = RequestMethod.POST)  
	    public void login(HttpServletRequest request,Model model,PrintWriter out){  
	        String loginname = request.getParameter("loginname");  
	        String password = request.getParameter("password");  
	        String s = iChatUserServices.login(loginname, password);
	        System.out.println("s为什么:"+s);
	        session = request.getSession();  
	        if(s=="success"){  
	            session.setAttribute("loginname", loginname); // 保存当前登录的用户名  
	            
	            application = request.getSession().getServletContext();  
	            if(application.getAttribute("onLine")==null){  
	                application.setAttribute("onLine", "");  
	            }  
	            String onLine = application.getAttribute("onLine").toString();  
	            onLine +=loginname+"<br/>";  
	            application.setAttribute("onLine", onLine);  
	        }  
	        //写入返回结果  
	        out.write(s);  
	    }  
	      
	    /** 
	     * 控制跳转到聊天主界面 
	     * @param request 
	     * @param model 
	     * @return 
	     */  
	    @RequestMapping("/toChatMain.html")  
	    public String toChatMain(HttpServletRequest request,Model model){  
	        return "chatMain";  
	    }  
	      
	    /** 
	     * 前端发送聊天内容 
	     * @param request 
	     * @param model 
	     */  
	    @RequestMapping("sentContent.html")  
	    public void sentContent(HttpServletRequest request,Model model,PrintWriter out){  
	        //存储信息的全局变量  
	        application = request.getSession().getServletContext();  
	        session = request.getSession();  
	        if(application.getAttribute("message")==null){  
	            application.setAttribute("message", "");  
	        }  
	        //获取application中存储的聊天内容  
	        String sourceMessage = application.getAttribute("message").toString();  
	        //获取前端发送的聊天内容  
	        String content = request.getParameter("content");  
	        content = content.replace("<:", "<img src='/ssm3/images/face/");  
	        content = content.replace(":>", ".bmp'/>");  
	        // 获取session中的登陆者  
	        String loginname = session.getAttribute("loginname").toString();  
	        sourceMessage += this.getTime()+ "<font color='blue'><strong> "+loginname+"</strong></font> :"+content+"</br>";  
	        application.setAttribute("message", sourceMessage);  
	        //写入返回结果  
	        out.write("success");  
	    }  
	      
	    /** 
	     * 前端定时获取聊天信息 
	     * @param request 
	     * @param model 
	     * @param out 
	     */  
	    @RequestMapping("/getMassageList.html")  
	    public void getMassageList(HttpServletRequest request,Model model,PrintWriter out){  
	        application = request.getSession().getServletContext();  
	        if(application.getAttribute("message")==null){  
	            application.setAttribute("message", "");  
	        }  
	        //获取application中存储的聊天内容  
	        String sourceMessage = application.getAttribute("message").toString();  
	        String str = null;  
	        try {  
	            str = new String (sourceMessage.getBytes(), "utf-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        out.write(str);  
	    }  
	      
	    /** 
	     * 前端定时获取在线人员 
	     * @param request 
	     * @param model 
	     * @param out 
	     */  
	    @RequestMapping("getOnlineList.html")  
	    public void getOnlineList(HttpServletRequest request,Model model,PrintWriter out){  
	       int i=0;
	       i++;
	    	application = request.getSession().getServletContext();  
	        if(application.getAttribute("onLine")==null){  
	            application.setAttribute("onLine", "");  
	        }  
	        //获取application中存储在 线人员  
	        String sourceOnline =application.getAttribute("onLine").toString();  
	        out.write(sourceOnline);  
	    }  
	      
	    /** 
	     * 自定义日期格式 
	     * @return 
	     */  
	    private String getTime(){  
	        Date date = new Date();  
	        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
	        return df.format(date);  
	    }  
	}