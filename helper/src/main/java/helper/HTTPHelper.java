package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

public class HTTPHelper {
	
	public static String get(
        String uri,
        String username,
        String password
    ) throws IOException {
		
	    HTTPResponse resp = HTTPHelper.getFull( uri, username, password );
	    return resp.getBody();
	}

	public static HTTPResponse getFull(
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
	    
	    return new HTTPResponse(
	    	response.toString(),
	    	conn.getHeaderFields()
	    );
	}
	
	public static class HTTPResponse {
		
		private String body;
		private Map<String, List<String>> headers;
		
		public HTTPResponse( String body, Map<String, List<String>> headers ) {
			this.body = body;
			this.headers = headers;
		}

		public Map<String, List<String>> getHeaders() {
			return headers;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}
	}

}
