package org.emint.portfoliosim.client.portfolio;

import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;

public interface PortfolioView {
  
  public void setErrorMessage(String message);
  public void setSuccessMessage(String message);
  public void onAddHandler(ClickHandler handler);
  public String getStock();
  public Widget getView();
  public void addStock(StockData data);
}
