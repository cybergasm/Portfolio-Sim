package org.emint.portfoliosim.client.portfolio;


import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PortfolioViewImpl extends VerticalPanel implements PortfolioView {
  private FlexTable stockTable = new FlexTable();
  
  private HorizontalPanel addStockPanel = new HorizontalPanel();
  private TextBox stockName = new TextBox();
  private Label message = new Label();
  private Button addStockButton = new Button("Add Symbol");
  
  public PortfolioViewImpl() {
    stockTable.setText(0, 0, "Symbol");
    stockTable.setText(0, 1, "Full Name");
    stockTable.setText(0, 2, "Current Price");
    stockTable.setText(0, 3, "Purchased Price");
    stockTable.setText(0, 4, "Recent Change");
    stockTable.setText(0, 5, "Overall Change");
    
    addStockPanel.add(stockName);
    addStockPanel.add(addStockButton);
    
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

}
