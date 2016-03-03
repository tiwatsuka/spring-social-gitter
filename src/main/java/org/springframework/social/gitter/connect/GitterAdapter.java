package org.springframework.social.gitter.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.gitter.api.Gitter;
import org.springframework.social.gitter.api.User;

public class GitterAdapter implements ApiAdapter<Gitter> {

	@Override
	public UserProfile fetchUserProfile(Gitter gitter) {
		User user = gitter.userOperations().getCurrentUser();
		return new UserProfileBuilder().setId(user.getId())
				.setName(user.getDisplayName()).setUsername(user.getUsername()).build();
	}

	@Override
	public void setConnectionValues(Gitter gitter, ConnectionValues values) {
		User user = gitter.userOperations().getCurrentUser();
		values.setProviderUserId(user.getId());
		values.setDisplayName(user.getDisplayName());
		values.setImageUrl(user.getAvatarUrlSmall());
	}

	@Override
	public boolean test(Gitter gitter) {
		try{
			gitter.userOperations().getCurrentUser();
			return true;
		}catch(ApiException e){
			return false;
		}
	}

	@Override
	public void updateStatus(Gitter gitter, String message) {
	}

}
