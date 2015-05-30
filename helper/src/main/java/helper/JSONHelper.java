package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import com.damnhandy.uri.template.UriTemplate;

public class JSONHelper {
	
	public static JSONArray parseArray( String json ) {
		return JSONValue.parse( json, JSONArray.class );
	}

	public static JSONObject parseObject( String json ) {
		return JSONValue.parse( json, JSONObject.class );
	}
	
	public static void pick( JSONObject obj, String...keysToPreserve ) {
		
		List<String> keys = Arrays.asList(keysToPreserve);
		List<String> toRemove = new ArrayList<>();		
		
		for( String key : obj.keySet() ) {
			if( !keys.contains(key) ) {
				toRemove.add(key);
			}
		}
		
		for( String key : toRemove ) {
			obj.remove( key );
		}
	}
	
	public static String stripUrlParameters( String url ) {
		
		UriTemplate tpl = UriTemplate.fromTemplate( url );
		
		for( String str : tpl.getVariables() ) {
			tpl.set( str, null );
		}
		
		return tpl.expand();
	}

}
