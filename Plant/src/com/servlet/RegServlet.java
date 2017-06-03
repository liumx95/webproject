package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
 * @version 创建时间：2017-3-25  下午11:03:41
 * tags
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		   request.setCharacterEncoding("UTF-8");
		//获取表单数据
		AppUser user=new AppUser();
		try {
			BeanUtils.populate(user,request.getParameterMap());
			System.out.println(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用业务逻辑
        UserService us=new UserServiceImpl();
        try {
        if(us.checkout(user).getCount()==0){
        	us.register(user);
        	Map result=new HashMap();
            result.put("result_code", 0);
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
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
