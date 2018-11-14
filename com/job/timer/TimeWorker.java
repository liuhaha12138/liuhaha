package com.job.timer; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer; 
import java.util.TimerTask; 
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import downloaddata.DownLoadData_teacher;
import downloaddata.downloaddata;
import SQLManager.sqlmanager;
import SQLManager.sqlmanager_teacher;
import timesend.timesend;






public  class TimeWorker  implements ServletContextListener{ 
/**
* @param args 
*/ 

//返回值设置 


static String noURL = "URL Not found"; //无传入URL 


static String ok = "The Servers are healthy"; // 服务器正常 


static String error = "Can not connect to servers"; //无法连接服务器（无法访问资源）


public static void main(String[] args) throws Exception { 	
			// TODO Auto-generated method stub 
	  		//Pretreatment.Prepare();
			timersend();
} 


/** 


* 重写run方法，使其调用自写的getPing方法 

..
 * @throws Exception 
*/ 


public static void timersend() throws Exception {
	Connection conn=sqlmanager.openConnection();
	Statement stmt1 = conn.createStatement();
	Statement stmt2 = conn.createStatement();
	Statement stmt3 = conn.createStatement();
	String sql1="select sendtimes from url";
	String sql2="select sendtimef from url";
	String sql3="select sendtimem from url";
	
	

	ResultSet rs1 = stmt1.executeQuery(sql1);
	ResultSet rs2 = stmt2.executeQuery(sql2);
	ResultSet rs3 = stmt3.executeQuery(sql3);
	

	List<String> list1=new ArrayList<String>();
	List<String> list2=new ArrayList<String>();
	List<String> list3=new ArrayList<String>();
	
	while (rs1.next()){//如果有数据，取第一列添加如list  
        list1.add(rs1.getString(1)); 
       }  
	while (rs2.next()){//如果有数据，取第一列添加如list  
        list2.add(rs2.getString(1)); 
       }  
	while (rs3.next()){//如果有数据，取第一列添加如list  
        list3.add(rs3.getString(1)); 
       }  
	conn.close();
	
	String sendtimes=list1.get(0);
	String sendtimef=list2.get(0);
	String sendtimem=list3.get(0);
	
	int hour=Integer.valueOf(sendtimes).intValue();
	int min=Integer.valueOf(sendtimef).intValue();
	int second=Integer.valueOf(sendtimem).intValue();
	
    Calendar calendar = Calendar.getInstance();
    System.out.println("开始");
    calendar.set(Calendar.HOUR_OF_DAY,hour); // 控制时
    calendar.set(Calendar.MINUTE,min);    // 控制分
    calendar.set(Calendar.SECOND,second);    // 控制秒
    
    Date time = (Date) calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask(){
      public void run() {
    		
    		try {  	
    			back();
    			
    	    	System.out.println("执行结束");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("线程阻塞");
			}
      }
    }, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行
  }

public static void back() throws InterruptedException, ExecutionException, java.util.concurrent.TimeoutException, Exception { 
	
	final ExecutorService exec = Executors.newFixedThreadPool(3);  
	Callable<String> call = new Callable<String>() {  
    public String call() throws Exception {  
        //开始执行耗时操作  
    	downloaddata.loaddata();
		sqlmanager.storage();
        return "监考线程执行结束."; } 
     }; 
     Callable<String> call2 = new Callable<String>() {  
    	    public String call() throws Exception {  
    	        //开始执行耗时操作  
    	    	DownLoadData_teacher.DownLoad_teacher();
    	    	sqlmanager_teacher.storage();
    	        return "teacher线程执行结束."; } 
    	     }; 
     Callable<String> call3 = new Callable<String>() {  
    	    	    public String call() throws Exception {  
    	    	        //开始执行耗时操作  	    	   	 
    	    		    timesend.mysqladd();    	        
    	    	        return "发送线程执行结束."; } 
    	    	     }; 
        
     try {  
         Future<String> future = exec.submit(call);
         String obj = future.get(1000*50*1, TimeUnit.MILLISECONDS); //任务处理超时时间设为 1 秒  
         System.out.println("任务成功返回:" + obj);
         } catch (Exception e) {   	 
    	 System.out.print(e);
         System.out.println("监考线程处理中途失败.重新执行"); 
         Future<String> future = exec.submit(call);  
         String obj = future.get(1000*60*1, TimeUnit.MILLISECONDS); //任务处理超时时间设为 1 秒  
         System.out.println("任务成功返回:" + obj); 
         }
         
     try {   
         Future<String> future2=exec.submit(call2);
         String obj2= future2.get(1000*50*1, TimeUnit.MILLISECONDS);
         System.out.println("任务成功返回:" + obj2);
         } catch (Exception e) {
        	 
        	 System.out.print(e);
             System.out.println("teacher线程处理中途失败.重新执行"); 
             Future<String> future2=exec.submit(call2);
             String obj2= future2.get(1000*50*1, TimeUnit.MILLISECONDS);
             System.out.println("任务成功返回:" + obj2); 
         }
     try{
         Future<String> future3=exec.submit(call3);      
         String obj3= future3.get(1000*50*1, TimeUnit.MILLISECONDS);        
         System.out.println("任务成功返回:" + obj3);
       	 } catch (Exception e) {
    	 
    	 System.out.print(e);
         System.out.println("发送线程处理中途失败.重新执行"); 
         Future<String> future3=exec.submit(call3);      
         String obj3= future3.get(1000*50*1, TimeUnit.MILLISECONDS);        
         System.out.println("任务成功返回:" + obj3);
     }
     // 关闭线程池  
     exec.shutdown();
	
}





} 