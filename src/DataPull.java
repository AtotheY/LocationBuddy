/**
 * Created by AnthonyS on 11/27/2015.
 */

import jdk.nashorn.internal.parser.JSONParser;

import java.net.*;
import java.io.*;

public class DataPull {
    private String city = "";

    public DataPull(String q) throws Exception
    {
        city = q;
        apiCall(q);

    }

    private void apiCall (String q) throws Exception
    {
        String temp = "http://api.openweathermap.org/data/2.5/weather?q="+q+"&appid=544a581cc6943eb053b82bab0cdad4f9";
        URL url = new URL(temp);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result


    }
}
