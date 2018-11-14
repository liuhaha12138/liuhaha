package timesend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twodays.nowtime;
import twodays.twodays;

import SQLManager.sqlmanager;

public class selectcopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
			public static void selectcopy() throws Exception{
				
			String[][] arry=Select.selectmysql();
			 
		    Connection conn=sqlmanager.openConnection(); 
		    String sql = "select kssj from examall";
		    Statement stmt  = conn.createStatement(); 
	        ResultSet rs = stmt.executeQuery(sql);
	        List<String> list=new ArrayList<String>();
	        while (rs.next()){
	        	//索取信息分配地址单位，用来做循环使用 
	         list.add(rs.getString(1)); 
	        }  
	        
	         String[] kssj=new String[list.size()];String[] kcmc=new String[list.size()];String[]jsmc= new String[list.size()];
			 String[]jkjs1=new String[list.size()];String[]jkjs2=new String[list.size()];String[]jkjs3=new String[list.size()];
			 String[]jkjs4=new String[list.size()];String[]lxdh1=new String[list.size()];String[]lxdh2=new String[list.size()]; 
			 String[]lxdh3=new String[list.size()];String[]lxdh4=new String[list.size()];String[]qx1=new String[list.size()];  
			 String[]qx2=new String[list.size()];  String[]qx3=new String[list.size()];  String[]qx4=new String[list.size()];
			 String[] dxtxztz1=new String[list.size()];String[] dxtxztz3=new String[list.size()];
	         String[] dxtxztz2=new String[list.size()];String[] dxtxztz4=new String[list.size()];
	         String[] dxtxztt1=new String[list.size()];String[] dxtxztt3=new String[list.size()];
	         String[] dxtxztt4=new String[list.size()]; String[] dxtxztt2=new String[list.size()];
	        
	         
		     //定义数组地址
	       
		
	     for(int i=0;i<list.size();i++){
			
	 	   kssj[i]=arry[0][i];  kcmc[i]=arry[1][i];	 jsmc[i]= arry[2][i];           
	 	   jkjs1[i]= arry[3][i];jkjs2[i]= arry[4][i];jkjs3[i]= arry[5][i];
	 	   jkjs4[i]= arry[6][i];lxdh1[i]= arry[7][i];lxdh2[i]= arry[8][i];
	 	   lxdh3[i]= arry[9][i];lxdh4[i]= arry[10][i];qx1[i]=arry[11][i];
	 	   qx2[i]=arry[12][i];	qx3[i]=arry[13][i];	  qx4[i]=arry[14][i];
		   dxtxztz1[i]=arry[15][i];
		   dxtxztz2[i]=arry[16][i];
	   	   dxtxztz3[i]=arry[17][i];
	   	   dxtxztz4[i]=arry[18][i];
	   	   dxtxztt1[i]=arry[19][i];
	   	   dxtxztt2[i]=arry[20][i];
	   	   dxtxztt3[i]=arry[21][i];
	   	   dxtxztt4[i]=arry[22][i];
	 	   }//从arry收取数组信息
				
	     for(int i=0;i<list.size();i++){
	    	 
	    	  String str1=String.valueOf(kssj[i]);
         	  char st=str1.charAt(0);
              System.out.print(st);
     if(st=='2')//第一种时间格式
             
           {
             	DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");  
             	Date date2= format.parse(str1); 
             	System.out.println(date2); 
             	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			    
                 Date date1=nowtime.nowstring(df.format(new Date()));
                 //System.out.println("两个日期的差距：" + twodays.differentDaysByMillisecond(date2,date));
               
                 int days= twodays.differentDaysByMillisecond(date1, date2)+1;
                 System.out.println("两个日期的差距：" +days);
		        
		       
		     if(days==7){
		    	 int j=i+1;
		    	       
		    	String strSQL = "INSERT into examall (xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4) values("
		        + "'" + kcmc[i] + "'"+","
		        + "'" + kssj[i] + "'"+","
		        + "'" + jsmc[i] + "'"+","
		        + "'" + jkjs1[i] + "'"+","
		        + "'" + jkjs2[i] + "'"+","
		        + "'" + jkjs3[i] + "'"+","
		        + "'" + jkjs4[i] + "'"+ ","
		        + "'" + dxtxztt1[i] + "'"+","
		        + "'" + dxtxztt2[i] + "'"+","
		        + "'" + dxtxztt3[i] + "'"+","
		        + "'" + dxtxztt4[i] + "'"+ "," 
		        + "'" + dxtxztz1[i] + "'"+","
		        + "'" + dxtxztz2[i] + "'"+","
		        + "'" + dxtxztz3[i] + "'"+","
		        + "'" + dxtxztz4[i] + "'"+ ","	 
		        						+")"; 
		    	  
		        	  
		             
	                  
		        	  strSQL = "select id from examall where id =" + "'"  
		             +j+"';";  
		             System.out.println("最近考试课程====="+kcmc[i]);  
		    
		     ResultSet rs1 = stmt.executeQuery(strSQL); // 查询数据库看数据是否已经存在  
		     if (rs1.next()) { // 该条数据已经存在  
		         // PublicName.getValue(0,0);  
		    	 
		         System.out.println("（已存在考试信息）");  
		        
		     } else {  

		         stmt.executeUpdate(strSQL); 
		   
		     }  
		     rs1.close();  
								
		     }
		       else if(days==1 && date2.getTime()-date1.getTime()>0){
	 		        	
		    	   int j=i+1;
	    	       
			    	String strSQL = "INSERT into examall (xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4) values("
			        + "'" + kcmc[i] + "'"+","
			        + "'" + kssj[i] + "'"+","
			        + "'" + jsmc[i] + "'"+","
			        + "'" + jkjs1[i] + "'"+","
			        + "'" + jkjs2[i] + "'"+","
			        + "'" + jkjs3[i] + "'"+","
			        + "'" + jkjs4[i] + "'"+ ","
			        + "'" + dxtxztt1[i] + "'"+","
			        + "'" + dxtxztt2[i] + "'"+","
			        + "'" + dxtxztt3[i] + "'"+","
			        + "'" + dxtxztt4[i] + "'"+ "," 
			        + "'" + dxtxztz1[i] + "'"+","
			        + "'" + dxtxztz2[i] + "'"+","
			        + "'" + dxtxztz3[i] + "'"+","
			        + "'" + dxtxztz4[i] + "'"+ ","	 
			        						+")"; 
			    	  
			        	  
			             
		                  
			        	  strSQL = "select kssj from examall where id =" + "'"  
			             +j+"';";  
			             System.out.println("最近考试课程====="+kcmc[i]);  
			    
			     ResultSet rs1 = stmt.executeQuery(strSQL); // 查询数据库看数据是否已经存在  
			     if (rs1.next()) { // 该条数据已经存在  
			         // PublicName.getValue(0,0);  
			    	 
			         System.out.println("（已存在考试信息）");  
			        
			     } else {  

			         stmt.executeUpdate(strSQL); 
			   
			     }  
			     rs1.close();    
		       }
		     }
           
	            else if(st=='第'){
	            	//第二种时间格式
	            	
	 					DateFormat format = new SimpleDateFormat("第DD周周D(yyyy-MM-dd)");
	 					Date date2 = format.parse(str1); 
	 					System.out.println(date2);
	 					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	 					Date date1=nowtime.nowstring(df.format(new Date()));
	 					//System.out.println("两个日期的差距：" + twodays.differentDaysByMillisecond(date2,date));
	   
	 					 int days=twodays.differentDaysByMillisecond(date1,date2)+1;
	 					System.out.println("两个日期的差距：" +days);
	 					if(days==7){
		        					
	 						int j=i+1;
	 		    	       
	 				    	String strSQL = "INSERT into examall (xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4) values("
	 				        + "'" + kcmc[i] + "'"+","
	 				        + "'" + kssj[i] + "'"+","
	 				        + "'" + jsmc[i] + "'"+","
	 				        + "'" + jkjs1[i] + "'"+","
	 				        + "'" + jkjs2[i] + "'"+","
	 				        + "'" + jkjs3[i] + "'"+","
	 				        + "'" + jkjs4[i] + "'"+ ","
	 				        + "'" + dxtxztt1[i] + "'"+","
	 				        + "'" + dxtxztt2[i] + "'"+","
	 				        + "'" + dxtxztt3[i] + "'"+","
	 				        + "'" + dxtxztt4[i] + "'"+ "," 
	 				        + "'" + dxtxztz1[i] + "'"+","
	 				        + "'" + dxtxztz2[i] + "'"+","
	 				        + "'" + dxtxztz3[i] + "'"+","
	 				        + "'" + dxtxztz4[i] + "'"+ ","	 
	 				        						+")"; 
	 				    	  
	 				        	  
	 				             
	 			                  
	 				        	  strSQL = "select id from examall where id =" + "'"  
	 				             +j+"';";  
	 				             System.out.println("最近考试课程====="+kcmc[i]);  
	 				    
	 				     ResultSet rs1 = stmt.executeQuery(strSQL); // 查询数据库看数据是否已经存在  
	 				     if (rs1.next()) { // 该条数据已经存在  
	 				         // PublicName.getValue(0,0);  
	 				    	 
	 				         System.out.println("（已存在考试信息）");  
	 				        
	 				     } else {  

	 				         stmt.executeUpdate(strSQL); 
	 				   
	 				     }  
	 				     rs1.close();   
	 		 		            }
	 		 		        	
	 		 		        else if(days==1 && date2.getTime()-date1.getTime()>0){
	 		 		        	//days==1 && date2.getTime()-date1.getTime()>0该附加条件是处理int转换类型中负数小数变成0的情况
	 		                       
	 		 		        	int j=i+1;
	 			    	       
	 		 			    	String strSQL = "INSERT into examall (xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4) values("
	 		 			        + "'" + kcmc[i] + "'"+","
	 		 			        + "'" + kssj[i] + "'"+","
	 		 			        + "'" + jsmc[i] + "'"+","
	 		 			        + "'" + jkjs1[i] + "'"+","
	 		 			        + "'" + jkjs2[i] + "'"+","
	 		 			        + "'" + jkjs3[i] + "'"+","
	 		 			        + "'" + jkjs4[i] + "'"+ ","
	 		 			        + "'" + dxtxztt1[i] + "'"+","
	 		 			        + "'" + dxtxztt2[i] + "'"+","
	 		 			        + "'" + dxtxztt3[i] + "'"+","
	 		 			        + "'" + dxtxztt4[i] + "'"+ "," 
	 		 			        + "'" + dxtxztz1[i] + "'"+","
	 		 			        + "'" + dxtxztz2[i] + "'"+","
	 		 			        + "'" + dxtxztz3[i] + "'"+","
	 		 			        + "'" + dxtxztz4[i] + "'"+ ","	 
	 		 			        						+")"; 
	 		 			    	  
	 		 			        	  
	 		 			             
	 		 		                  
	 		 			        	  strSQL = "select id from examall where id =" + "'"  
	 		 			             +j+"';";  
	 		 			             System.out.println("最近考试课程====="+kcmc[i]);  
	 		 			    
	 		 			     ResultSet rs1 = stmt.executeQuery(strSQL); // 查询数据库看数据是否已经存在  
	 		 			     if (rs1.next()) { // 该条数据已经存在  
	 		 			         // PublicName.getValue(0,0);  
	 		 			    	 
	 		 			         System.out.println("（已存在考试信息）");  
	 		 			        
	 		 			     } else {  

	 		 			         stmt.executeUpdate(strSQL); 
	 		 			   
	 		 			     }  
	 		 			     rs1.close();  
         			        }
	            	}
	    	 
	    	 
	    	 
	     }
	     
	     
	     
	     
	     
			}
}
