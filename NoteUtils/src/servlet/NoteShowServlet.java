package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import domain.AppNote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import service.NoteServiceImpl;
import servlet.*;



/**
 * @author liumx  E-mail: liumx9595@126.com
 * @version 创建时间：2017-4-20  下午4:00:43
 * tags
 */
@WebServlet("/NoteShowServlet")
public class NoteShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取表单数据
		AppNote note=new AppNote();
		try {
			System.out.println("---------笔记-------------");
			BeanUtils.populate(note, request.getParameterMap());
			System.out.println(request.getParameter("userid"));
			System.out.println(note);
			
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		//调用业务逻辑
		NoteServiceImpl ns=new NoteServiceImpl();
	
				List<AppNote> list;
				try {
					list = ns.findAllNotes(note);
					System.out.println(list);
	     			String jsonString=net.sf.json.JSONArray.fromObject(list).toString();				
	     			response.getWriter().println(jsonString);   
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
