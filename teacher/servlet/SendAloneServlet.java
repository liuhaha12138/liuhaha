package teacher.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;



import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendAloneServlet extends HttpServlet{

  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
	
		
			try {
				request.setCharacterEncoding("UTF-8");
				String kssj = request.getParameter("kssj");
		        String jsmc = request.getParameter("jsmc");
		        String jkjs = request.getParameter("jkjs");
		        String kcmc = request.getParameter("kcmc");
		        String lxdh = request.getParameter("lxdh");
		        
		        System.out.println(lxdh);

		
	         
		 HttpClient client = new HttpClient();
		 PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
		 post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
		
		 NameValuePair[] data ={ new NameValuePair("Uid", "nounou111"),new NameValuePair("Key", "30ab83afbdcebd5ee00a"),new NameValuePair("smsMob",String.valueOf(lxdh)),new NameValuePair("smsText",String.valueOf(jkjs)+"老师您好，您有以下监考：\r\n"+"【时间】"+String.valueOf(kssj)+"\r\n"+"【地点】"+String.valueOf(jsmc)+"\r\n"+"【考试科目】"+String.valueOf(kcmc)+"\r\n"+"<请注意考试时间>")};
		
		 post.setRequestBody(data);

		 try {
			client.executeMethod(post);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         
		 post.releaseConnection();
		 response.sendRedirect("main.jsp");
		
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	//request.getRequestDispatcher("main.jsp");
	//response.sendRedirect("edit.jsp");
 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}}
