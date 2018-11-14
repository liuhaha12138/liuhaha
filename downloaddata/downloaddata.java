package downloaddata;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;

import java.io.OutputStreamWriter;

import SQLManager.sqlmanager;

import loadJson.loadJson;

@SuppressWarnings("unused")
public class downloaddata {
	
public static void loaddata() throws Exception, Exception {  
	
	Connection connection=sqlmanager.openConnection();
	Statement stmt1= connection.createStatement();
	Statement stmt2= connection.createStatement();
	Statement stmt3= connection.createStatement();
	Statement stmt4= connection.createStatement();
	Statement stmt5= connection.createStatement();
	Statement stmt6= connection.createStatement();
	Statement stmt7= connection.createStatement();
	Statement stmt8= connection.createStatement();
	Statement stmt9= connection.createStatement();
	Statement stmt10= connection.createStatement();
	Statement stmt11= connection.createStatement();
	Statement stmt12= connection.createStatement();
	Statement stmt13= connection.createStatement();
	
	
	String sql1 = "select usern from URL";
	String sql2 = "select pwd from URL";
	String sql3 = "select xn from URL";
	String sql4 = "select xq from URL";
	
	String sql5 = "select ip from URL";
	String sql6 = "select NAME from URL";
	String sql7 = "select PASS from URL";
	String sql8 = "select XUEN from URL";
	String sql9 = "select XUEQ from URL";
	String sql10 = "select path from URL";
	String sql11 = "select usertype from URL";
	String sql12 = "select cs from URL";
	String sql13 = "select cssx from URL";
	
	ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2= stmt2.executeQuery(sql2);
	ResultSet rs3 = stmt3.executeQuery(sql3);
	ResultSet rs4 = stmt4.executeQuery(sql4);
	ResultSet rs5 = stmt5.executeQuery(sql5);
	ResultSet rs6 = stmt6.executeQuery(sql6);
	ResultSet rs7 = stmt7.executeQuery(sql7);
	ResultSet rs8 = stmt8.executeQuery(sql8);
	ResultSet rs9 = stmt9.executeQuery(sql9);
	ResultSet rs10 = stmt10.executeQuery(sql10);
	ResultSet rs11 = stmt11.executeQuery(sql11);
	ResultSet rs12 = stmt12.executeQuery(sql12);
	ResultSet rs13 = stmt13.executeQuery(sql13);
	
	connection.setAutoCommit(false);
	connection.commit();
	connection.setAutoCommit(true);
	
	List<String> list=new ArrayList<String>();
	List<String> list2=new ArrayList<String>();
	List<String> list3=new ArrayList<String>();
	List<String> list4=new ArrayList<String>();
	List<String> list5=new ArrayList<String>();
	List<String> list6=new ArrayList<String>();
	List<String> list7=new ArrayList<String>();
	List<String> list8=new ArrayList<String>();
	List<String> list9=new ArrayList<String>();
	List<String> list10=new ArrayList<String>();
	List<String> list11=new ArrayList<String>();
	List<String> list12=new ArrayList<String>();
	List<String> list13=new ArrayList<String>();
	
	while (rs1.next()){//如果有数据，取第一列添加如list  
        list.add(rs1.getString(1)); 
       }  
	while (rs2.next()){//如果有数据，取第一列添加如list  
        list2.add(rs2.getString(1)); 
       }  
	while (rs3.next()){//如果有数据，取第一列添加如list  
        list3.add(rs3.getString(1)); 
       }  
	while (rs4.next()){//如果有数据，取第一列添加如list  
        list4.add(rs4.getString(1)); 
       }  
	while (rs5.next()){//如果有数据，取第一列添加如list  
        list5.add(rs5.getString(1)); 
       } 
	while (rs6.next()){//如果有数据，取第一列添加如list  
        list6.add(rs6.getString(1)); 
       } 
	while (rs7.next()){//如果有数据，取第一列添加如list  
        list7.add(rs7.getString(1)); 
       } 
	while (rs8.next()){//如果有数据，取第一列添加如list  
        list8.add(rs8.getString(1)); 
       } 
	while (rs9.next()){//如果有数据，取第一列添加如list  
        list9.add(rs9.getString(1)); 
       } 
	while (rs10.next()){//如果有数据，取第一列添加如list  
        list10.add(rs10.getString(1)); 
       } 
	while (rs11.next()){//如果有数据，取第一列添加如list  
        list11.add(rs11.getString(1)); 
       } 
	while (rs12.next()){//如果有数据，取第一列添加如list  
        list12.add(rs12.getString(1)); 
       }
	while (rs13.next()){//如果有数据，取第一列添加如list  
        list13.add(rs13.getString(1)); 
       }

    String usern=list.get(0);
    String pwd=list2.get(0);
    String xn=list3.get(0);
    String xq=list4.get(0);
    String ip=list5.get(0);
    String NAME=list6.get(0);
    String PASS=list7.get(0);
    String XUEN=list8.get(0);
    String XUEQ=list9.get(0);
    String path=list10.get(0);
    String usertype=list11.get(0);
    String cs=list12.get(0);
    String cssx=list13.get(0);
    sqlmanager.closeConnection();
	
	String url =""+String.valueOf(ip)+String.valueOf(path)+String.valueOf(usertype)+String.valueOf(NAME)+String.valueOf(usern)+String.valueOf(PASS)+String.valueOf(pwd)+String.valueOf(XUEN)+String.valueOf(xn)+String.valueOf(XUEQ)+String.valueOf(xq)+String.valueOf(cssx)+String.valueOf(cs);   
    String json = loadJson.loadJ2son(url); 
      
    System.out.print(url);    
    String sDestFile = "C:\\Users\\Administrator\\Desktop\\J2son";

    File destFile = new File(sDestFile);
    if (!destFile.exists()) {

    destFile.createNewFile();
    
    }

    writeByFileWrite(sDestFile, json);
    
}



public static void writeByFileWrite(String _sDestFile, String _sContent)

throws IOException {

FileWriter fw = null;

try {

fw = new FileWriter(_sDestFile);

fw.write(_sContent);

} catch (Exception ex) {

ex.printStackTrace();

} finally {

if (fw != null) {

fw.close();

fw = null;

}

}

}

}