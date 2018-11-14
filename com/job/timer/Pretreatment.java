package com.job.timer;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import SQLManager.sqlmanager;

public class Pretreatment {
	
	public static void Prepare() throws SQLException, Exception{
        Connection conn=sqlmanager.openConnection();
        conn.setAutoCommit(false);    
        Statement stmt=conn.createStatement();
        stmt.execute("TRUNCATE TABLE examall");
        stmt.execute("TRUNCATE TABLE teacher");
        conn.close();
        String dh = "C:\\Users\\Administrator\\Desktop\\J2son_teacher";
        String jk = "C:\\Users\\Administrator\\Desktop\\J2son";
        deleteFile(dh);
        deleteFile(jk);
	}
	public static boolean deleteFile(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 

}
