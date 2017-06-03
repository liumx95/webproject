package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import servlet.DBCPUtil;



import domain.AppNote;

public class NoteDaoImpl {
	/**
	 * 查看所有的笔记
	 * @throws SQLException
	 */
  public List<AppNote> findAllNotes(AppNote note) throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  return qr.query("select id,userid,title,word from AppNote where userid=?", new BeanListHandler<AppNote>(AppNote.class),note.getUserid());
  }
  /**
   * 增加笔记信息
   * @param note
   */
  public void addNote(AppNote note)throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  qr.update("insert into appnote(userid,title,word) values(?,?,?)",note.getUserid(),note.getTitle(),note.getWord());
  }
  /**
   * 修改笔记信息
   */
  public void updateNote(AppNote note)throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  qr.update("update appnote set title=?,word=? where id=?",note.getTitle(),note.getWord(),note.getId());
  }
  /**
   * 删除笔记
   */
  public void deleteNote(AppNote note)throws SQLException{
	  QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	  qr.update("delete from appnote where id=?",note.getId());
	  
  }
}

