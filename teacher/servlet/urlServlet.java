package teacher.servlet;



import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;
import teacher.model.url;;

public class urlServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String ip = request.getParameter("ip");
		String usertype = request.getParameter("usertype");
		String path = request.getParameter("path");
		String usern = request.getParameter("usern");
		String pwd = request.getParameter("pwd");
		String xn = request.getParameter("xn");
		String xq = request.getParameter("xq");
		String XUEQ = request.getParameter("XUEQ");
		String NAME = request.getParameter("NAME");
		String PASS = request.getParameter("PASS");
		String XUEN = request.getParameter("XUEN");
		String cs = request.getParameter("cs");
		String cssx = request.getParameter("cssx");
		System.out.println(cs);
		try {
                 HttpSession session=request.getSession();
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("ip", ip);
                 session.setAttribute("usertype", usertype);
                 session.setAttribute("path", path);
                 session.setAttribute("usern", usern);
                 session.setAttribute("pwd", pwd);
                 session.setAttribute("xn", xn);
                 session.setAttribute("xq", xq);
                 session.setAttribute("NAME", NAME);
                 session.setAttribute("PASS", PASS);
                 session.setAttribute("XUEN", XUEN);
                 session.setAttribute("XUEQ", XUEQ);
                 session.setAttribute("cs", cs);
                 session.setAttribute("cssx", cssx);
                 //URL url = new URL();
                 userInfo.updateurl(ip,usern,pwd,xn,xq,NAME,PASS,XUEN,XUEQ,usertype,path,cs,cssx);
                 response.sendRedirect("main.jsp");
                 // userInfo.updateurl(usern,pwd,xn,xq);
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


