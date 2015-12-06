import java.util.Random;

/**
 * Created by neethan on 2015-12-02.
 */

//This class randomly generates the city and sets the city's weather, windspeed and name.
public class RandomCity extends CityGenerator {
    public RandomCity() throws Exception{

        //Creating a random object which will generate the random number.
        Random random = new Random();
        //Creating the list of cities.
        String[] cityList = new String[]{"Toronto", "NewYork", "London", "Paris", "Rome", "Vancouver", "Barcelona", "Madrid", "Vaughan", "Singapore"};


        //creating a random number count which goes from 0 to 9 which is the size of the array.
        int ranNum = random.nextInt((9-0)+1)+0;

        //creating a city object using the datapull function.
        DataPull city1 = new DataPull(cityList[ranNum]);

        //getting the weather,windspeed and name of each city generated.
        setWeather(city1.getTemp());
        setWindSpeed(city1.getWindSpeed());
        setName(cityList[ranNum]);

    }
}
