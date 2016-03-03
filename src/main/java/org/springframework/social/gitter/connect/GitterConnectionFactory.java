package org.springframework.social.gitter.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.gitter.api.Gitter;

public class GitterConnectionFactory extends OAuth2ConnectionFactory<Gitter> {
	public GitterConnectionFactory(String clientId, String clientSecret) {
		super("gitter", new GitterServiceProvider(clientId, clientSecret), new GitterAdapter());
	}
}
