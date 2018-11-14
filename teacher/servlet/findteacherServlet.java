package teacher.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import teacher.dao.impl.UserInformationDAOImpl;
import teacher.model.ExamInfo;
import teacher.model.TeacherInfo;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;

public class findteacherServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String zgh = request.getParameter("zgh");
		try {
                 HttpSession session=request.getSession();

                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("zgh", zgh);
                 TeacherInfo teacher=userInfo.editinfo(zgh);
                 System.out.println(zgh);
                 session.setAttribute("teacher", teacher);
                 System.out.println(teacher);
				 //response.sendRedirect("edit.jsp");
                 
		} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
