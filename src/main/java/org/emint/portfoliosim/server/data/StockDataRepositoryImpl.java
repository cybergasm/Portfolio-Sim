package org.emint.portfoliosim.server.data;

import org.emint.portfoliosim.server.utils.StockQueryUrlBuilder;
import org.emint.portfoliosim.server.utils.URLDataReader;
import org.emint.portfoliosim.shared.data.StockData;

public class StockDataRepositoryImpl implements StockDataRepository {
  final private URLDataReader urlReader; 
  
  public StockDataRepositoryImpl (URLDataReader reader) {
    urlReader = reader;
  }
  
  @Override
  public StockData getStock(String symbol) {
    StockQueryUrlBuilder urlBuilder = new StockQueryUrlBuilder();
    urlBuilder.addSymbol(symbol);
    urlBuilder.addFormatParams("snb3");
    String data = urlReader.getData(urlBuilder.getUrl());
    return StockDataFactory.stockDataFromCSV(data);
  }

}
