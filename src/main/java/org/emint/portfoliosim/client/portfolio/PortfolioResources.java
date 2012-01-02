package org.emint.portfoliosim.client.portfolio;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface PortfolioResources extends ClientBundle {
  public static final PortfolioResources INSTANCE = GWT.create(PortfolioResources.class);
  
  @Source("Portfolio.css")
  @CssResource.NotStrict
  CssResource css();
}
