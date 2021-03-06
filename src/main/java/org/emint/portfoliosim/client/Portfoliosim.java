package org.emint.portfoliosim.client;

import org.emint.portfoliosim.client.auth.UserInfoService;
import org.emint.portfoliosim.client.auth.UserInfoServiceAsync;
import org.emint.portfoliosim.client.data.StockDataService;
import org.emint.portfoliosim.client.data.StockDataServiceAsync;
import org.emint.portfoliosim.client.portfolio.PortfolioController;
import org.emint.portfoliosim.client.portfolio.PortfolioControllerImpl;
import org.emint.portfoliosim.client.portfolio.PortfolioView;
import org.emint.portfoliosim.client.portfolio.PortfolioViewImpl;
import org.emint.portfoliosim.shared.data.LoggedInUser;
import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Portfoliosim implements EntryPoint {
  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */

  final private PortfolioView view = new PortfolioViewImpl();
  private StockDataServiceAsync stockDataSvc = GWT
      .create(StockDataService.class);
  final private PortfolioController controller = new PortfolioControllerImpl(
      view, stockDataSvc);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    UserInfoServiceAsync userInfoService = GWT.create(UserInfoService.class);
    
    userInfoService.getCurrentUser(new AsyncCallback<LoggedInUser>() {

      @Override
      public void onFailure(Throwable arg0) {
        view.setErrorMessage("Could not connect to user service.");
      }

      @Override
      public void onSuccess(LoggedInUser user) {
        if (user == null){
          view.setErrorMessage("Logged in user not found!");
        } else {
          view.setSuccessMessage("Welcome "+user.getUserName());
          loadPortfolio();
        }

      }
    });
  }
  
  void loadPortfolio() {
    view.onAddHandler(new ClickHandler() {

      public void onClick(ClickEvent arg0) {
        controller.addStock(view.getStock());
      }
    });

    RootPanel.get("portfolio").add(view.getView());
  }
}
