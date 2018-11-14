package teacher.service.interfaces;

import java.util.List;

import teacher.dao.impl.UserInformationDAOImpl;
import teacher.dao.interfaces.IUserInformationDAO;
import teacher.model.ExamInfo;
import teacher.model.usertable;

public interface IUserInformationSV {
	IUserInformationDAO DAO = new UserInformationDAOImpl();
	
	public boolean isUser(usertable user) throws Exception;
	
	public List<ExamInfo> getExamInfoAll () throws Exception;
	public void editinfo() throws Exception;
}
