package org.emint.portfoliosim.client.portfolio;

import static org.mockito.Mockito.*;

import org.junit.Test;


public class PortfolioControllerImplTest {

    PortfolioView mockView = mock(PortfolioView.class);
    PortfolioController controller = new PortfolioControllerImpl(mockView);
    
    @Test
    public void validStockSymbol() {
      controller.addStock("BAC");
      verify(mockView).setSuccessMessage(anyString());
    }
    
    @Test
    public void invalidEmptyStockSymbol() {
      controller.addStock("");
      verify(mockView).setErrorMessage(anyString());
    }
}
