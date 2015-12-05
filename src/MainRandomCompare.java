import org.json.simple.JSONObject;

/**
 * Created by neethan on 2015-12-05.
 */

//The main class which creates the city objects and will output to the user the city
//name, city's weather and windspeed.

public class MainRandomCompare {
    private CityGeneratorFactory factory = null;
    private CityGeneratorFactory factory2 = null;
    private CityGenerator x = null;
    private CityGenerator y = null;
    private double weather1 = 0;
    private double weather2 = 0;
    private double wind1 = 0;
    private double wind2 = 0;

    public void setup() throws Exception{
        //Generating cities
        factory = new CityGeneratorFactory();
        factory2 = new CityGeneratorFactory();
        x = factory.generateCity();
        y = factory2.generateCity();

        //instance variables which are equal to their corresponding values.
        weather1 = x.getWeather();
        weather2 = y.getWeather();
        wind1 = x.getWindSpeed();
        wind2 = y.getWindSpeed();
    }

    public String city1name () {
       return("City: "+x.getName());}

    public String city1temp () {
        return("The weather is  "+ x.getWeather()+ " degrees celsius");}

    public String city1wind () {
        return ("The windspeed is " + x.getWindSpeed()+" m/s");}

    public String city2name () {
        return("City: "+y.getName());}

    public String city2temp () {
        return("The weather is  "+ y.getWeather()+ " degrees celsius");}

    public String city2wind () {
        return ("The windspeed is " + y.getWindSpeed()+" m/s");}

    public String randTempCompare()
    {
        if(weather1>weather2)
        {
           return(x.getName()+"'s temperature is greater than "+ y.getName()
                    +"'s temperature");
        }
        else if(weather2>weather1){
            return(y.getName() + "'s temperature is greater than " + x.getName()
                    + "'s temperature");
        }
        else
        {
            return("Both cities have the same temperature");
        }
    }

    public String randWindCompare()
    {
        if(wind1>wind2)
        {
            return(x.getName() + "'s windspeed is greater than " + y.getName()
                    + "'s windspeed");
        }
        else if (wind2>wind1)
        {
            return(y.getName() + "'s windspeed is greater than " + x.getName()
                    + "'s windspeed");
        }
        else
            return("Both cities have the same windspeed");
    }
}
