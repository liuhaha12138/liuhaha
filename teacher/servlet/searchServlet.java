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
import teacher.service.impl.UserInformationSVImpl;
import teacher.service.interfaces.IUserInformationSV;

public class searchServlet extends HttpServlet{
	IUserInformationSV  userSV = new UserInformationSVImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String bm = request.getParameter("bm");
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
                 System.out.println("jsp currentPage:"+currentPage);
                 UserInformationDAOImpl userInfo=new UserInformationDAOImpl();
                 List<TeacherInfo> searchteacherInfoList=userInfo.searchTeacherInfo(currentPage, bm);
                 session.setAttribute("searchteacherInfoList", searchteacherInfoList);
                 session.setAttribute("currentPage", currentPage);
                 session.setAttribute("bm", bm); 
                 int bbm=0;
                 if(bm=="材料科学与工程学院"){bbm=1;}
                 else if(bm=="机械与精密仪器工程学院"){bbm=2;}
                 else if(bm=="印刷包装与数字媒体学院"){bbm=3;}
                 else  if(bm=="自动化与信息工程学院"){bbm=4;}
                 else  if(bm=="经济与管理学院"){bbm=5;}
                 else  if(bm=="水利水电学院"){bbm=6;}
                 else  if(bm=="人文与外国语学院"){bbm=7;}
                 else  if(bm=="理学院"){bbm=8;}
                 else  if(bm=="计算机科学与工程学院"){bbm=9;}
                 else  if(bm=="体育教学部"){bbm=10;}
                 else  if(bm=="马克思主义学院"){bbm=11;}
                 else  if(bm=="工程训练中心"){bbm=12;}
                 else  if(bm=="曲江校区"){bbm=13;}
                 else  if(bm=="艺术与设计学院"){bbm=14;}
                 else  if(bm=="现代分析测试中心"){bbm=15;}
                 else  if(bm=="土木建筑工程学院"){bbm=16;}
                 session.setAttribute("bbm", bbm);   
                 response.sendRedirect("limit.jsp");
//                request.getRequestDispatcher("limit.jsp");
		} catch (IOException e) {
			e.printStackTrace();} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
