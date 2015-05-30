package helper;

import org.junit.Test;

import com.damnhandy.uri.template.UriTemplate;

public class UriTemplateTest {

	@Test
	public void test() {
		UriTemplate tpl = UriTemplate.fromTemplate(
            "https://api.github.com/repos/mojombo/grit/pulls{/number}"
		);
		
		tpl.set( "number", null );

		System.out.println( tpl.expand() );
	}

}
