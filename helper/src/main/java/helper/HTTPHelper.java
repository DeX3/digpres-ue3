package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.DatatypeConverter;

public class HTTPHelper {
	
	public static String get(
        String uri,
        String username,
        String password
    ) throws IOException {
		
		String auth = username + ":" + password;
		String encoded = DatatypeConverter.printBase64Binary( auth.getBytes() );

		HttpURLConnection conn = null;
	
		URL url = new URL( uri );
		conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod( "GET" );
		conn.setRequestProperty( "Authorization", "Basic " + encoded );
		
		InputStream is = conn.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    StringBuilder response = new StringBuilder();

	    String line;
	    while((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    
	    return response.toString();
	}

}
