import java.util.Random;

/**
 * Created by neethan on 2015-12-02.
 */

//This class creates the first randomly generated city and returns that cities weather.
public class RandomCity extends CityGenerator {
    public RandomCity() throws Exception{

        Random random = new Random();
        String[] cityList2 = new String[]{"Toronto", "NewYork", "London", "Paris", "Rome", "Vancouver", "Barcelona", "Madrid", "Dubai", "Singapore"};


        int ranNum = random.nextInt((10-0)+1)+0;
        System.out.println("The City is "+ cityList2[ranNum]);
        DataPull city1 = new DataPull(cityList2[ranNum]);

        setWeather(city1.getTemp());

    }
}
