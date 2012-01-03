package org.emint.portfoliosim.client.auth;

import org.emint.portfoliosim.shared.data.LoggedInUser;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserInfoServiceAsync {

  void getCurrentUser(AsyncCallback<LoggedInUser> callback);

}
