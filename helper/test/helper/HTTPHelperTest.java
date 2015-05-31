package helper;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class HTTPHelperTest {

	@Test
	public void test() throws IOException {
		System.out.println(
            HTTPHelper.get(
                "https://api.github.com/repositories",
                "DeX3",
                "token"
            )
        );
	}

}
