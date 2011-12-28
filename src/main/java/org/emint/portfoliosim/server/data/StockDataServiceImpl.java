package org.emint.portfoliosim.server.data;

import org.emint.portfoliosim.client.data.StockDataService;
import org.emint.portfoliosim.server.utils.HTTPUrlDataReader;
import org.emint.portfoliosim.server.utils.URLDataReader;
import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StockDataServiceImpl extends RemoteServiceServlet implements
    StockDataService {

  private static final long serialVersionUID = 1L;

  @Override
  public StockData getData(String symbol) {
    StockData datum = new StockData();
    datum.setName("MyOrg");
    datum.setSymbol("MO");
    datum.setPrice(1.2);
    return datum;
  }

}
