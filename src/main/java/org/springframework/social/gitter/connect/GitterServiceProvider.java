package org.springframework.social.gitter.connect;

import org.springframework.social.gitter.api.Gitter;
import org.springframework.social.gitter.api.impl.GitterTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

public class GitterServiceProvider extends AbstractOAuth2ServiceProvider<Gitter>{

	public GitterServiceProvider(String clientId, String clientSecret) {
		super(new OAuth2Template(clientId,
				clientSecret,
				"https://gitter.im/login/oauth/authorize",
				"https://gitter.im/login/oauth/token"));
	}
	
	@Override
	public Gitter getApi(String accessToken) {
		return new GitterTemplate(accessToken);
	}

}
