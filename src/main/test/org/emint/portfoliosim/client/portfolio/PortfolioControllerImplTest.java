package org.emint.portfoliosim.client.portfolio;

import static org.mockito.Mockito.*;

import org.emint.portfoliosim.client.data.StockDataServiceAsync;
import org.emint.portfoliosim.shared.data.StockData;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.google.gwt.user.client.rpc.AsyncCallback;


public class PortfolioControllerImplTest {

    PortfolioView mockView = mock(PortfolioView.class);
    StockDataServiceAsync mockStockDataService = mock(StockDataServiceAsync.class);
    PortfolioController controller = new PortfolioControllerImpl(mockView, mockStockDataService);
 
    
    @Test
    public void invalidEmptyStockSymbol() {
      controller.addStock("");
      verify(mockView).setErrorMessage(anyString());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void callsViewOnSuccess() {
      final StockData response = new StockData();
      response.setName("Bank of America");
      response.setSymbol("BAC");
      response.setPrice(new Double(1.4));
      Mockito.doAnswer(new Answer<StockData>() {

        @Override
        public StockData answer(InvocationOnMock invocation) throws Throwable {
          final Object[] args = invocation.getArguments();
          ((AsyncCallback) args[args.length - 1]).onSuccess(response);          
          return null;
        }
      }).when(mockStockDataService).getData(eq("BAC"), any(AsyncCallback.class));
      
      controller.addStock("BAC");

      verify(mockView).setSuccessMessage(anyString());
      verify(mockStockDataService).getData(eq("BAC"), (AsyncCallback<StockData>) anyObject());
      
      verify(mockView).addStock(response);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void setsErrorOnFailure() {
      Mockito.doAnswer(new Answer<StockData>() {

        @SuppressWarnings("rawtypes")
        @Override
        public StockData answer(InvocationOnMock invocation) throws Throwable {
          final Object[] args = invocation.getArguments();
          ((AsyncCallback) args[args.length - 1]).onFailure((Throwable)anyObject());          
          return null;
        }
      }).when(mockStockDataService).getData(eq("BAC"), any(AsyncCallback.class));
      
      controller.addStock("BAC");
      
      verify(mockStockDataService).getData(eq("BAC"), (AsyncCallback<StockData>) anyObject());

      verify(mockView).setErrorMessage(anyString());
    }
}
