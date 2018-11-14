package downloaddata;

import java.io.File;
import java.io.IOException;

import loadJson.loadJson;
public class DownLoadData_teacher {
	
	public static void DownLoad_teacher() throws IOException{
	
	String url ="http://202.200.112.210:8080/superistudyserver/teacherinvigilatewithphone?usrtype=radioTeacher&usern=103008&pwd=123456&xn=2017-2018&xq=1";   
    String json = loadJson.loadJ2son(url);       
    String sDestFile = "C:\\Users\\Administrator\\Desktop\\J2son_teacher";

    File destFile = new File(sDestFile);    
    if (!destFile.exists()) {
    destFile.createNewFile();
    
    }

    downloaddata.writeByFileWrite(sDestFile, json);
    


}
	}

