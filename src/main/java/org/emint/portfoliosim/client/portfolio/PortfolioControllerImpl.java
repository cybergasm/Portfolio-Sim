package org.emint.portfoliosim.client.portfolio;

public class PortfolioControllerImpl implements PortfolioController{
  
  private PortfolioView view;
  
  public PortfolioControllerImpl(PortfolioView view){
    this.view = view;
  }
  public void addStock(String symbol) {
    if(!symbol.matches("^[0-9A-Z\\.]{1,10}")) {
      view.setErrorMessage("Symbol is not valid");
    } else {
      view.setSuccessMessage("Symbol added succesfully!");
    }
  }

}
