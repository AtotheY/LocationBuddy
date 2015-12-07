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
     /**OVERVIEW: A class that pulls live weather data from
    *http://openweathermap.org/api
    *Has getter methods for all pieces of information obtained through json file
    *and http requests. Returns 12 different types of LIVE data, unique to a city
    *REP INVARIANT: !(exists == false)  - for the data to return all the values, the
    * json object must exist (i.e 404 not found error has to be avoided).
    *ABSTRACTION FUNCTION: AF(c) = a city, which has different
    *attributes related to weather. Example: wind speed = c.wind, Temperature = c.temp,    
    *Sunrise Time = c.sunsetDate
    */

    //Instance Variables
    private String city = "";
    private JSONObject json = null;
    private boolean found = true;





    /**
     * A method that returns true if the API succeeded in finding a city in the database, and false if it did not.
     * EFFECTS: Returns true or false depending on state of HTTP request
     * @return  True if the city has successfully been found by the API, False if city not found
     */
    public boolean exists()
    {
        if (found)
            return true;
        else
            return false;
    }

    /**
     * This method was added in due to the fact that for wind speed, wind degree, and all temp returns, the API would return a random combination of Longs+Doubles,
     * longs if the value was whole, double if the value was decimal. This takes that value, checks if it's a long, and converts it to double by adding a decimal point.
     * this actually saves a lot of time debugging a "class exception" error
     * REQUIRES: a JSON object that contains a double, long, or integer wrapped inside of a string.
     * EFFECTS: Returns a double of the value wrapped inside of the JSON Object
     */
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
     * EFFECTS: Returns temperature of city in degrees celsius, gotten from instance JSONObject (double)
     */
    public double getTemp() {
        Object o = (((JSONObject) json.get("main")).get("temp"));
        double temp = toDouble(o);
        return (temp-273.5); }

    /**
     * Used to get a simple description of the weather in the current area
     * @return      description of weather
     * EFFECTS: Returns description of the weather of the city, gotten from instance JSONObject (String)
     */
    public String getDesc(){
        String temp = ((JSONObject)(((JSONArray)(json.get("weather"))).get(0))).get("description").toString();
        return temp;}

    /**
     * Used to get current the air pressure of the city
     * @return      temperature in hectopascals (hPa)
     * EFFECTS: Returns air pressure of city in hPA, gotten from instance JSONObject (double)
     */
    public double getPressure() {
        Object o = ((JSONObject)json.get("main")).get("pressure");
        double temp = toDouble(o);
        return (temp); }

    /**
     * Used to get current humidity in the city
     * @return      percentage of humidity
     * EFFECTS: Returns humidity percentage of city, gotten from instance JSONObject (long)
     */
    public long getHumidity() {
        long temp = (long)((JSONObject)json.get("main")).get("humidity");
        return (temp); }

    /**
     * Used to get max current temperature of city
     * @return      max temp in celsius
     * EFFECTS: Returns max temp of city in degrees celsius, gotten from instance JSONObject (double)
     */
    public double getMaxTemp() {
        Object o = ((JSONObject)json.get("main")).get("temp_max");
        double temp = toDouble(o);
        return (temp-273.5); }

    /**
     * Used to get min current temperature of city
     * @return      min temp in celsius
     * EFFECTS: Returns min temp of city in degrees celsius, gotten from instance JSONObject (double)
     */
    public double getMinTemp() {
        Object o = ((JSONObject)json.get("main")).get("temp_min");
        double temp = toDouble(o);
        return (temp-273.5); }


    /**
     * Used to get atmospheric pressure at sea level
     * @return      sea level pressure, hPa
     * EFFECTS: Returns sea-level air pressure of city in hPA, gotten from instance JSONObject (double)
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
     * EFFECTS: Returns wind-speed of city in m/s, gotten from instance JSONObject (double)
     */
    public double getWindSpeed() {
        Object o = (((JSONObject) json.get("wind")).get("speed"));
        double temp = toDouble(o);
        return temp;
    }

    /**
     * Used to get current wind direction
     * @return      wind direction, degrees
     * EFFECTS: Returns wind-degree of city in degrees, gotten from instance JSONObject (double)
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
     * EFFECTS: Returns percentage of cloudyness in city, gotten from instance JSONObject (long)
     */
    public long getCloudyPercent() {
        long temp = (long)((JSONObject)json.get("clouds")).get("all");
        return (temp); }

    /**
     * Used to get the time of the most recent sunrise
     * @return      sunrise time,date,timezone,ect
     * EFFECTS: Returns next Sunrise Date, gotten from instance JSONObject (String)
     */
    public String getSunriseDate(){
        long temp = (long)((JSONObject)json.get("sys")).get("sunrise");
        return  (new Date(temp*1000)).toString();}

    /**
     * Used to get the time of the most recent sunset
     * @return      sunset time,date,timezone,ect
     * EFFECTS: Returns next Sunset Date, gotten from instance JSONObject (String)
     */
    public String getSunsetDate(){
        long temp = (long)((JSONObject)json.get("sys")).get("sunset");
        return  (new Date(temp*1000)).toString();}


    /**
     * @param q
     * @throws Exception
     * REQUIRES: Requires a string ; the name of a city, no spaces. New York --> NewYork
     * EFFECTS: Passes the string on to the API call function.
     */
    public DataPull(String q) throws Exception
    {
        city = q;
        apiCall(q);
    }

    /**
     * @param q
     * @throws Exception
     * REQUIRES: Requires a string; the name of a city with no spaces. Same as DataPull. Function DOES check for this and returns a System.err.
     * EFFECTS: Takes the string, and makes an api call to openweathermap.org. It then assigns the JSON response to the JSONObject instance variable, json. If city is not found,
     * sets instance variable found to false, so the user can know their call was not successful.
     */
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
