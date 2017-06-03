package service;

import java.sql.SQLException;
import java.util.List;

import dao.NoteDaoImpl;
import domain.AppNote;

public class NoteServiceImpl {
	//创建一个Dao对象
	NoteDaoImpl noteDao=new NoteDaoImpl();
	//查询笔记
	public List<AppNote> findAllNotes(AppNote note) throws SQLException{
		return noteDao.findAllNotes(note);
	}
	//添加笔记服务
	public void addNote(AppNote note){
		try {
			noteDao.addNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//修改笔记
	public void updateNote(AppNote note){
		try {
			noteDao.updateNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除笔记
	public void deleteNote(AppNote note){
		try {
			noteDao.deleteNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
