package teacher.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.model.TeacherInfo;
import teacher.model.usertable;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;

public class showuserServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		try {
                 HttpSession session=request.getSession();
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 List<usertable> userInfoList=userInfo.showUser();
                 session.setAttribute("userInfoList", userInfoList);
                 response.sendRedirect("limit.jsp");
//                request.getRequestDispatcher("limit.jsp");
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
