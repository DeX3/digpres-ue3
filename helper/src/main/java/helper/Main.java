package helper;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class Main {

	public static void main(String[] args) {
		
		DocumentContext ctx = JsonPath.parse( "{ \"asdf\": 47 }" );
		
		Integer out = ctx.read( "asdf", Integer.class, new Predicate[]{} );
		System.out.println( out );
	}

}
