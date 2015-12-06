import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by AnthonyS on 11/27/2015.
 * @author Anthony Sistilli sistillianthony@gmail.com
 * @version 1.2
 * @since 2015-11-27
 */
public class DataPull {
    private String city = "";
    private JSONObject json = null;
    private boolean found = true;
    // WEATHER JSON OBJECT EXAMPLE
    //{"coord":{"lon":-0.13,"lat":51.51},"weather":[{"id":800,"main":"Clear","description":"Sky is Clear","icon":"01n"}],"base":"cmc stations","main":
    //{"temp":276.875,"pressure":1014.64,"humidity":91,"temp_min":276.875,"temp_max":276.875,"sea_level":1025.06,"grnd_level":1014.64},"wind":{"speed":5.96,"deg":281.008},"clouds":{
    //"all":0},"dt":1448681671,"sys":{"message":0.0122,"country":"GB","sunrise":1448696351,"sunset":1448726235},"id":2643743,"name":"London","cod":200}

    // this method was added in due to the fact that for wind speed, wind degree, and all temp returns, the API would return a random combination of Longs+Doubles,
    // longs if the value was whole, double if the value was decimal. This takes that value, checks if it's a long, and converts it to double by adding a decimal point.
    // this actually saves a lot of time debugging a "class exception" error T_T....
    public boolean exists()
    {
        if (found)
            return true;
        else
            return false;
    }

    private double toDouble(Object o)
    {
        String tempO = o.toString();
        double temp;
        if (tempO.contains(".")) {
            temp = Double.parseDouble(tempO);
            return (temp);
        } else{
            tempO = tempO + ".0";
            temp = Double.parseDouble(tempO);
            return temp;
        }
    }
    /**
     * Used to get the current temperature of city
     * @return      temperature of city in celsius
     */
    public double getTemp() {
        Object o = (((JSONObject) json.get("main")).get("temp"));
        double temp = toDouble(o);
        return (temp-273.5); }
    /**
     * Used to get a simple description of the weather in the current area
     * @return      description of weather
     */
    public String getDesc(){
        String temp = ((JSONObject)(((JSONArray)(json.get("weather"))).get(0))).get("description").toString();
        return temp;}
    /**
     * Used to get current the air pressure of the city
     * @return      temperature in hectopascals (hPa)
     */
    public double getPressure() {
        Object o = ((JSONObject)json.get("main")).get("pressure");
        double temp = toDouble(o);
        return (temp); }
    /**
     * Used to get current humidity in the city
     * @return      percentage of humidity
     */
    public long getHumidity() {
        long temp = (long)((JSONObject)json.get("main")).get("humidity");
        return (temp); }
    /**
     * Used to get max current temperature of city
     * @return      max temp in celsius
     */
    public double getMaxTemp() {
        Object o = ((JSONObject)json.get("main")).get("temp_max");
        double temp = toDouble(o);
        return (temp-273.5); }
    /**
     * Used to get min current temperature of city
     * @return      min temp in celsius
     */
    public double getMinTemp() {
        Object o = ((JSONObject)json.get("main")).get("temp_min");
        double temp = toDouble(o);
        return (temp-273.5); }
    /**
     * Used to get atmospheric pressure at sea level
     * @return      sea level pressure, hPa
     */
    public double getSeaLevel() {
        double temp;
        try {
            Object o = ((JSONObject)json.get("main")).get("sea_level");
            temp = toDouble(o);
        }catch (NullPointerException e)
        {
            temp = 0;
        }
        return(temp);}
    /**
     * Used to get current wind speed of city
     * @return      wind speed, meter/second
     */
    public double getWindSpeed() {
        Object o = (((JSONObject) json.get("wind")).get("speed"));
        double temp = toDouble(o);
        return temp;
    }
    /**
     * Used to get current wind direction
     * @return      wind direction, degrees
     */
    public double getWindDegree() {
        double temp;
        try {
            Object o = ((JSONObject) json.get("wind")).get("deg");
            temp = toDouble(o);
        }catch (NullPointerException e)
        {
            temp = 0;
        }
            return(temp);}
    /**
     * Used to get cloudiness percentage
     * @return      cloudiness percentage
     */
    public long getCloudyPercent() {
        long temp = (long)((JSONObject)json.get("clouds")).get("all");
        return (temp); }
    /**
     * Used to get the time of the most recent sunrise
     * @return      sunrise time,date,timezone,ect
     */
    public String getSunriseDate(){
        long temp = (long)((JSONObject)json.get("sys")).get("sunrise");
        return  (new Date(temp*1000)).toString();}
    /**
     * Used to get the time of the most recent sunset
     * @return      sunset time,date,timezone,ect
     */
    public String getSunsetDate(){
        long temp = (long)((JSONObject)json.get("sys")).get("sunset");
        return  (new Date(temp*1000)).toString();}



    public DataPull(String q) throws Exception
    {
        city = q;
        apiCall(q);
    }

    private void apiCall (String q) throws Exception {
        if (q.contains(" ")) {
            System.err.println("Name can not contain spaces!");
            found = false;
            return;
        }

        String temp = "http://api.openweathermap.org/data/2.5/weather?q=" + q + "&appid=544a581cc6943eb053b82bab0cdad4f9";
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
        String s = response.toString();
        JSONObject jsonTemp = (JSONObject) new JSONParser().parse(s);
        json = jsonTemp;
        String o = json.toString();
        if (o.contains("Not found city"))
        {
            found = false;
        }
    }
}
