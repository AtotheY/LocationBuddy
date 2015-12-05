/**
 * Created by neethan on 2015-12-02.
 */

//This class generates the weather for the two cities generated.
public abstract class CityGenerator {

    private double temp;
    public double getWeather()
    {
        return temp;
    }

    public void setWeather(double nam)
    {
        temp = nam;
    }

    public void showMessageOne()
    {
        System.out.println("The weather is  "+ getWeather());
    }

}
