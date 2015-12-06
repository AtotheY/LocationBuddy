/**
 * Created by neethan on 2015-12-02.
 */
//This abstract class will set and get the weather, windspeed and name of the city.
public abstract class CityGenerator {

    //instance variables.
    private double temp;
    private String name;
    private long windSpeed;

    //getter and setter methods.
    public double getWeather()
    {
        return temp;
    }

    public void setWeather(double nam)
    {
        temp = nam;
    }
    public double getWindSpeed()
    {
        return windSpeed;
    }

    public void setWindSpeed(long speed)
    {
        windSpeed = speed;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }

    //will tell the user the corresponding outputs.

}
