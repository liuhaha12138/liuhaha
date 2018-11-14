package teacher.service.impl;

import java.util.List;

import teacher.model.ExamInfo;
import teacher.model.TeacherInfo;
import teacher.model.usertable;
import teacher.service.interfaces.IUserInformationSV;

public class UserInformationSVImpl  implements IUserInformationSV     {
	
	
	/**
	 * 校验用户登录信息
	 */
	public boolean isUser(usertable user) throws Exception {
		
		if(user != null){
			return DAO.valiuser(user);
		}
		return false;
	}
	/**
	 * 查询所有的考试信息
	 */
	public List<ExamInfo> getExamInfoAll() throws Exception {
		return DAO.getExamInfoAll();
	}
	/**
	 * 编辑教师提醒
	 */
	public void editinfo() throws Exception {
		return;
	}

}
