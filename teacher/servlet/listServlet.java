package teacher.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.dao.impl.UserInformationDAOImpl;

public class listServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInformationDAOImpl  dao;

	 

	 @Override

	 public void init() throws ServletException {

	 dao = new UserInformationDAOImpl();

	 super.init();

	 }
}