package org.emint.portfoliosim.client.portfolio;

import org.emint.portfoliosim.client.data.StockDataService;
import org.emint.portfoliosim.client.data.StockDataServiceAsync;
import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PortfolioControllerImpl implements PortfolioController{
  
  private final PortfolioView view;
  private final StockDataServiceAsync stockDataSvc;
  
  public PortfolioControllerImpl(PortfolioView view, StockDataServiceAsync stockDataService){
    this.view = view;
    stockDataSvc = stockDataService;
  }
 
  public void addStock(String symbol) {
    if(!symbol.matches("^[0-9A-Z\\.]{1,10}")) {
      view.setErrorMessage("Symbol is not valid");
    } else {
      retrieveDataAndPopulate(symbol);
    }
  }

  private void retrieveDataAndPopulate(String symbol) {
    AsyncCallback<StockData> callback = new AsyncCallback<StockData>() {

      @Override
      public void onFailure(Throwable arg0) {
        view.setErrorMessage("Error connecting to service");
      }

      @Override
      public void onSuccess(StockData data) {
        view.addStock(data);
        view.setSuccessMessage("Symbol added succesfully!");
      }
    };
    
    stockDataSvc.getData(symbol, callback);
  }

}
