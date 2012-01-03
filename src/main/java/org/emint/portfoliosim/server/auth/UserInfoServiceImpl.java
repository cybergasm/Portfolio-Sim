package org.emint.portfoliosim.server.auth;

import org.emint.portfoliosim.client.auth.UserInfoService;
import org.emint.portfoliosim.shared.data.LoggedInUser;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserInfoServiceImpl extends RemoteServiceServlet implements
    UserInfoService {

  private static final long serialVersionUID = 1L;

  @Override
  public LoggedInUser getCurrentUser() {
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    
    if (user == null){
      return null;
    } else {
      LoggedInUser liUser = new LoggedInUser();
      liUser.setUserName(user.getNickname());
      return liUser;
    }
  }

}
