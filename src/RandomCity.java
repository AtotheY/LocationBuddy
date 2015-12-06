import java.util.Random;

/**
 * Created by neethan on 2015-12-02.
 */

//This class creates the first randomly generated city and returns that cities weather.
public class RandomCity extends CityGenerator {
    public RandomCity() throws Exception{

        //Creating a random object which will generate the random number.
        Random random = new Random();
        //Creating the list of cities.
        String[] cityList = new String[]{"Toronto", "NewYork", "London", "Paris", "Rome", "Vancouver", "Barcelona", "Madrid", "Vaughan", "Singapore"};
              //if more cities need to be added: + "Amsterdam"+ "Athens"+"Brussels"+"Milan"+"Beijing"};

        //creating a random number count which goes from 0 to 14 which is the size of the array.
        int ranNum = random.nextInt((9-0)+1)+0;

        //creating a city object using the datapull function.
        DataPull city1 = new DataPull(cityList[ranNum]);

        //getting the weather,windspeed and name of each city generated.
        setWeather(city1.getTemp());
        setWindSpeed(city1.getWindSpeed());
        setName(cityList[ranNum]);

    }
}
