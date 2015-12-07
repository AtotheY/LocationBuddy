/**
 * Created by Neethan Surendran on 2015-12-02.


//OVERVIEW: This abstract class will set and get the weather, windspeed and name of each city.
//REP INVARIANT: The values returned are only of type String for the city name and double for windspeed and temperature.
//ABSTRACTION FUNCTION: Represents the current temperature, wind speed and city name.
*/
 public abstract class CityGenerator {

    //instance variables.
    private double temp;
    private String name;
    private double windSpeed;

    /**
     * getter and setter methods.
     * EFFECTS: returns the temperature if this method is invoked.
     */
    public double getWeather()
    {
        return temp;
    }

    /**
     * REQUIRES: a double; the temperature of the city.
     * EFFECTS: create temp to equal to the nam.
     */
    public void setWeather(double nam)
    {
               temp = nam;
    }

    /**
     *
     * EFFECTS: returns the windspeed if this method is invoked.
     */
    public double getWindSpeed()
    {
        return windSpeed;
    }

    /**
     * REQUIRES: a double; the windspeed of the city.
     * EFFECTS: create windSpeed to equal to the speed.
     */
    public void setWindSpeed(double speed)
    {
        windSpeed = speed;
    }

    /**
     *
     * EFFECTS: returns the name of the city if this method is invoked.
     */
        public String getName()
    {
        return name;
    }

    /**
     *
     * REQUIRES: a String; the name of the city.
     *EFFECTS: create name to equal to the n.
     */

    public void setName(String n)
    {

        name = n;
    }

    //will tell the user the corresponding outputs.

}
