package loadJson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;


@SuppressWarnings("unused")
public class loadJson {
	

	
	public static String loadJ2son (String url) {
    StringBuilder json = new StringBuilder();
    try {
    	URL urlObject = new URL(url); 
        URLConnection uc = urlObject.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
        String inputLine = null;
        while ( (inputLine = in.readLine()) != null) {
            json.append(inputLine);
        }
        in.close();
    } catch (MalformedURLException e) {
    	e.printStackTrace();
    } catch (IOException e) {
    	e.printStackTrace();
    }
    
    return json.toString();
}

}
