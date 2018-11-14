package teacher.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.model.ExamInfo;
import teacher.model.TeacherInfo;
import teacher.model.usertable;

public interface IUserInformationDAO {
	public boolean valiuser(usertable user) throws Exception;
	
	public List<ExamInfo> getExamInfoAll () throws Exception;
	public List<TeacherInfo> getTeacherInfoAll () throws 

Exception;

	public TeacherInfo editinfo(String zgh) throws Exception;
	public void service(HttpServletRequest request, 

HttpServletResponse response) 
			 throws ServletException, IOException, 

SQLException;
	public void updateqx(String qx,String zgh) throws 

Exception ;
	public void updateurl(String ip,String usertype,String 

path,String usern,String pwd,String xn,String xq,String NAME,String PASS,String XUEN,String XUEQ,String cs,String cssx) throws 

Exception;
	public List<TeacherInfo> searchTeacherInfo(int page,String 

bm) throws Exception;
	public void updatesendtime(String dayj,String dayy,String 

sendtimes,String sendtimef,String sendtimem) throws Exception;
	public void adduser(String username,String password) throws Exception;
	public List<usertable> showUser() throws Exception;
}

