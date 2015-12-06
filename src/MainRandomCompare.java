import org.json.simple.JSONObject;

/**
 * Created by neethan on 2015-12-05.
 */

//This main class for comparing two random cities will create the city objects and will output to the user the city
//name, city's weather and windspeed.It will also compare them and show the comparison to the user.

public class MainRandomCompare {


    //creating the two city objects from the factory class.
    private CityGeneratorFactory factory = null;
    private CityGeneratorFactory factory2 = null;

    //creating the two city generator objects to get the statistics of each city, one being x and one being y.
    private CityGenerator x = null;
    private CityGenerator y = null;

    //instance variables.
    private double weather1 = 0;
    private double weather2 = 0;
    private double wind1 = 0;
    private double wind2 = 0;

    //the method will setup and form the cities and their characteristics and store them in their
    //corresponding variables.
    public void setup() throws Exception{
        //Generating cities.
        factory = new CityGeneratorFactory();
        factory2 = new CityGeneratorFactory();
        //Generating city statistics.
        x = factory.generateCity();
        y = factory2.generateCity();

        //this loop is created to avoid duplicating city names(to not get both cities to have the same name).
        while (y.getName().equals(x.getName()))
        {
            //randomly generate another city.
            y = factory2.generateCity();
        }

        //instance variables which are equal to their corresponding values.
        weather1 = x.getWeather();
        weather2 = y.getWeather();
        wind1 = x.getWindSpeed();
        wind2 = y.getWindSpeed();
    }

    //these are the outputs which the user will see.
    //each output is placed in a method because it is easier to call these methods in javafx.
    //the 3 methods below will return the first city's name,weather and windspeed.
    public String city1name () {
       return(x.getName());}

    public String city1temp () {
        return("The weather is  "+ x.getWeather()+ " degrees celsius");}

    public String city1wind () {
        return ("The windspeed is " + x.getWindSpeed()+" m/s");}

    //the 3 methods below will return the second city's name,weather and windspeed.
    public String city2name () {
        return(y.getName());}

    public String city2temp () {
        return("The weather is  "+ y.getWeather()+ " degrees celsius");}

    public String city2wind () {
        return ("The windspeed is " + y.getWindSpeed()+" m/s");}

    //this method will compare the two temperatures of the cities generated and return it.
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

    //this method will compare the two windspeeds of the cities generated and return it.
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
