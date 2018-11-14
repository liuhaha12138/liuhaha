package teacher.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.model.ExamInfo;
import teacher.model.TeacherInfo;

public class TeacherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5027878894819640292L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String zgh = request.getParameter("zgh");
		try {
				 //String[] args = null;
			    // TimeWorker.main(args);
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
                 UserInformationDAOImpl   userInfo=new UserInformationDAOImpl();
                 List<TeacherInfo> teacherInfoList=userInfo.getTeacherInfo(currentPage);
                 session.setAttribute("teacherInfoList", teacherInfoList);
                 session.setAttribute("currentPage", currentPage);
                 System.out.println("zheshiteacherservlet");
                 System.out.println(currentPage);
				 response.sendRedirect("limit.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
