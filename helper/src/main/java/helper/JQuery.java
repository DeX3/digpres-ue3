package helper;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class JQuery {
	
	String json;

	public JQuery( String json ) {
		this.json = json;
	}
	
	public int qint( String q ) {
		int ret = JsonPath.read( this.json, q, new Predicate[]{} );
		
		return ret;
	}
}
