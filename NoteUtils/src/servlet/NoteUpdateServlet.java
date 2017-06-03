package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import service.NoteServiceImpl;

import com.alibaba.fastjson.JSON;

import domain.AppNote;

/**
 * @author liumx  E-mail: liumx9595@126.com
 * @version 创建时间：2017-4-23  下午11:23:56
 * tags
 */
@WebServlet("/NoteUpdateServlet")
public class NoteUpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//获取表单数据
		AppNote note=new AppNote();
		try {
			BeanUtils.populate(note, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		//调用业务逻辑
		NoteServiceImpl ns=new NoteServiceImpl();
		ns.updateNote(note);
		
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
