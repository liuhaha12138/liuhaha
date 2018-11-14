package twodays;


import java.util.Date;
import java.text.SimpleDateFormat;




public class nowtime {

	
	
	public static Date nowstring(String string) throws java.text.ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		
		
				Date date2=df.parse(df.format(new Date()));
			
		
		        return date2;
		
	}

}
