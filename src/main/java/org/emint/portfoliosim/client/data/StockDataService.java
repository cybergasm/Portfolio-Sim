package org.emint.portfoliosim.client.data;

import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("stockData")
public interface StockDataService  extends RemoteService{
  StockData getData(String symbol);
}
