package service;

import java.sql.SQLException;
import java.util.List;

import dao.NoteDaoImpl;
import domain.AppNote;

public class NoteServiceImpl {
	//����һ��Dao����
	NoteDaoImpl noteDao=new NoteDaoImpl();
	//��ѯ�ʼ�
	public List<AppNote> findAllNotes(AppNote note) throws SQLException{
		return noteDao.findAllNotes(note);
	}
	//��ӱʼǷ���
	public void addNote(AppNote note){
		try {
			noteDao.addNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�޸ıʼ�
	public void updateNote(AppNote note){
		try {
			noteDao.updateNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ɾ���ʼ�
	public void deleteNote(AppNote note){
		try {
			noteDao.deleteNote(note);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
