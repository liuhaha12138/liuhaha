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

public class editServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String qx = request.getParameter("qx");
		String zgh = request.getParameter("zgh");
		System.out.print(qx+"sd");
		System.out.print(zgh);
		try {
                 HttpSession session=request.getSession();
                 String page = request.getParameter("currentPage");
                 int currentPage;
                 if(null == page )
                 {
                	 currentPage = 1;
                 }
                 else {
                	 currentPage = Integer.parseInt(page);
                 }

                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("qx", qx);
                 session.setAttribute("zgh", zgh);
                 TeacherInfo teacherInfo=userInfo.editinfo(zgh);
                 session.setAttribute("currentPage", currentPage);
                 session.setAttribute("teacherInfo", teacherInfo);
                 request.getRequestDispatcher("/WebRoot/edit.jsp");
				 //response.sendRedirect("edit.jsp");
                 
		} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
