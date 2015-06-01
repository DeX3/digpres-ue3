package helper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HTTPHelperTest {

	@Test
	public void test() throws IOException {
        HTTPHelper.HTTPResponse resp = HTTPHelper.getFull(
            "https://api.github.com/repositories",
            "DeX3",
            "303f2360206ba321f596f44c92b992f61d4a5e6b"
        );
        
        String link = resp.getHeaders().get("Link").get(0);
        Pattern p = Pattern.compile("<(.*?)>.*");
        System.out.println( link );
        Matcher matcher = p.matcher( link );
        System.out.println( matcher.matches() );
        System.out.println( matcher.group(1) );
       
	}

}
