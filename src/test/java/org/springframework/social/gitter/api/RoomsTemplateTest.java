package org.springframework.social.gitter.api;

import org.junit.Test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

public class RoomsTemplateTest extends AbstractGitterApiTest {

	@Test
	public void listRooms(){
		/*mockServer.expect(requestTo("https://api.gitter.im/v1/rooms"))
			.andExpect(header("Authorization", "Bearer test"))
			.andRespond(withSuccess());*/
		gitter.roomsOperations().listRooms();
	}
	
	@Test
	public void users(){
		/*mockServer.expect(requestTo("https://api.gitter.im/v1/rooms"))
			.andExpect(header("Authorization", "Bearer test"))
			.andRespond(withSuccess());*/
		String roomId = gitter.roomsOperations().listRooms().get(0).getId();
		gitter.roomsOperations().users(roomId);
	}

}
