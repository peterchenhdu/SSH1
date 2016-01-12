package ssh.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import ssh.aop.AopTest;
import ssh.model.User;
import ssh.service.UserService;

import com.google.gson.Gson;

@Controller
public class UserAction {
	Logger logger = Logger.getLogger(UserAction.class);
	@Resource
	private UserService userService;
	@Resource
	private AopTest aopTest;
	
	public void addUser(){
		PrintWriter out = null;
		

		
		try{
	        HttpServletRequest request = ServletActionContext.getRequest();
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("text/html;charset=UTF-8");
	        String account = request.getParameter("account");
	        String name = request.getParameter("name");
	        String address = request.getParameter("address"); 
	        User user = new User();
	        user.setAccount(account);
	        user.setAddress(address);
	        user.setName(name);
	        userService.add(user);
			out = response.getWriter();
			out.write(new Gson().toJson("success"));
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			if(out != null)
				out.write(new Gson().toJson("fail"));
		}finally{
			out.flush();
			out.close();
		}
        
	}
	
	
	public void queryAllUser(){
		PrintWriter out = null;
		
		aopTest.test1();
		aopTest.test2();
		//logger.error("i");
		try {
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("text/html;charset=UTF-8");
	
	        Gson gson = new Gson();
	        List<User> userList= userService.queryAllUser();
	        String gsonStr = gson.toJson(userList);
	        
		    out = response.getWriter();
		    out.write(gsonStr);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			if(out != null)
				out.write(new Gson().toJson("fail"));
		}finally{
			out.flush();
			out.close();
		}
	}
}
