package helper;

import org.junit.Test;

public class MongoTest {

	@Test
	public void test() {
		
		String json = MongoHelper.mapReduce(
            "localhost",
            27017,
            "github",
            "github-1433087347666",
            "function() {" +
              "var languages = Object.keys(this.languages);" +
              "for( var i=0 ; i < languages.length ; i++ ) {" +
                "var lang = languages[i];" +
                "emit( lang, this.languages[lang] );" +
              "}" +
            "}",
            "function( key, values ) {" +
              "return Array.sum( values );" +
            "}"
        );
		
		System.out.println( json );
	}

}
