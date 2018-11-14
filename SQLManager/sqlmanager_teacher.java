package SQLManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONArray;
import JX.jx;

public class sqlmanager_teacher {	 
		 public static void storage() throws Exception, Exception{
		 String JsonContext = new jx().ReadFile("C:\\Users\\Administrator\\Desktop\\J2son_teacher");
		 System.out.println("获取文件成功");
		 JSONArray jsonArr = JSONArray.fromObject(JsonContext);
		     
	        String zgh[] = new String[jsonArr.size()];  
	        String xm[] = new String[jsonArr.size()];  
	        String lxdh[] = new String[jsonArr.size()];  
	        String bm[] = new String[jsonArr.size()]; 
	        String qx[] = new String[jsonArr.size()];  
	        
	        String strSQL = ""; 
	        Connection conn=sqlmanager.openConnection();
	        conn.setAutoCommit(false);    
	        Statement stmt=conn.createStatement();
	        
	        for (int i = 0; i < jsonArr.size(); i++) {  
	
	            zgh[i] = jsonArr.getJSONObject(i).getString("zgh");  
	            xm[i] = jsonArr.getJSONObject(i).getString("xm");  
	            lxdh[i] = jsonArr.getJSONObject(i).getString("lxdh");  
	            bm[i] = jsonArr.getJSONObject(i).getString("bm");
	            String sql1 = "INSERT INTO teacher(zgh,lxdh,xm,bm) "+
	            " VALUES ('"+zgh[i]+"','"+lxdh[i]+"','"+xm[i]+"','"+bm[i]+"')" ;  
	            String sql2 = "select * from teacher where zgh="+"'"+zgh[i]+"'"; 
	            String sql3 ="update teacher set lxdh="+"'"+lxdh[i]+"'"+" where zgh="+"'"+zgh[i]+"'";
	            
			try {
				     
	             ResultSet rs = stmt.executeQuery(sql2); // 查询数据库看数据是否已经存在  
	     if (rs.next()) { // 该条数据已经存在  
	         // PublicName.getValue(0,0);  
	    	 
	         System.out.println("（已存在教师信息）");  
	         System.out.println(sql3);
	         stmt.executeUpdate(sql3);
	    
	     } else {  

	         stmt.executeUpdate(sql1); 
	   
	     }  
	     rs.close();  
	 } catch (Exception e) {  
	     e.printStackTrace();  
	                
	        }
	        }  

	     
	        conn.commit();
	        conn.close();
	        
	    } 
}
		
