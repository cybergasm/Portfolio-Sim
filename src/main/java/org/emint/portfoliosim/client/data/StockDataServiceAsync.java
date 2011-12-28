package org.emint.portfoliosim.client.data;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface StockDataServiceAsync {

  void getData(String symbol, AsyncCallback<StockData> callback);

}
