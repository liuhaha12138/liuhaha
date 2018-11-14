package timesend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import SQLManager.sqlmanager;

public class Select {
	
	

	/**
	 * @param args
	 */

	
	public static String[][] selectmysql() throws Exception{
	      
		
        Connection conn=sqlmanager.openConnection();
        
        Statement stmt01 = conn.createStatement(); 
        Statement stmt02 = conn.createStatement();
        Statement stmt03 = conn.createStatement();
        Statement stmt04 = conn.createStatement();
        
        Statement stmt001 = conn.createStatement();
        Statement stmt002 = conn.createStatement();
        Statement stmt003=  conn.createStatement();
        Statement stmt004 = conn.createStatement();
        Statement stmt005 = conn.createStatement();
        Statement stmt006 = conn.createStatement();
        Statement stmt007 = conn.createStatement();
        Statement stmt008 = conn.createStatement();
        
        
        
        Statement stmt  = conn.createStatement();  
        Statement stmt2 = conn.createStatement();
        Statement stmt3 = conn.createStatement();
        Statement stmt4 = conn.createStatement();
        Statement stmt5 = conn.createStatement();
        Statement stmt6 = conn.createStatement();
        Statement stmt7 = conn.createStatement();
        Statement stmt8 = conn.createStatement();
        Statement stmt9 = conn.createStatement();
        Statement stmt10 = conn.createStatement();
        Statement stmt11 = conn.createStatement();
        Statement stmt20 = conn.createStatement();
        Statement stmt21 = conn.createStatement();
        Statement stmt22 = conn.createStatement();
        Statement stmt23 = conn.createStatement();
        Statement stmt24 = conn.createStatement();
        conn.setAutoCommit(false);// 更改jdbc事务的默认提交方式 
       
        String idString="select id from examall";
        String sql = "select kssj from examall";//查询语句  
        String sql2 = "select kcmc from examall";
        String sql3 = "select jsmc from examall";
        String sql4 = "select jkjs1 from examall";
        String sql5= "select jkjs2 from examall";
        String sql6 = "select jkjs3 from examall";
        String sql7= "select jkjs4 from examall";
        String sql8 = "select jszgh1 from examall";
        String sql9 = "select jszgh2 from examall";
        String sql10 = "select jszgh3 from examall";
        String sql11= "select jszgh4 from examall";
        String sql12= "select qx1 from examall";
        String sql13= "select qx2 from examall";
        String sql14= "select qx3 from examall";
        String sql15= "select qx4 from examall";
        String SQL1="select  lxdh1  FROM examall";          
        String SQL2="select  lxdh2  FROM examall";
        String SQL3="select  lxdh3  FROM examall";
        String SQL4="select  lxdh4  FROM examall";
        String Sql1="select  dxtxztz1  FROM examall";
        String Sql2="select  dxtxztz2  FROM examall";
        String Sql3="select  dxtxztz3  FROM examall";
        String Sql4="select  dxtxztz4  FROM examall";
        String Sql5="select  dxtxztt1  FROM examall";
        String Sql6="select  dxtxztt2  FROM examall";
        String Sql7="select  dxtxztt3  FROM examall";
        String Sql8="select  dxtxztt4  FROM examall";
        
        ResultSet rs01 = stmt01.executeQuery(SQL1);
        ResultSet rs02 = stmt02.executeQuery(SQL2);
        ResultSet rs03 = stmt03.executeQuery(SQL3);
        ResultSet rs04 = stmt04.executeQuery(SQL4);
        
        ResultSet rs001 = stmt001.executeQuery(Sql1);
        ResultSet rs002 = stmt002.executeQuery(Sql2);
        ResultSet rs003 = stmt003.executeQuery(Sql3);
        ResultSet rs004 = stmt004.executeQuery(Sql4);
        ResultSet rs005 = stmt005.executeQuery(Sql5);
        ResultSet rs006 = stmt006.executeQuery(Sql6);
        ResultSet rs007 = stmt007.executeQuery(Sql7);
        ResultSet rs008 = stmt008.executeQuery(Sql8);
        
        
        ResultSet rs = stmt.executeQuery(sql);
        ResultSet rs2 = stmt2.executeQuery(sql2);
        ResultSet rs3 = stmt3.executeQuery(sql3);
        ResultSet rs4 = stmt4.executeQuery(sql4);
        ResultSet rs5 = stmt5.executeQuery(sql5);
        ResultSet rs6 = stmt6.executeQuery(sql6);
        ResultSet rs7 = stmt7.executeQuery(sql7);
        ResultSet rs8 = stmt8.executeQuery(sql8);
        ResultSet rs9 = stmt9.executeQuery(sql9);
        ResultSet rs10 = stmt10.executeQuery(sql10);
        ResultSet rs11 = stmt11.executeQuery(sql11);
        ResultSet rs12 = stmt20.executeQuery(sql12);
        ResultSet rs13 = stmt21.executeQuery(sql13);
        ResultSet rs14 = stmt22.executeQuery(sql14);
        ResultSet rs15 = stmt23.executeQuery(sql15);
        //得到结果集  
        ResultSet rs16 = stmt24.executeQuery(idString);
        conn.commit();//事务提交  
               
        
        List<String> list=new ArrayList<String>();//创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组  
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
        List<String> list14=new ArrayList<String>();
        List<String> list15=new ArrayList<String>();
        List<String> list16=new ArrayList<String>();
        List<String> list17=new ArrayList<String>();
        List<String> list18=new ArrayList<String>();
        List<String> list19=new ArrayList<String>();
        List<String> list20=new ArrayList<String>();
        List<String> list21=new ArrayList<String>();
        List<String> list22=new ArrayList<String>();
        List<String> list23=new ArrayList<String>();
        List<String> list24=new ArrayList<String>();
        List<String> list25=new ArrayList<String>();
        List<String> list26=new ArrayList<String>();
        List<String> list27=new ArrayList<String>();
        List<String> list28=new ArrayList<String>();
        
        
        while (rs.next()){//如果有数据，取第一列添加如list  
         list.add(rs.getString(1)); 

        }  
        while (rs2.next()){ 
            list2.add(rs2.getString(1));        
           }  
        
        while (rs3.next()){
            list3.add(rs3.getString(1));        
           }  
        
        while (rs4.next()){  
            list4.add(rs4.getString(1)); 
   
           } 
        while (rs5.next()){ 
            list5.add(rs5.getString(1)); 
   
           } 
        while (rs6.next()){
            list6.add(rs6.getString(1)); 
   
           } 
        while (rs7.next()){
            list7.add(rs7.getString(1)); 
   
           } 
        while (rs8.next()){  
            list8.add(rs8.getString(1)); 
   
           } 
        while (rs9.next()){ 
            list9.add(rs9.getString(1)); 
   
           } 
        while (rs10.next()){ 
            list10.add(rs10.getString(1)); 
   
           } 
        while (rs11.next()){ 
            list11.add(rs11.getString(1)); 
   
           } 
        while (rs01.next()){
            list12.add(rs01.getString(1)); 
   
           }
        while (rs02.next()){  
            list13.add(rs02.getString(1)); 
   
           }
        while (rs03.next()){  
            list14.add(rs03.getString(1)); 
   
           }
        while (rs04.next()){ 
            list15.add(rs04.getString(1)); 
   
           }
        while (rs12.next()){ 
            list16.add(rs12.getString(1)); 

           }
        
        while (rs13.next()){ 
            list17.add(rs13.getString(1)); 

           }
        while (rs14.next()){
            list18.add(rs14.getString(1)); 

           }
        while (rs15.next()){ 
            list19.add(rs15.getString(1)); 

           }
        while (rs001.next()){ 
            list20.add(rs001.getString(1)); 

           }
        while (rs002.next()){ 
            list21.add(rs002.getString(1)); 

           }
        while (rs003.next()){ 
            list22.add(rs003.getString(1)); 

           }
        while (rs004.next()){ 
            list23.add(rs004.getString(1)); 

           }
        while (rs005.next()){ 
            list24.add(rs005.getString(1)); 

           }
        while (rs006.next()){ 
            list25.add(rs006.getString(1)); 

           }
        while (rs007.next()){ 
            list26.add(rs007.getString(1)); 

           }
        while (rs008.next()){ 
            list27.add(rs008.getString(1)); 

           }
        while (rs16.next()){ 
            list28.add(rs16.getString(1)); 

           }
        
         conn.close();
        //如果list中存入了数据，转化为数组  
         String[] idStrings=new String[list.size()];
         String[] kssj=new String[list.size()];
         String[] kcmc=new String[list.size()];
         String[] jsmc=new String[list.size()];
         String[] jkjs1=new String[list.size()];
         String[] jkjs2=new String[list.size()];
         String[] jkjs3=new String[list.size()];
         String[] jkjs4=new String[list.size()];
         String[] jszgh1=new String[list.size()];
         String[] jszgh2=new String[list.size()];
         String[] jszgh3=new String[list.size()];
         String[] jszgh4=new String[list.size()];
         String[] lxdh1=new String[list.size()];
         String[] lxdh2=new String[list.size()];
         String[] lxdh3=new String[list.size()];
         String[] lxdh4=new String[list.size()];
         String[] qx1=new String[list.size()];
         String[] qx2=new String[list.size()];
         String[] qx3=new String[list.size()];
         String[] qx4=new String[list.size()];
         String[] dxtxztz1=new String[list.size()];
         String[] dxtxztz2=new String[list.size()];
         String[] dxtxztz3=new String[list.size()];
         String[] dxtxztz4=new String[list.size()];
         String[] dxtxztt1=new String[list.size()];
         String[] dxtxztt2=new String[list.size()];
         String[] dxtxztt3=new String[list.size()];
         String[] dxtxztt4=new String[list.size()];
            
      
         //创建一个和list长度一样的数组  
         for(int i=0;i<list28.size();i++){  
          idStrings[i]=list28.get(i);
          kssj[i]=list.get(i);//数组赋值了。  
          kcmc[i]=list2.get(i);
          jsmc[i]=list3.get(i);
          jkjs1[i]=list4.get(i);
          jkjs2[i]=list5.get(i);
          jkjs3[i]=list6.get(i);
          jkjs4[i]=list7.get(i);
          jszgh1[i]=list8.get(i);
          jszgh2[i]=list9.get(i);
          jszgh3[i]=list10.get(i);
          jszgh4[i]=list11.get(i);
          lxdh1[i]=list12.get(i);
          lxdh2[i]=list13.get(i);          
          lxdh3[i]=list14.get(i);
          lxdh4[i]=list15.get(i);
          qx1[i]=list16.get(i);
          qx2[i]=list17.get(i);
          qx3[i]=list18.get(i);
          qx4[i]=list19.get(i);
          dxtxztz1[i]=list20.get(i);
          dxtxztz2[i]=list21.get(i);
          dxtxztz3[i]=list22.get(i);
          dxtxztz4[i]=list23.get(i);
          dxtxztt1[i]=list24.get(i);
          dxtxztt2[i]=list25.get(i);
          dxtxztt3[i]=list26.get(i);
          dxtxztt4[i]=list27.get(i);
         }  
	    

         
   
            String[][] arry = new String[25][kssj.length];
            
            for(int i=0;i<kssj.length;i++){
            	   arry[0][i] = kssj[i];//把数组信息的元素添加到arry中，传递发送给发送包timesend
            	   arry[1][i] = kcmc[i];
            	   arry[2][i] = jsmc[i];           
            	   arry[3][i] = jkjs1[i];
            	   arry[4][i] = jkjs2[i];
            	   arry[5][i] = jkjs3[i];
            	   arry[6][i] = jkjs4[i];
            	   arry[7][i] = lxdh1[i];
            	   arry[8][i] = lxdh2[i];
            	   arry[9][i] = lxdh3[i];
            	   arry[10][i] = lxdh4[i];
            	   arry[11][i]=qx1[i];
            	   arry[12][i]=qx2[i];
            	   arry[13][i]=qx3[i];
            	   arry[14][i]=qx4[i];
            	   arry[15][i]=dxtxztz1[i];
            	   arry[16][i]=dxtxztz2[i];
            	   arry[17][i]=dxtxztz3[i];
            	   arry[18][i]=dxtxztz4[i];
            	   arry[19][i]=dxtxztt1[i];
            	   arry[20][i]=dxtxztt2[i];
            	   arry[21][i]=dxtxztt3[i];
            	   arry[22][i]=dxtxztt4[i];
            
            }
           sqlmanager.closeConnection(); 
           return arry;
        }
            	
		
	

	
    
}
