package org.emint.portfoliosim.server.data;

import org.emint.portfoliosim.shared.data.StockData;

public interface StockDataRepository {
  StockData getStock(String symbol);
}
