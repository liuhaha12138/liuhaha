package SQLManager;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import JX.jx;
import net.sf.json.JSONArray;


public class sqlmanager {
	
	 private static Connection conn=null;   
	 private static PreparedStatement ps=null;  
	   
	 private static ResultSet rs=null;  
	
	 public static  Connection openConnection() throws SQLException, Exception{  
	 String driverName = "com.mysql.jdbc.Driver";  
	 String dbURL = "jdbc:mysql://localhost:3306/teacher?useUnicode=true&characterEncoding=utf-8";
	 String userName = "root";  
	 String userPwd = "123456";  
	 try{  
	 Class.forName(driverName);  
	  conn = DriverManager.getConnection(dbURL, userName,userPwd);
	  System.out.println("连接数据库成功");  
	 }  
	 catch (Exception e){  
	 e.printStackTrace();  
	 System.out.println("连接失败");
	 }	 
	return conn;
	
	 }
	 
	 

	 
//连接数据库后，
	 public static void storage() throws Exception, Exception{
	 String JsonContext = new jx().ReadFile("C:\\Users\\Administrator\\Desktop\\J2son");
	 System.out.println("获取文件成功");
	 JSONArray jsonArr = JSONArray.fromObject(JsonContext);
	     
        String kssj[] = new String[jsonArr.size()];  
        String jsxm[] = new String[jsonArr.size()];  
        String jsmc[] = new String[jsonArr.size()];  
        String kcmc[] = new String[jsonArr.size()]; 
        String jkjs1[] = new String[jsonArr.size()];  
        String jkjs2[] = new String[jsonArr.size()];  
        String jkjs3[] = new String[jsonArr.size()];  
        String jkjs4[] = new String[jsonArr.size()];  
        String xn[] = new String[jsonArr.size()];  
        String xq[]= new String[jsonArr.size()];  
        String xkkh[] = new String[jsonArr.size()];  
        String jsbh[] = new String[jsonArr.size()];  
        String jszgh1[] =new String[jsonArr.size()];
        String jszgh2[] =new String[jsonArr.size()];
        String jszgh3[] =new String[jsonArr.size()];
        String jszgh4[] =new String[jsonArr.size()];
        
       
        
        String strSQL = ""; 
        Connection conn=sqlmanager.openConnection();
        conn.setAutoCommit(false);    
        Statement stmt=conn.createStatement();
        
        for (int i = 0; i < jsonArr.size(); i++) {  
            int j=i+1;
            xn[i] = jsonArr.getJSONObject(i).getString("xn");  
            xq[i] = jsonArr.getJSONObject(i).getString("xq");  
            kcmc[i] = jsonArr.getJSONObject(i).getString("kcmc");  
            kssj[i] = jsonArr.getJSONObject(i).getString("kssj");  
            xkkh[i] = jsonArr.getJSONObject(i).getString("xkkh");  
            jsxm[i] = jsonArr.getJSONObject(i).getString("jsxm");  
            jsbh[i] = jsonArr.getJSONObject(i).getString("jsbh");  
            jsmc[i] = jsonArr.getJSONObject(i).getString("jsmc");  
            jkjs1[i] = jsonArr.getJSONObject(i).getString("jkjs1");  
            jkjs2[i] = jsonArr.getJSONObject(i).getString("jkjs2");  
            jkjs3[i] = jsonArr.getJSONObject(i).getString("jkjs3");  
            jkjs4[i] = jsonArr.getJSONObject(i).getString("jkjs4");
            jszgh1[i] = jsonArr.getJSONObject(i).getString("jszgh1");
            jszgh2[i] = jsonArr.getJSONObject(i).getString("jszgh2");
            jszgh3[i] = jsonArr.getJSONObject(i).getString("jszgh3");
            jszgh4[i] = jsonArr.getJSONObject(i).getString("jszgh4");


		

        strSQL = "INSERT into examall (xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4) values("
        	+ "'" + xn[i] + "'"+","
       + "'" + xq[i] + "'"+","
       + "'" + kcmc[i] + "'"+","
       + "'" + kssj[i] + "'"+","
       + "'" + xkkh[i] + "'"+","
       + "'" + jsxm[i] + "'"+","
       + "'" + jsbh[i] + "'"+","
       + "'" + jsmc[i] + "'"+","
       + "'" + jkjs1[i] + "'"+","
       + "'" + jkjs2[i] + "'"+","
       + "'" + jkjs3[i] + "'"+","
       + "'" + jkjs4[i] + "'"+","
       + "'" + jszgh1[i] + "'"+","
       + "'" + jszgh2[i] + "'"+","
       + "'" + jszgh3[i] + "'"+","
       + "'" + jszgh4[i] + "'"
       
       +")"; 
        
        try {  
        	  
          
                  
        	 String sql = "select id from examall where id =" + "'"  
             +j+"';";  
             System.out.println("最近考试课程====="+kcmc[i]);  
    
     ResultSet rs = stmt.executeQuery(sql); // 查询数据库看数据是否已经存在  
     if (rs.next()) { // 该条数据已经存在  
         // PublicName.getValue(0,0);  
    	 
         System.out.println("（已存在考试信息）");  
        
     } else {  

         stmt.executeUpdate(strSQL); 
   
     }  
     rs.close();  
 } catch (Exception e) {  
     e.printStackTrace();  
                
        }
        }  
        
        conn.commit();
        closeConnection();
        
    } 
	 
	 
	 
	 
	 public static void closeConnection(){  
	 try {  
	 conn.close();
	 System.out.println("数据库关闭成功");
	 
	 } catch (Exception e) {  
	 e.printStackTrace();  
	 }  
	 } 

	  public static boolean executeQuery(String sql,String []parameters){  
	   try{  
	   ps=conn.prepareStatement(sql);  
	   if(parameters!=null && !rs.equals("")){  
	   for(int i=0; i<parameters.length; i++){  
	   ps.setString(i+1, parameters[i]);  
	   }  
	   }  
	  rs=ps.executeQuery();   
  if(rs.next())  
	  return true;  
	  else  
	  return false;  
	   }catch(Exception e){  
	  e.printStackTrace();  
	  throw new RuntimeException(e.getMessage());  
	   }finally{  
	   }  
	 //  System.out.println(url+username+password);  
	   }  
	  
	  
	 public static void update(String sql, String[] parmeters) {  
	   
	   
	 try {  
	 ps = conn.prepareStatement(sql);  
	 if (parmeters != null) {  
	 for (int i = 0; i < parmeters.length; i++) {  
	 ps.setString(i + 1, parmeters[i]);  
	 }  
	 }  
	 ps.executeUpdate();  
	 } catch (Exception e) {  
	 e.printStackTrace();  
	 }   

}}
