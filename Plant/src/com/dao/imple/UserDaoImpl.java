package com.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.dao.UserDao;
import com.domain.AppUser;
import com.domain.SameUser;
import com.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(AppUser user) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("insert into APPUSER(petname,uname,pwd,mail) values(?,?,?,?)");
		ps.setString(1,user.getPetname());
		ps.setString(2,user.getUname());
		ps.setString(3,user.getPwd());
		ps.setString(4,user.getMail());
		System.out.println(ps);
		int i = ps.executeUpdate();
		DBUtil.closeAll(null, ps, conn);
	}

	@Override
	public AppUser findUser(AppUser user) throws Exception {
     Connection conn=null;
     PreparedStatement ps=null;
     ResultSet rs=null;
     AppUser u=null;
     conn=DBUtil.getConnection();
     ps=conn.prepareStatement("select id,petname,uname,pwd,mail from APPUSER where uname=? and pwd=?");
	 ps.setString(1, user.getUname());
	 ps.setString(2, user.getPwd());
	 rs=ps.executeQuery();
	 if(rs.next()){
		 u=new AppUser();
		 u.setId(rs.getInt(1));
		 u.setPetname(rs.getString(2));
		 u.setUname(rs.getString(3));
		 u.setPwd(rs.getString(4));
		 u.setMail(rs.getString(5));
	 }
		DBUtil.closeAll(rs, ps, conn);
		return u;
	}

	@Override
	public SameUser sameUser(AppUser user) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		SameUser su=new SameUser();
		conn=DBUtil.getConnection();
		ps=conn.prepareStatement("select count(*) count from appuser where uname=?");
		ps.setString(1,user.getUname());
		rs=ps.executeQuery();
		if(rs.next()){
			su.setCount(rs.getInt(1));
		}
		return su;
	}

}
