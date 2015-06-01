package helper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.junit.Test;

public class ExtractionTest {

	@Test
	public void test() {
		String json = "[ { \"id\": 1234, \"name\": \"asdf\", \"foo\": true } ]";
		
		final String[] PRESERVED_FIELDS = new String[]{"id", "name"};
		
		JSONArray arr = JSONHelper.parseArray( json );
		for( Object o : arr ) {
			JSONObject repo = (JSONObject)o;

			JSONHelper.pick( repo, PRESERVED_FIELDS );
            System.out.println( repo );
		}
	}
	
	@Test
	public void testConcat() {
		
		String array1 = "[ { \"id\": 1234, \"name\": \"asdf\", \"foo\": true } ]";
		String array2 = "[ { \"id\": 4711, \"name\": \"qwer\", \"foo\": false } ]";
		
		JSONArray arr1 = JSONHelper.parseArray( array1 );
		JSONArray arr2 = JSONHelper.parseArray( array2 );
		
		arr1.addAll( arr2 );
		
		int max = Math.min(1, arr1.size());
		System.out.println( arr1.subList(0,0).toString() );
	}

}
