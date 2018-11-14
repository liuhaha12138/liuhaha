package teacher.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;

public class adduserServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
                 HttpSession session=request.getSession();
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("username", username);
                 session.setAttribute("password", password); 
                 userInfo.adduser(username,password);
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
