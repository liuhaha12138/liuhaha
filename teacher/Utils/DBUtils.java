package teacher.Utils;

import java.sql.*;
public class DBUtils {
	
	
	
   public static  Connection getCon()
   {
	   try
	   {
		  Class.forName("com.mysql.jdbc.Driver") ;
		     
			 String dbURL = "jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=utf-8";
			 String userName = "root";  
			 String userPwd = "123456";  
			 Connection conn=DriverManager.getConnection(dbURL, userName,userPwd);
		  System.out.println("数据库连接成功");
		  return conn;
	   }
	   
	   catch (Exception e){
		   e.printStackTrace();
		   return null;
		   
		   
	   }
   }
}
