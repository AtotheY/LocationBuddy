/**
 * Created by AnthonyS on 11/27/2015.
 */


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.io.*;
import java.util.Date;

public class DataPull {
    private String city = "";
    private JSONObject json = null;
    // WEATHER JSON OBJECT EXAMPLE
    //{"coord":{"lon":-0.13,"lat":51.51},"weather":[{"id":800,"main":"Clear","description":"Sky is Clear","icon":"01n"}],"base":"cmc stations","main":
    //{"temp":276.875,"pressure":1014.64,"humidity":91,"temp_min":276.875,"temp_max":276.875,"sea_level":1025.06,"grnd_level":1014.64},"wind":{"speed":5.96,"deg":281.008},"clouds":{
    //"all":0},"dt":1448681671,"sys":{"message":0.0122,"country":"GB","sunrise":1448696351,"sunset":1448726235},"id":2643743,"name":"London","cod":200}
    public double getTemp() {
        double temp = (double)((JSONObject)json.get("main")).get("temp");
        return (temp-273.5); }
    public String getDesc(){
        String temp = ((JSONObject)(((JSONArray)(json.get("weather"))).get(0))).get("description").toString();
        return temp;}
    public double getPressure() {
        double temp = (double)((JSONObject)json.get("main")).get("pressure");
        return (temp); }
    public long getHumidity() {
        long temp = (long)((JSONObject)json.get("main")).get("humidity");
        return (temp); }
    public double getMaxTemp() {
        double temp = (double)((JSONObject)json.get("main")).get("temp_max");
        return (temp-273.5); }
    public double getMinTemp() {
        double temp = (double)((JSONObject)json.get("main")).get("temp_min");
        return (temp-273.5); }
    public double getSeaLevel() {
        double temp = (double)((JSONObject)json.get("main")).get("sea_level");
        return (temp);}
    public double getWindSpeed() {
        double temp = (double)((JSONObject)json.get("wind")).get("speed");
        return (temp); }
    public double getWindDegree() {
        double temp = (double)((JSONObject)json.get("wind")).get("deg");
        return (temp); }
    public long getCloudyPercent() {
        long temp = (long)((JSONObject)json.get("clouds")).get("all");
        return (temp); }
    public String getSunriseDate(){
        long temp = (long)((JSONObject)json.get("sys")).get("sunrise");
        return  (new Date(temp*1000)).toString();}
    public String getSunsetDate(){
        long temp = (long)((JSONObject)json.get("sys")).get("sunset");
        return  (new Date(temp*1000)).toString();}



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
        Object test = conn.getInputStream();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        String s=response.toString();
        JSONObject jsonTemp = (JSONObject) new JSONParser().parse(s);
        json = jsonTemp;
    }
}
