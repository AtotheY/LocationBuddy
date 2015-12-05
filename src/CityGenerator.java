/**
 * Created by neethan on 2015-12-02.
 */
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
