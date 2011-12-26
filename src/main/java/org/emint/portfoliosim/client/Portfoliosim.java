package org.emint.portfoliosim.client;

import org.emint.portfoliosim.client.portfolio.PortfolioController;
import org.emint.portfoliosim.client.portfolio.PortfolioControllerImpl;
import org.emint.portfoliosim.client.portfolio.PortfolioView;
import org.emint.portfoliosim.client.portfolio.PortfolioViewImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
  final private PortfolioController controller = new PortfolioControllerImpl(view);
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    Label testLabel = new Label("TEST!!!!");
    view.onAddHandler(new ClickHandler() {
      
      public void onClick(ClickEvent arg0) {
        controller.addStock(view.getStock());
      }
    });
    
    RootPanel.get("portfolio").add(view.getView());
    RootPanel.get("portfolio").add(testLabel);
  }
}
