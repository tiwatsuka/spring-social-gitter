package org.springframework.social.gitter.api;

import org.junit.Before;
import org.springframework.social.gitter.api.impl.GitterTemplate;
import org.springframework.test.web.client.MockRestServiceServer;

public class AbstractGitterApiTest {

	protected static final String ACCESS_TOKEN = "test";
	
	protected GitterTemplate gitter;

	//protected MockRestServiceServer mockServer;
	
	@Before
	public void setup(){
		gitter = new GitterTemplate(ACCESS_TOKEN);
		//mockServer = MockRestServiceServer.createServer(gitter.getRestTemplate());
	}
}
