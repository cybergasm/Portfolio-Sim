package org.emint.portfoliosim.client.portfolio;


import org.emint.portfoliosim.shared.data.StockData;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PortfolioViewImpl extends VerticalPanel implements PortfolioView {

  private static final String PORTFOLIO_TABLE_STYLE = "portfolioTable";

  private static final String PORTFOLIO_HEADER_STYLE = "portfolioHeader";

  private static final int OVERALL_INDEX = 6;
  private static final int RECENT_INDEX = 5;
  private static final int SHARES_OWNED = 4;
  private static final int PURCHASED_INDEX = 3;
  private static final int CUR_PRICE_INDEX = 2;
  private static final int NAME_INDEX = 1;
  private static final int SYMBOL_INDEX = 0;

  private FlexTable stockTable = new FlexTable();
  
  private HorizontalPanel addStockPanel = new HorizontalPanel();
  private TextBox stockName = new TextBox();
  private Label message = new Label();
  private Button addStockButton = new Button("Add Symbol");
  
  public PortfolioViewImpl() {
    stockTable.setText(0, SYMBOL_INDEX, "Symbol");
    stockTable.setText(0, NAME_INDEX, "Full Name");
    stockTable.setText(0, CUR_PRICE_INDEX, "Current Price");
    stockTable.setText(0, PURCHASED_INDEX, "Purchased Price");
    stockTable.setText(0, SHARES_OWNED, "Shares owned");
    stockTable.setText(0, RECENT_INDEX, "Recent Change");
    stockTable.setText(0, OVERALL_INDEX, "Overall Change");
    
    stockTable.getRowFormatter().addStyleName(0, PORTFOLIO_HEADER_STYLE);
    stockTable.addStyleName(PORTFOLIO_TABLE_STYLE);
    
    addStockPanel.add(stockName);
    addStockPanel.add(addStockButton);
    
    PortfolioResources.INSTANCE.css().ensureInjected();
    
    add(stockTable);
    add(message);
    add(addStockPanel);
  }

  public void setErrorMessage(String message) {
    this.message.setText(message);
  }

  public void setSuccessMessage(String message) {
    this.message.setText(message);
  }

  public void onAddHandler(ClickHandler handler) {
    addStockButton.addClickHandler(handler);
  }

  public String getStock() {
    return stockName.getText();
  }

  public Widget getView() {
    return this;
  }

  @Override
  public void addStock(StockData data) {
    int row = stockTable.getRowCount();
    stockTable.setText(row, NAME_INDEX, data.getName());
    stockTable.setText(row, CUR_PRICE_INDEX, ""+data.getPrice().doubleValue());
    stockTable.setText(row, SYMBOL_INDEX, data.getSymbol());
    stockTable.setText(row, PURCHASED_INDEX, ""+data.getPrice().doubleValue());
    stockTable.setText(row, SHARES_OWNED, "10");
    stockTable.setText(row, RECENT_INDEX, "+.34");
    stockTable.setText(row, OVERALL_INDEX, "+10.00");
  }

}
