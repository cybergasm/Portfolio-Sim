package org.emint.portfoliosim.server.data;

import static org.junit.Assert.*;

import org.emint.portfoliosim.shared.data.StockData;
import org.junit.Test;


public class StockDataFactoryTest {
  String cvs = "\"SYM\", Symbol, 23.0";
  
  @Test
  public void factoryParsesCVSData() {
    StockData data = StockDataFactory.stockDataFromCSV(cvs);
    assertEquals("SYM", data.getSymbol());
    assertEquals("Symbol", data.getName());
    assertEquals(new Double(23.0), data.getPrice());
  }
}
