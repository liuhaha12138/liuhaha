package teacher.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;

public class updateServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String zgh = request.getParameter("zgh");
		String qx = request.getParameter("qx");
		String bbm = request.getParameter("bbm");
		try {
                 HttpSession session=request.getSession();
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("zgh", zgh);
                 session.setAttribute("qx", qx); 
                 userInfo.updateqx(qx,zgh);
                 response.sendRedirect("limit.jsp?bbm="+bbm);
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
