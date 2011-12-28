package org.emint.portfoliosim.server.data;

import org.emint.portfoliosim.shared.data.StockData;

public class StockDataFactory {
  public static StockData stockDataFromCSV(String csvString){
    String[] values = csvString.split(",");
    StockData data = new StockData();
    data.setSymbol(values[0].trim().replaceAll("\"", ""));
    data.setName(values[1].trim().replaceAll("\"", ""));
    data.setPrice(Double.parseDouble(values[2]));
    return data;
  }
}
