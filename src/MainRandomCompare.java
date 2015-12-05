import org.json.simple.JSONObject;

/**
 * Created by neethan on 2015-12-05.
 */

//The main class which creates the city objects and will output to the user the city
    //name, city's weather and windspeed.
public class Main {

    public static void main (String args[]) throws Exception {


        ///creating the two city objects
        CityGeneratorFactory factory = new CityGeneratorFactory();
        CityGeneratorFactory factory2 = new CityGeneratorFactory();

        //generating the two cities
        CityGenerator x = factory.generateCity();
        CityGenerator y = factory2.generateCity();

        //instance variables which are equal to their corresponding values.
        double weather1 = x.getWeather();
        double weather2 = y.getWeather();
        double wind1 = x.getWindSpeed();
        double wind2 = y.getWindSpeed();

        //Outputting the information to the user.
        System.out.println("The First randomly generated City is "+ x.getName());
        getInfo(x);

        System.out.println(" ");

        System.out.println("The Second randomly generated City is "+ y.getName());
        getInfo(y);

        //Comparing the weather and windspeed between the two cities.
        if(weather1>weather2)
        {
            System.out.println(x.getName()+"'s temperature is greater than "+ y.getName()
            +"'s temperature");
        }
        else if(weather2>weather1){
            System.out.println(y.getName() + "'s temperature is greater than " + x.getName()
                    + "'s temperature");
        }
        else
        {
            System.out.println("Both cities have the same windspeed");
        }

        if(wind1>wind2)
        {
            System.out.println(x.getName() + "'s windspeed is greater than " + y.getName()
                    + "'s windspeed");
        }
        else if (wind2>wind1)
        {
            System.out.println(y.getName() + "'s windspeed is greater than " + x.getName()
                    + "'s windspeed");
        }
        else

            System.out.println("Both cities have the same windspeed");
    }
    //the method which gets the message that will show the temperature and windspeeds.
    public static void getInfo(CityGenerator city)
    {
        city.showMessageOne();

    }
}
