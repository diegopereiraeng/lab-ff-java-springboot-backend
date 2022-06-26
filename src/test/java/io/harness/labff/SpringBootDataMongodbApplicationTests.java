package io.harness.labff;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDataMongodbApplicationTests {

	@LocalServerPort
	private Integer port;


	@Test
	void printPortsInUse() {
		System.out.println(port);
	}
}