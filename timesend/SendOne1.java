package timesend;
			
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
			
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;

import com.sun.org.apache.xpath.internal.operations.Equals;
			
import SQLManager.sqlmanager;
			
public class SendOne1 {
				
			public static void send1O1(String lxdh1[],String qx1[],String jkjs1[],
						  String kssj[],String kcmc[],
						  String jsmc[],int i) throws SQLException, Exception{
			
			HttpClient client1 = new HttpClient();
			
				/*调用短信发送模块*/            
				
			
			
			if(qx1[i]!=null&&qx1[i].contains("1")&&lxdh1[i]!=null&&lxdh1[i].length()==11){
			
			int j=i+1;
			
			/*短信发送模块*/
			
			PostMethod post = new PostMethod("http://114.215.206.2/msg/HttpBatchSendSM");
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
			post.getParams().setParameter(
			"http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
			NameValuePair[] data ={ 
				  new NameValuePair("account", "SDK0599"),
				  new NameValuePair("pswd", "SDKszrk0599"),		    			  
				  new NameValuePair("mobile",String.valueOf(lxdh1[i])),
				  new NameValuePair("needstatus", "true"),
				  new NameValuePair("msg",String.valueOf(jkjs1[i])+"老师您好，您明天有以下监考：\r\n"+"[时间]"+String.valueOf(kssj[i])+"\r\n"+"[地点]"+String.valueOf(jsmc[i])+"\r\n"+"[考试科目]"+String.valueOf(kcmc[i])+"\r\n"+"[您是主监考，请注意考试时间]"+"\r\n"+"<以上信息仅供参考，查询具体考试信息请登录学分制主页>")};
			post.setRequestBody(data);
			client1.executeMethod(post);
			String result = new String(post.getResponseBodyAsString());
			post.releaseConnection(); 
			System.out.println(result);
			System.out.println(result.length());
			
			System.out.println(j);
			String state = result.substring(result.indexOf(",")+1,result.indexOf(",")+2);
			
			if(state.equals("0")||state=="0"){
				
			Connection conn05=sqlmanager.openConnection();
			Statement stmt16 = conn05.createStatement();
			String sql001="UPDATE examall SET dxtxztt1='已发送' where id="+j;
			System.out.println(sql001);
			conn05.setAutoCommit(false);
			stmt16.execute(sql001);	 
			conn05.commit();
			conn05.close();
			}
			}	
			}
			
			public static void send1O2(String lxdh2[],String qx2[],String jkjs2[],
					  String kssj[],String kcmc[],
					  String jsmc[],int i) throws SQLException, Exception{
			
			HttpClient client2 = new HttpClient();
			Connection conn06=sqlmanager.openConnection();
			Statement stmt17 = conn06.createStatement();
			/*调用短信发送模块*/            
			
			if(qx2[i]!=null&&qx2[i].contains("1")&&lxdh2[i]!=null&&lxdh2[i].length()==11){
			
			int j=i+1;
			
			/*短信发送模块*/
			
			PostMethod post = new PostMethod("http://114.215.206.2/msg/HttpBatchSendSM");
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
			post.getParams().setParameter(
				"http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
			NameValuePair[] data ={
					
								new NameValuePair("account", "SDK0599"),
								new NameValuePair("pswd", "SDKszrk0599"),		    			  
								new NameValuePair("mobile",String.valueOf(lxdh2[i])),
								new NameValuePair("needstatus", "true"),
								new NameValuePair("msg",String.valueOf(jkjs2[i])+"老师您好，您明天有以下监考：\r\n"+"[时间]"+String.valueOf(kssj[i])+"\r\n"+"[地点]"+String.valueOf(jsmc[i])+"\r\n"+"[考试科目]"+String.valueOf(kcmc[i])+"\r\n"+"<您是副监考，请注意考试时间>")};
									post.setRequestBody(data);
									client2.executeMethod(post);
									String result = new String(post.getResponseBodyAsString());
									post.releaseConnection(); 
									System.out.println(result);
									System.out.println(result.length());
			
									System.out.println(j);
									String state = result.substring(result.indexOf(",")+1,result.indexOf(",")+2);
									
									if(state.equals("0")||state=="0"){
			
										String sql001="UPDATE examall SET dxtxztt2='已发送' where id="+j;
										System.out.println(sql001);
										conn06.setAutoCommit(false);
										stmt17.execute(sql001);	 
										conn06.commit();
										conn06.close();
									}
								}
								}
			
			public static void send1O3(String lxdh3[],String qx3[],String jkjs3[],
						String kssj[],String kcmc[],
						String jsmc[],int i) throws SQLException, Exception{
			
						HttpClient client3 = new HttpClient();
						Connection conn07=sqlmanager.openConnection();
						Statement stmt17 = conn07.createStatement();
						
						/*调用短信发送模块*/            
			
			if(qx3[i]!=null&&qx3[i].contains("1")&&lxdh3[i]!=null&&lxdh3[i].length()==11){
			
						int j=i+1;
			
						/*短信发送模块*/
			
						PostMethod post = new PostMethod("http://114.215.206.2/msg/HttpBatchSendSM");
						post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
						post.getParams().setParameter("http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
						NameValuePair[] data ={ 
												new NameValuePair("account", "SDK0599"),
												new NameValuePair("pswd", "SDKszrk0599"),		    			  
												new NameValuePair("mobile",String.valueOf(lxdh3[i])),
												new NameValuePair("needstatus", "true"),
												new NameValuePair("msg",String.valueOf(jkjs3[i])+"老师您好，您明天有以下监考：\r\n"+"[时间]"+String.valueOf(kssj[i])+"\r\n"+"[地点]"+String.valueOf(jsmc[i])+"\r\n"+"[考试科目]"+String.valueOf(kcmc[i])+"\r\n"+"<您是副监考，请注意考试时间>")};
				post.setRequestBody(data);
				client3.executeMethod(post);
				String result = new String(post.getResponseBodyAsString());
				post.releaseConnection(); 
				System.out.println(result);
				System.out.println(result.length());
				System.out.println(j);
				String state = result.substring(result.indexOf(",")+1,result.indexOf(",")+2);
				
				if(state.equals("0")||state=="0"){
			
					String sql001="UPDATE examall SET dxtxztt3='已发送' where id="+j;
					System.out.println(sql001);
					conn07.setAutoCommit(false);
					stmt17.execute(sql001);	 
					conn07.commit();
					conn07.close();
				}
			}
			
			}
			
			public static void send1O4(String lxdh4[],String qx4[],String jkjs4[],
			String kssj[],String kcmc[],
			String jsmc[],int i) throws SQLException, Exception{
			
			HttpClient client4 = new HttpClient();
			Connection conn08=sqlmanager.openConnection();
			Statement stmt18 = conn08.createStatement();
			
			/*调用短信发送模块*/            
			
			if(qx4[i]!=null&&qx4[i].contains("1")&&lxdh4[i]!=null&&lxdh4[i].length()==11){
			
			int j=i+1;
			
			/*短信发送模块*/
			
			PostMethod post = new PostMethod("http://114.215.206.2/msg/HttpBatchSendSM");
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
			post.getParams().setParameter("http.protocol.cookie-policy",CookiePolicy.BROWSER_COMPATIBILITY);
			NameValuePair[] data ={ 
							new NameValuePair("account", "SDK0599"),
							new NameValuePair("pswd", "SDKszrk0599"),		    			  
							new NameValuePair("mobile",String.valueOf(lxdh4[i])),
							new NameValuePair("needstatus", "true"),
							new NameValuePair("msg",String.valueOf(jkjs4[i])+"老师您好，您明天有以下监考：\r\n"+"[时间]"+String.valueOf(kssj[i])+"\r\n"+"[地点]"+String.valueOf(jsmc[i])+"\r\n"+"[考试科目]"+String.valueOf(kcmc[i])+"\r\n"+"<您是副监考，请注意考试时间>")};
			post.setRequestBody(data);
			client4.executeMethod(post);
			String result = new String(post.getResponseBodyAsString());
			post.releaseConnection(); 
			System.out.println(result);
			System.out.println(result.length());
			System.out.println(j);
			String state = result.substring(result.indexOf(",")+1,result.indexOf(",")+2);
			
			if(state.equals("0")||state=="0"){
			
			String sql001="UPDATE examall SET dxtxztt4='已发送' where id="+j;
			System.out.println(sql001);
			conn08.setAutoCommit(false);
			stmt18.execute(sql001);	 
			conn08.commit();
			conn08.close();
			}
			}			
			}			
			  }
