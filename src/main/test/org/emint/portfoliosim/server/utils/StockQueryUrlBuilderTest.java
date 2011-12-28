package org.emint.portfoliosim.server.utils;

import static org.junit.Assert.*;

import org.junit.Test;


public class StockQueryUrlBuilderTest {

  private static final String SYM2 = "sym2";
  private static final String SYM1 = "sym";
  
  StockQueryUrlBuilder builder = new StockQueryUrlBuilder();
  String base = "http://finance.yahoo.com/d/quotes.csv?";
  String format = "snb3";
  @Test
  public void builderAddsOneStock() {
    builder.addSymbol(SYM1);
    builder.addFormatParams(format);
    assertEquals(base+"s="+SYM1+"&f="+format, builder.getUrl());
  }
  
  @Test
  public void builderAddsTwoStock() {
    builder.addSymbol(SYM1);
    builder.addSymbol(SYM2);
    builder.addFormatParams(format);
    assertEquals(base+"s="+SYM1+"+"+SYM2+"&f=snb3", builder.getUrl());
  }
  
  @Test
  public void builderAddsFormatParams() {
    builder.addSymbol(SYM1);
    builder.addFormatParams(format);
    builder.addFormatParams("c");
    assertEquals(base+"s="+SYM1+"&f="+format+"c", builder.getUrl());
  }
}
