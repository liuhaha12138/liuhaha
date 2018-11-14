package teacher.servlet;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.model.usertable;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;



public class loginServlet  extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		usertable user = new usertable();
		user.setUsername(username);
		user.setPassword(password);
		try {
			if (userSV.isUser(user)) {
                 HttpSession session=request.getSession();
                 session.setAttribute("user", user);
				 response.sendRedirect("main.jsp");
			}
			else
				response.sendRedirect("index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
