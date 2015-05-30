package helper;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class HTTPHelperTest {

	@Test
	public void test() throws IOException {
		System.out.println(
            HTTPHelper.get(
                "https://api.github.com/repos/mojombo/grit/pulls",
                "DeX3",
                "bb2a63e39d019cefc3be82ae7fd6e1e1ba8bfa0c"
            )
        );
	}

}
