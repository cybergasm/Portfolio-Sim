package org.emint.portfoliosim.client.auth;

import org.emint.portfoliosim.shared.data.LoggedInUser;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userInfo")
public interface UserInfoService extends RemoteService {
  LoggedInUser getCurrentUser();
}
