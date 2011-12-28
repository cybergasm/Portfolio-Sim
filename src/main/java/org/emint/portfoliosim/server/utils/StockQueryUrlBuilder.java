package org.emint.portfoliosim.server.utils;

public class StockQueryUrlBuilder {
  final private String base = "http://finance.yahoo.com/d/quotes.csv?";
  final private String stockParam = "s=";
  
  //format spec can be found at http://www.gummy-stuff.org/Yahoo-data.htm
  final private String formatParam = "f=";
  
  private String stocks = "";
  private String format = "";
  public void addSymbol(String symbol){
    if (stocks.length() == 0) {
      stocks += symbol;
    } else {
      stocks += "+"+symbol;
    }
  }
  
  public void addFormatParams(String formatParam){
    format += formatParam;
  }
  public String getUrl(){
    return base+stockParam+stocks+"&"+formatParam+format;
  }
}
