package org.emint.portfoliosim.server.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HTTPUrlDataReader implements URLDataReader {

  @Override
  public String getData(String url) {
    try {
      URL urlObj = new URL(url);
      URLConnection conn = urlObj.openConnection();
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(conn.getInputStream()));
      
      String resp = "";
      String line;
      
      while ((line = reader.readLine()) != null) {
        resp += line;
      }
      
      return resp;
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

}
