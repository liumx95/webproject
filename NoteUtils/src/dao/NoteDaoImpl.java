package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import servlet.DBCPUtil;



import domain.AppNote;

public class NoteDaoImpl {
	/**
	 * �鿴���еıʼ�
	 * @throws SQLException
	 */
  public List<AppNote> findAllNotes(AppNote note) throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  return qr.query("select id,userid,title,word from AppNote where userid=?", new BeanListHandler<AppNote>(AppNote.class),note.getUserid());
  }
  /**
   * ���ӱʼ���Ϣ
   * @param note
   */
  public void addNote(AppNote note)throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  qr.update("insert into appnote(userid,title,word) values(?,?,?)",note.getUserid(),note.getTitle(),note.getWord());
  }
  /**
   * �޸ıʼ���Ϣ
   */
  public void updateNote(AppNote note)throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  qr.update("update appnote set title=?,word=? where id=?",note.getTitle(),note.getWord(),note.getId());
  }
  /**
   * ɾ���ʼ�
   */
  public void deleteNote(AppNote note)throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  qr.update("delete from appnote where id=?",note.getId());
	  
  }
}

