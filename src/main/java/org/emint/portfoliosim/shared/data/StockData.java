package org.emint.portfoliosim.shared.data;

import java.io.Serializable;

public class StockData implements Serializable{
  
  private static final long serialVersionUID = 1L;
  private String symbol = "unk";
  private String name = "unknown";
  private Double price = 0.0d;
  
  
  public String getSymbol() {
    return symbol;
  }
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }

}
