package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.StreamUtil;

import com.alibaba.fastjson.JSON;
import com.domain.AppFlower;
import com.utils.DBUtil;

/**
 * @author liumx  E-mail: liumx9595@126.com
 * @version 创建时间：2017-4-20  下午4:40:36
 * tags
 */
@WebServlet("/FlowerServlet")
public class FlowerServlet extends HttpServlet {
	Connection conn=null;
	PreparedStatement ps=null;
	InputStream is = null;
	OutputStream os = null;
	ResultSet rs = null;
	//AppFlower flower;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement("select fname,fword,fimage from AppFlower where fname=?");
			ps.setString(1,request.getParameter("fname"));
			rs = ps.executeQuery();
			while(rs.next()){
			AppFlower flower = new AppFlower();
			flower.setFname(rs.getString(1));	
			flower.setFword(rs.getString(2));
			flower.setFimage(rs.getString(3));
			System.out.println(flower.toString());
			String flowerJson = JSON.toJSONString(flower);  
			 OutputStream out = response.getOutputStream();  
	         out.write(flowerJson.getBytes("UTF-8"));
	       
	        }
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
				e.printStackTrace();
			}
	      DBUtil.closeAll(rs, ps, conn);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
