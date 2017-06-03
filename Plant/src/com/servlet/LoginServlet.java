package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.domain.AppUser;
import com.service.impl.UserService;
import com.service.impl.UserServiceImpl;

/**
 * @author liumx  E-mail: liumx9595@126.com
 * @version 创建时间：2017-3-26  下午2:58:37
 * tagsss
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		AppUser user=new AppUser();
		try {
			Map map=request.getParameterMap();
			BeanUtils.populate(user,request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserService us=new UserServiceImpl();
		try {
			user=us.login(user);
			if(user!=null){
				Map result=new HashMap();
		        result.put("result_code", 0);
		        result.put("id",user.getId());
		        result.put("petname", user.getPetname());
		        result.put("uname", user.getUname());
		        result.put("pwd", user.getPwd());
		        result.put("mail", user.getMail());
		        String userJson = JSON.toJSONString(result);  
		        OutputStream out = response.getOutputStream();  
		        out.write(userJson.getBytes("UTF-8"));
		        }else{
		        	Map result=new HashMap();
		            result.put("result_code", 1);
		            String userJson = JSON.toJSONString(result);  
		            OutputStream out = response.getOutputStream();  
		            out.write(userJson.getBytes("UTF-8"));
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.setAttribute("u", user);
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
