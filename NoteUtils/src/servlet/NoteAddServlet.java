package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import service.NoteServiceImpl;
import domain.AppNote;

/**
 * @author liumx  E-mail: liumx9595@126.com
 * @version ����ʱ�䣺2017-4-23  ����11:03:01
 * tags
 */
@WebServlet("/NoteAddServlet")
public class NoteAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//��ȡ������
				AppNote note=new AppNote();
				try {
					BeanUtils.populate(note, request.getParameterMap());
				} catch (IllegalAccessException | InvocationTargetException e1) {
					e1.printStackTrace();
				}
				//����ҵ���߼�
				NoteServiceImpl ns=new NoteServiceImpl();
				ns.addNote(note);
				
			}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
