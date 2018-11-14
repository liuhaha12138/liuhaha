package teacher.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;

public class changeServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String zgh = request.getParameter("zgh");
		String qx = request.getParameter("qx");
		System.out.println("权限"+qx);
		try {
                 HttpSession session=request.getSession();
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("zgh", zgh);
                 session.setAttribute("qx", qx); 
                 System.out.println("权限"+zgh+qx);
                 userInfo.updateqx(qx,zgh);
                 System.out.println("权限"+zgh+qx);
                 response.sendRedirect("findteacher.jsp");
                
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
