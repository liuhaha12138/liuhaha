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

public class phoneServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		//String xn = request.getParameter("xn");
		//String xq = request.getParameter("xq");
		String jsbh = request.getParameter("jsbh");
		//String kcmc = request.getParameter("kcmc");
		String xkkh = request.getParameter("xkkh");
		System.out.print("11"+jsbh+"sd");
		//System.out.println(jsbh+"123123");
        System.out.println("22"+xkkh+"33");
		try {
                 HttpSession session=request.getSession();

                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                // session.setAttribute("xn", xn);
                // session.setAttribute("xq", xq);
                 session.setAttribute("jsbh", jsbh);
                 session.setAttribute("xkkh", xkkh);
                 
                 ExamInfo examInfo = userInfo.examinfo(jsbh,xkkh);
                 session.setAttribute("examInfo", examInfo);
                 request.getRequestDispatcher("/WebRoot/sendPnone.jsp");
				 response.sendRedirect("/sendPhone.jsp");
                 
                 
		} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
