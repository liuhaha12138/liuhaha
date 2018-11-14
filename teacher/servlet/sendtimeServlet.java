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

public class sendtimeServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String dayj = request.getParameter("dayj");
		String dayy = request.getParameter("dayy");
		String sendtimes = request.getParameter("sendtimes");
		String sendtimef = request.getParameter("sendtimef");
		String sendtimem = request.getParameter("sendtimem");
		System.out.println(dayj);
		try {
                 HttpSession session=request.getSession();
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 session.setAttribute("dayj", dayj);
                 session.setAttribute("dayy", dayy);
                 session.setAttribute("sendtimes", sendtimes);
                 session.setAttribute("sendtimef", sendtimef);
                 session.setAttribute("sendtimem", sendtimem);
                 //URL url = new URL();
                 userInfo.updatesendtime(dayj,dayy,sendtimes,sendtimef,sendtimem);
                // userInfo.updateurl(usern,pwd,xn,xq);
                 response.sendRedirect("main.jsp");
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



