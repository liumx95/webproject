package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {
	public static DataSource ds=null;
	public static DataSource getDataSource(){
		return ds;
		
	}
	
	static{
		java.util.Properties prop=new java.util.Properties();
		try {
			prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			ds=BasicDataSourceFactory.createDataSource(prop);
		} catch (IOException e) {
		    throw new ExceptionInInitializerError("初始化错误，请检查配置文件");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("服务器异常");
		}
		
	}
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();//关闭
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

}
