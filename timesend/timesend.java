package timesend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.ObjectUtils.Null;

import twodays.nowtime;
import twodays.twodays;
import SQLManager.sqlmanager;
import timesend.SendOne7;
import timesend.SendOne1;


public class timesend {
	

	public static void mysqladd() throws Exception{
		

//初始化超时控制
			        
					
		    String[][] arry=Select.selectmysql();
		    Connection conn=sqlmanager.openConnection(); 
		    String sql = "select kssj from examall";
		    String sq2 = "select dayj from url";//从数据表url提取动态天数（较近天数）设置
		    String sq3 = "select dayy from url";
		    Statement stmt  =  conn.createStatement();
		    Statement stmt1  = conn.createStatement(); 
		    Statement stmt2  = conn.createStatement(); 
	        ResultSet rs = stmt.executeQuery(sql);
	        ResultSet rs2 = stmt1.executeQuery(sq2);
	        ResultSet rs3 = stmt2.executeQuery(sq3);
	        List<String> list=new ArrayList<String>();
	        List<String> list2=new ArrayList<String>();
	        List<String> list3=new ArrayList<String>();
	        while (rs.next()){
	        	//索取信息分配地址单位，用来做循环使用 
	         list.add(rs.getString(1)); 
	        }  
	        while (rs2.next()){
	        	//索取信息分配地址单位，用来做循环使用 
	         list2.add(rs2.getString(1)); 
	        }  
	        while (rs3.next()){
	        	//索取信息分配地址单位，用来做循环使用 
	         list3.add(rs3.getString(1)); 
	        }  
	        
	        String dayjString=list2.get(0);
	        String dayyString=list3.get(0);
	         int dayj=Integer.valueOf(dayjString).intValue();
	         int dayy=Integer.valueOf(dayyString).intValue();
	         
	        
	         String[] kssj=new String[list.size()];String[] kcmc=new String[list.size()];String[]jsmc= new String[list.size()];
			 String[] jkjs1=new String[list.size()];String[]jkjs2=new String[list.size()];String[]jkjs3=new String[list.size()];
			 String[] jkjs4=new String[list.size()];String[]lxdh1=new String[list.size()];String[]lxdh2=new String[list.size()]; 
			 String[] lxdh3=new String[list.size()];String[]lxdh4=new String[list.size()];String[]qx1=new String[list.size()];  
			 String[] qx2=new String[list.size()];  String[]qx3=new String[list.size()];  String[]qx4=new String[list.size()];
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
            	//在数组中进行轮询检索
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
 		        
 		       
 		     if(days==dayy){
 		    	       
		              //执行循环体内的任务片段和算法
 		    	       
								
									if(qx1[i]!=null&&qx1[i].equals("1")&&lxdh1[i]!=null&&lxdh1[i].length()==11&&dxtxztz1[i]==null){
										 System.out.println("1");
										 SendOne7.send7O1(lxdh1, qx1, jkjs1, kssj, kcmc, jsmc, i);
								    }
  					            
 								
 									if((qx2[i]!=null)&&(qx2[i].contains("1"))&&(lxdh2[i]!=null&&lxdh2[i].length()==11)&&dxtxztz2[i]==null){
	
 										SendOne7.send7O2(lxdh2, qx2, jkjs2, kssj, kcmc, jsmc, i);	    	
 									}
 													  
 								
 									
 									if((qx3[i]!=null)&&(qx3[i].contains("1"))&&(lxdh3[i]!=null&&lxdh3[i].length()==11)&&dxtxztz3[i]==null){
 								 
  						
 										SendOne7.send7O3(lxdh3, qx3, jkjs3, kssj, kcmc, jsmc, i);
 										
 									}			
 									if((qx4[i]!=null)&&(qx4[i].contains("1"))&&(lxdh4[i]!=null&&lxdh4[i].length()==11)&&dxtxztz4[i]==null){
  						
 										SendOne7.send7O4(lxdh4, qx4, jkjs4, kssj, kcmc, jsmc, i);
 									}
 		     }
 		       else if(days==dayj&&date2.getTime()-date1.getTime()>0){
 	 		        	
 		    	        //days==1 && date2.getTime()-date1.getTime()>0该附加条件是处理int转换类型中负数小数变成0的情况
 	                    
 	 		        			if(qx1[i]!=null&&qx1[i].contains("1")&&lxdh1[i]!=null&&lxdh1[i].length()==11&&dxtxztt1[i]==null){
 	 							
 	 		        					SendOne1.send1O1(lxdh1, qx1, jkjs1, kssj, kcmc, jsmc, i); 		        		  
 	 					} 
 	                     		if(qx2[i]!=null&&qx2[i].contains("1")&&lxdh2[i]!=null&&lxdh2[i].length()==11&&dxtxztt2[i]==null){
 	  						
 	                     				SendOne1.send1O2(lxdh2, qx2, jkjs2, kssj, kcmc, jsmc, i);
 	  					}
 	                     		if(qx3[i]!=null&&qx3[i].contains("1")&&lxdh3[i]!=null&&lxdh3[i].length()==11&&dxtxztt3[i]==null){
 	   						
 	                     				SendOne1.send1O3(lxdh3, qx3, jkjs3, kssj, kcmc, jsmc, i);
 	   					}
 	                    		if(qx4[i]!=null&&qx4[i].contains("1")&&lxdh4[i]!=null&&lxdh4[i].length()==11&&dxtxztt4[i]==null){
 	   						
 	                    				SendOne1.send1O4(lxdh4, qx4, jkjs4, kssj, kcmc, jsmc, i);   	
 	 		            }
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
 	 					if(days==dayy){
 		        					
 	 							if(qx1[i]!=null&&qx1[i].contains("1")&&lxdh1[i]!=null&&lxdh1[i].length()==11&&dxtxztz1==null){
 	 		 		        		
 	 		  						    SendOne7.send7O1(lxdh1, qx1, jkjs1, kssj, kcmc, jsmc, i);
 	 		  					}   	 		                      	 		                      
 	 		 					if(qx2[i]!=null&&qx2[i].contains("1")&&lxdh2[i]!=null&&lxdh2[i].length()==11&&dxtxztz2[i]==null){
 	 		  							    	
 	 		 					    	SendOne7.send7O2(lxdh2, qx2, jkjs2, kssj, kcmc, jsmc, i); 	 		  					} 
 	 		 					  	 		 					  
 	 		 					if(qx3[i]!=null&&qx3[i].contains("1")&&lxdh3[i]!=null&&lxdh3[i].length()==11&&dxtxztz3[i]==null){
 	 		  						
 	 		 							SendOne7.send7O3(lxdh3, qx3, jkjs3, kssj, kcmc, jsmc, i);
 	 		  					} 	 		 					 		 					 
 	 		 					if(qx4[i]!=null&&qx4[i].contains("1")&&lxdh4[i]!=null&&lxdh4[i].length()==11&&dxtxztz4[i]==null){
 	 		  						
 	 		 							SendOne7.send7O4(lxdh4, qx4, jkjs4, kssj, kcmc, jsmc, i);	    
 	 		  					} 			 
 	 		 		            }
 	 		 		        	
 	 		 		        else if(days==dayj&& date2.getTime()-date1.getTime()>0){
 	 		 		        	//days==1 && date2.getTime()-date1.getTime()>0该附加条件是处理int转换类型中负数小数变成0的情况
 	 		                    
 	 		 		        	if(qx1[i]!=null&&qx1[i].contains("1")&&lxdh1[i]!=null&&lxdh1[i].length()==11&&dxtxztt1[i]==null){
 	 		 						
 	 		 		        		    SendOne1.send1O1(lxdh1, qx1, jkjs1, kssj, kcmc, jsmc, i); 	    
 	 		 					}	 		                     
 	 		                    if(qx2[i]!=null&&qx2[i].contains("1")&&lxdh2[i]!=null&&lxdh2[i].length()==11&&dxtxztt2[i]==null){
 	 		  						
 	 		                    	    SendOne1.send1O2(lxdh2, qx2, jkjs2, kssj, kcmc, jsmc, i);
 	 		  					}
 	 		                    if(qx3[i]!=null&&qx3[i].contains("1")&&lxdh3[i]!=null&&lxdh3[i].length()==11&&dxtxztt3[i]==null){
 	 		   						
 	 		                    	    SendOne1.send1O3(lxdh3, qx3, jkjs3, kssj, kcmc, jsmc, i);
 	 		   					}
 	 		                    if(qx4[i]!=null&&qx4[i].contains("1")&&lxdh4[i]!=null&&lxdh4[i].length()==11&&dxtxztt4[i]==null){
 	 		   				 		
 	 		                	   	    SendOne1.send1O4(lxdh4, qx4, jkjs4, kssj, kcmc, jsmc, i);
 	 		   					}            
            			        }
 	            	}
					}
		sqlmanager.closeConnection();
				}
		
	}
            
            
			
	



	

