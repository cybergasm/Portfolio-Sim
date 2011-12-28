package org.emint.portfoliosim.server.data;

import org.emint.portfoliosim.client.data.StockDataService;
import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StockDataServiceImpl extends RemoteServiceServlet implements
    StockDataService {

  @Override
  public StockData getData(String symbol) {
    StockData datum = new StockData();
    datum.setName("MyOrg");
    datum.setSymbol("MO");
    datum.setPrice(1.2);
    return datum;
  }

}
