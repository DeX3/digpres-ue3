package helper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoHelper {
	
	public static int insert(
        String host,
        int port,
        String database,
        String collection,
        JSONArray array
    ) {
		
		MongoClient mongo = new MongoClient( host, port );
		MongoDatabase db = mongo.getDatabase( database );
		MongoCollection<Document> coll = db.getCollection( collection );
		
		int i = 0;
		for( Object o : array ) {
			JSONObject obj = (JSONObject)o;
			
			Document d = Document.parse( obj.toJSONString() );
			coll.insertOne( d );
			i++;
		}

		mongo.close();

		return i;
	}

}
