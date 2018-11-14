package teacher.dao.impl;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import teacher.Utils.DBUtils;
import teacher.dao.interfaces.IUserInformationDAO;
import teacher.model.ExamInfo;
import teacher.model.PageResult;
import teacher.model.TeacherInfo;
import teacher.model.usertable;
import teacher.model.url;

public class UserInformationDAOImpl  implements IUserInformationDAO {

	private Object rs;

	public boolean valiuser(usertable user) throws Exception {
		Connection conn = DBUtils.getCon();
		try {
			
			String sql = "select * from  usertable where username=? and password=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			conn.close();//TODO  关闭数据连接
		}
		
	}

	public TeacherInfo editinfo(String zgh) throws Exception {
		Connection conn = DBUtils.getCon();
		TeacherInfo teacher = new TeacherInfo();
		try {

			String sql = "select * from teacher where zgh=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			
			pstmt.setString(1, zgh);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			
			teacher.setBm(rs.getString("BM"));
			teacher.setZgh(rs.getString("ZGH"));
            teacher.setXm(rs.getString("XM"));
            teacher.setLxdh(rs.getString("LXDH"));
            teacher.setQx(rs.getString("QX"));
			}
			System.out.printf(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally{
			conn.close();//TODO  关闭数据连接
		}
		return teacher;
		
	}

	public ExamInfo examinfo(String jsbh,String xkkh) throws Exception {
		Connection conn = DBUtils.getCon();
		ExamInfo exam = new ExamInfo(); 
		try {

			String sql = "select * from exam_info where jsbh=? and xkkh=? order by CONVERT(jkjs1 USING gbk)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			
			pstmt.setString(1, jsbh);
			pstmt.setString(2, xkkh);
			
			
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			
			exam.setKssj(rs.getString("KSSJ"));
			exam.setJsmc(rs.getString("JSMC"));
			exam.setKcmc(rs.getString("KCMC"));
			exam.setKcmc(rs.getString("JKJS1"));
			exam.setKcmc(rs.getString("JKJS2"));
			exam.setKcmc(rs.getString("JKJS3"));
			exam.setKcmc(rs.getString("JKJS4"));
			
			//exam
			}
			System.out.printf(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally{
			conn.close();//TODO  关闭数据连接
		}
		return exam;
		
	}
	public List<ExamInfo> getExamInfoAll(int page) throws Exception {//查询监考信息
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		List rtList = new ArrayList();
		try {
			insertexam();
			updatetel1();
			updatetel2();
			updatetel3();
			updatetel4();
			int pageSize = 4;
			int lastPageRows = pageSize *(page -1);
			
			String sql = "SELECT * FROM exam_info ORDER BY CONVERT(jkjs1 USING gbk) LIMIT "+lastPageRows+","+pageSize+"" ;
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			//pstmt.setInt(1, 7);
			//pstmt.setInt(2, 7*(page-1));
			System.out.printf(sql);

			
			ResultSet rs = pstmt.executeQuery();
			System.out.println(sql);
			System.out.println(lastPageRows);
			System.out.println(pageSize);

			
			while(rs.next()){//循环处理信息
				ExamInfo exam = new ExamInfo();
				exam.setXn(rs.getString("XN"));
				exam.setXq(rs.getString("XQ"));
				exam.setKcmc(rs.getString("KCMC"));
	            exam.setKssj(rs.getString("KSSJ"));
	            exam.setXkkh(rs.getString("XKKH"));
	            exam.setJsxm(rs.getString("JSXM"));
	            exam.setJsbh(rs.getString("JSBH"));
	            exam.setJsmc(rs.getString("JSMC"));
	            exam.setJkjs1(rs.getString("JKJS1"));
	            exam.setJkjs2(rs.getString("JKJS2"));
	            exam.setJkjs3(rs.getString("JKJS3"));
	            exam.setJkjs4(rs.getString("JKJS4"));
	            exam.setJszgh1(rs.getString("JSZGH1"));
	            exam.setJszgh2(rs.getString("JSZGH2"));
	            exam.setJszgh3(rs.getString("JSZGH3"));
	            exam.setJszgh4(rs.getString("JSZGH4"));
	            exam.setDxtxztz1(rs.getString("DXTXZTZ1"));
	            exam.setDxtxztt1(rs.getString("DXTXZTT1"));
	            exam.setDxtxztz2(rs.getString("DXTXZTZ2"));
	            exam.setDxtxztt2(rs.getString("DXTXZTT2"));
	            exam.setDxtxztz3(rs.getString("DXTXZTZ3"));
	            exam.setDxtxztt3(rs.getString("DXTXZTT3"));
	            exam.setDxtxztz4(rs.getString("DXTXZTZ4"));
	            exam.setDxtxztt4(rs.getString("DXTXZTT4"));
	            exam.setLxdh1(rs.getString("LXDH1"));
	            exam.setLxdh2(rs.getString("LXDH2"));
	            exam.setLxdh3(rs.getString("LXDH3"));
	            exam.setLxdh4(rs.getString("LXDH4"));
	            exam.setBm1(rs.getString("BM1"));
	            exam.setBm2(rs.getString("BM1"));
	            exam.setBm3(rs.getString("BM1"));
	            exam.setBm4(rs.getString("BM1"));
	            exam.setQx1(rs.getString("QX1"));
	            exam.setQx2(rs.getString("QX2"));
	            exam.setQx3(rs.getString("QX3"));
	            exam.setQx4(rs.getString("QX4"));
                rtList.add(exam);
			}
			return rtList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			conn.close();//TODO关闭数据连接
			
		}
	}
	private void updatetel1() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		try {
		 
			String sql="update exam_info,teacher set lxdh1=teacher.lxdh,qx1=teacher.qx where exam_info.jszgh1=teacher.zgh;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}

			System.out.printf(sql);

			pstmt.executeUpdate();
		 }catch (SQLException e) {
				//e.printStackTrace();
			}finally{
				conn.close();//TODO关闭数据连接
				
			}
	}

	private void updatetel2() throws Exception {
		// TODO Auto-generated method stub

			 try {
			 Connection conn = DBUtils.getCon();
				String sql="update exam_info,teacher set lxdh2=teacher.lxdh,qx2=teacher.qx where exam_info.jszgh2=teacher.zgh;";
				
				PreparedStatement pstmtb = conn.prepareStatement(sql);


				if (conn == null) {
					throw new Exception("获取到空的数据连接！");
				}

				System.out.printf(sql);


				pstmtb.executeUpdate();

			 }catch (SQLException e) {
					//e.printStackTrace();
				}finally{
					//TODO关闭数据连接
					
			}
		}


	
	
	private void updatetel3() throws Exception {
		// TODO Auto-generated method stub
		 try {
			 Connection conn = DBUtils.getCon();
				String sql="update exam_info,teacher set lxdh3=teacher.lxdh,qx3=teacher.qx where exam_info.jszgh3=teacher.zgh;";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);


				if (conn == null) {
					throw new Exception("获取到空的数据连接！");
				}

				System.out.printf(sql);


				pstmt.executeUpdate();

			 }catch (SQLException e) {
					//e.printStackTrace();
				}finally{
					//TODO关闭数据连接
					
			}
	}




	
	private void updatetel4() throws Exception {
		// TODO Auto-generated method stub
		 try {
			 Connection conn = DBUtils.getCon();
				String sql="update exam_info,teacher set lxdh4=teacher.lxdh,qx4=teacher.qx where exam_info.jszgh4=teacher.zgh;";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);


				if (conn == null) {
					throw new Exception("获取到空的数据连接！");
				}

				System.out.printf(sql);


				pstmt.executeUpdate();

			 }catch (SQLException e) {
					//e.printStackTrace();
				}finally{
					//TODO关闭数据连接
					
			}
	}


	public void updateurl(String ip,String usern,String pwd,String xn,String xq,String NAME,String PASS,String XUEN,String XUEQ,String usertype,String path,String cs,String cssx) throws Exception {
		try {
			Connection conn = DBUtils.getCon();
			//System.out.printf("ipppin"+ip);
			String sql = "update url set ip=?,usern=?,pwd=?,xn=?,xq=?,NAME=?,PASS=?,XUEN=?,XUEQ=?,usertype=?,path=?,cs=?,cssx=? where 1=1;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//TeacherInfo teacher = new TeacherInfo();
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			pstmt.setString(1,ip);
			pstmt.setString(2,usern);
			pstmt.setString(3,pwd);
			pstmt.setString(4,xn);
			pstmt.setString(5,xq );
			pstmt.setString(6,NAME);
			pstmt.setString(7,PASS);
			pstmt.setString(8,XUEN);
			pstmt.setString(9,XUEQ);
			pstmt.setString(10,usertype);
			pstmt.setString(11,path);
			pstmt.setString(12,cs);
			pstmt.setString(13,cssx);
			System.out.println(pstmt);
			pstmt.executeUpdate();
			System.out.println("salolkp");
		} catch (SQLException e) {
			//e.printStackTrace();
			
		} finally{
			//TODO  关闭数据连接
		}
		
	}
	
	public void updatesendtime(String dayj,String dayy,String sendtimes,String sendtimef,String sendtimem) throws Exception {
		try {
			Connection conn = DBUtils.getCon();
			String sql = "update url set dayj=?,dayy=?,sendtimes=?,sendtimef=?,sendtimem=?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//TeacherInfo teacher = new TeacherInfo();
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			pstmt.setString(1,dayj);
			pstmt.setString(2,dayy);
			pstmt.setString(3,sendtimes);
			pstmt.setString(4, sendtimef);
			pstmt.setString(5, sendtimem);
			System.out.println(dayj);
			System.out.println("1234");
			pstmt.executeUpdate();
			System.out.printf(sql);

		} catch (SQLException e) {
			//e.printStackTrace();
			
		} finally{
			//TODO  关闭数据连接
		}
		
	}
	
	private void insertexam() throws Exception {
		// TODO Auto-generated method stub
		 try {
			 Connection conn = DBUtils.getCon();
				String sql="insert into exam_info(xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4,dxtxztz1,dxtxztz2,dxtxztz3,dxtxztz4,dxtxztt1,dxtxztt2,dxtxztt4,lxdh1,lxdh2,lxdh3,lxdh4,bm1,bm2,bm3,bm4,qx1,qx2,qx3,qx4)" +
						" (select xn,xq,kcmc,kssj,xkkh,jsxm,jsbh,jsmc,jkjs1,jkjs2,jkjs3,jkjs4,jszgh1,jszgh2,jszgh3,jszgh4,dxtxztz1,dxtxztz2,dxtxztz3,dxtxztz4,dxtxztt1,dxtxztt2,dxtxztt4,lxdh1,lxdh2,lxdh3,lxdh4,bm1,bm2,bm3,bm4,qx1,qx2,qx3,qx4) " +
						"from examall,teacher where (examall.jszgh1=teacher.zgh or examall.jszgh1=teacher.zgh or examall.jszgh2=teacher.zgh or examall.jszgh3=teacher.zgh or examall.jszgh4=teacher.zgh) and xkkh not in (select xkkh from exam_info));";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);


				if (conn == null) {
					throw new Exception("获取到空的数据连接！");
				}

				System.out.printf(sql);
				pstmt.executeQuery();
               
			 }catch (SQLException e) {
					//e.printStackTrace();
				}finally{
					//TODO关闭数据连接
					
			}
	}

	private void insertteacher() throws Exception {
		// TODO Auto-generated method stub
		 try {
			 Connection conn = DBUtils.getCon();
				String sql="insert into teacher(zgh,xm,lxdh,bm,qx) (select zgh,xm,lxdh,bm,qx from teacherall where bm='计算机科学与工程学院' and zgh not in (select zgh from teacher));";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);


				if (conn == null) {
					throw new Exception("获取到空的数据连接！");
				}

				System.out.printf(sql);


				pstmt.executeQuery();

			 }catch (SQLException e) {
					//e.printStackTrace();
				}finally{
					//TODO关闭数据连接
					
			}
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException, SQLException {
		 String page = request.getParameter("currentPage");
		 int currentPage;
		 if(page ==null)
		 {
			 currentPage =  1;
		 }
		 else
		 {
		     currentPage = Integer.parseInt(page);
		 }
		 
		 Connection conn = null;
		 
		 try
		 {
		 conn = DBUtils.getCon(); 
		 PageResult pageResult = new PageResult();
              String sql = " select top ? from exam_info where xkkh not in (" +
			       "select top ？ xkkh from exam_info )order by CONVERT(jkjs1 USING gbk)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
       	   if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
  			pstmt.setInt(1,16);
  			pstmt.setInt(2,16*(currentPage-1));
  			
            ResultSet rs = pstmt.executeQuery();
            if(null == rs)
            {
            	return;
            }
            
            List<ExamInfo> exams = new ArrayList();
            ExamInfo exam = new ExamInfo();
  			while(rs.next())
  			{
  			
				exam.setXn(rs.getString("XN"));
				exam.setXq(rs.getString("XQ"));
				exam.setKcmc(rs.getString("KCMC"));
	            exam.setKssj(rs.getString("KSSJ"));
	            exam.setXkkh(rs.getString("XKKH"));
	            exam.setJsxm(rs.getString("JSXM"));
	            exam.setJsbh(rs.getString("JSBH"));
	            exam.setJsmc(rs.getString("JSMC"));
	            exam.setJkjs1(rs.getString("JKJS1"));
	            exam.setJkjs2(rs.getString("JKJS2"));
	            exam.setJkjs3(rs.getString("JKJS3"));
	            exam.setJkjs4(rs.getString("JKJS4"));
	            exam.setJszgh1(rs.getString("JSZGH1"));
	            exam.setJszgh2(rs.getString("JSZGH2")); 
	            exam.setJszgh3(rs.getString("JSZGH3"));
	            exam.setJszgh4(rs.getString("JSZGH4"));
	            exam.setLxdh1(rs.getString("LXDH1"));
	            exam.setLxdh2(rs.getString("LXDH2"));
	            exam.setLxdh3(rs.getString("LXDH3"));
	            exam.setLxdh4(rs.getString("LXDH4"));
  				exams.add(exam);
  			}
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 if(null != conn)
			 {
				 conn.close();
			 }
		 }


		 }

	public List<ExamInfo> getExamInfoAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<TeacherInfo> getTeacherInfo(int page) throws Exception {//查询教师信息
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		List rtList = new ArrayList();
		try {
			
			int pageSize = 10;
			int lastPageRows = pageSize *(page -1);

			insertteacher();

			String sqla = " SELECT * FROM teacher ORDER BY CONVERT(xm USING gbk) LIMIT "+lastPageRows+","+pageSize+"";

			PreparedStatement pstmta = conn.prepareStatement(sqla);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			//pstmt.setInt(1, 7);
			//pstmt.setInt(2, 7*(page-1));
			System.out.printf("currentPage; " + page);
			System.out.printf(sqla);
			ResultSet rs;
				 rs = pstmta.executeQuery();

			while(rs.next()){//循环处理信息
				TeacherInfo teacher = new TeacherInfo();
				teacher.setBm(rs.getString("BM"));
				teacher.setZgh(rs.getString("ZGH"));
	            teacher.setXm(rs.getString("XM"));
	            teacher.setLxdh(rs.getString("LXDH"));
	            teacher.setQx(rs.getString("QX"));
                rtList.add(teacher);
			}
			return rtList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			conn.close();//TODO关闭数据连接
			
		}
	}


	public List<TeacherInfo> getTeacherInfoAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateqx(String qx,String zgh) throws Exception {//修改权限
		
		Connection conn = DBUtils.getCon();
		try {
			String sql = "update teacher set qx=? where zgh=?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//TeacherInfo teacher = new TeacherInfo();
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			pstmt.setString(1,qx);
			pstmt.setString(2, zgh);
		    System.out.println(pstmt);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			//e.printStackTrace();
			
		} finally{
			conn.close();//TODO关闭数据连接
			//TODO  关闭数据连接
		}
		
	}
	
	public void adduser(String username,String password) throws Exception {
		
		Connection conn = DBUtils.getCon();
		try {
			String sql = "insert into usertable VALUES(?,?) ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//TeacherInfo teacher = new TeacherInfo();
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			pstmt.setString(1,username);
			pstmt.setString(2, password);
		    System.out.println(pstmt);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			//e.printStackTrace();
			
		} finally{
			conn.close();//TODO关闭数据连接
			//TODO  关闭数据连接
		}
		
	}
	
	public List<TeacherInfo> searchTeacherInfo(int page,String bm) throws Exception {//查询教师信息
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		List rtList = new ArrayList();
		try {
			
			int pageSize = 10;
			int lastPageRows = pageSize *(page-1);//
			
			String sqla = "SELECT * FROM teacher WHERE bm='"+bm+"' ORDER BY CONVERT(xm USING gbk) LIMIT "+lastPageRows+","+pageSize+" "  ;

			PreparedStatement pstmta = conn.prepareStatement(sqla);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			ResultSet rs;
			 rs = pstmta.executeQuery();
			
			while(rs.next()){//循环处理信息
				TeacherInfo teacher = new TeacherInfo();
				teacher.setBm(rs.getString("BM"));
				teacher.setZgh(rs.getString("ZGH"));
	            teacher.setXm(rs.getString("XM"));
	            teacher.setLxdh(rs.getString("LXDH"));
	            teacher.setQx(rs.getString("QX"));
                rtList.add(teacher);
			}
			return rtList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			conn.close();//TODO关闭数据连接
			
		}
	}
	
	public List<usertable> showUser() throws Exception {//查询用户信息
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		List rtList = new ArrayList();
		try {
			String sql = "SELECT * FROM usertable ORDER BY username";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			ResultSet rs;
			 rs = pstmt.executeQuery();
			
			while(rs.next()){//循环处理信息
				usertable user = new usertable();
				user.setUsername(rs.getString("USERNMAE"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setRole(rs.getString("ROLE"));
                rtList.add(user);
			}
			return rtList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			conn.close();//TODO关闭数据连接
			
		}
	}
	
	public url findURL() throws Exception {//查询URL配置
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		url u = new url();
		try {
			String sql = "SELECT * FROM url" ;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){//循环处理信息
				u.setIp(rs.getString("IP"));
				u.setUsern(rs.getString("USERN"));
				u.setUsertype(rs.getString("USERTYPE"));
	            u.setPwd(rs.getString("PWD"));
	            u.setXn(rs.getString("XN"));
	            u.setXq(rs.getString("XQ"));
	            u.setPath(rs.getString("PATH"));
	            u.setNAME(rs.getString("NAME"));
	            u.setPASS(rs.getString("PASS"));
	            u.setXUEN(rs.getString("XUEN"));
	            u.setXUEQ(rs.getString("XUEQ"));
	            u.setCs(rs.getString("CS"));
	            u.setCssx(rs.getString("CSSX"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			conn.close();//TODO关闭数据连接
			
		}
		return u;
	}

	public url findSend() throws Exception {//查询URL配置
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getCon();
		url u = new url();
		try {
			String sql = "SELECT * FROM url" ;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (conn == null) {
				throw new Exception("获取到空的数据连接！");
			}
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){//循环处理信息
				u.setDayj(rs.getString("DAYJ"));
				u.setDayy(rs.getString("DAYY"));
				u.setSendtimes(rs.getString("SENDTIMES"));
				u.setSendtimef(rs.getString("SENDTIMEF"));
				u.setSendtimem(rs.getString("SENDTIMEM"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			conn.close();//TODO关闭数据连接
			
		}
		return u;
	}

	
	}
