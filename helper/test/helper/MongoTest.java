package helper;

import static org.junit.Assert.*;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.JSONParser;

import org.junit.Test;

public class MongoTest {

	@Test
	public void test() {
		String json = "[{ \"test\": 1 }, { \"test\": 2 }]";
		JSONArray array = (JSONArray)JSONValue.parse( json );
		
		MongoHelper.insert( "localhost", 27017, "github", "github-test", array);
	}

}
