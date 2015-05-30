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

}
