import java.util.Random;

/**
 * Created by neethan on 2015-12-05.
 */
public class RandomCity2  extends CityGenerator {
    public RandomCity2() throws Exception{


        Random random1 = new Random();
        String[] cityList = new String[]{"Toronto", "NewYork", "London", "Paris", "Rome", "Vancouver", "Barcelona", "Madrid", "Dubai", "Singapore"};


        int ranNum2 = random1.nextInt((10-0)+1)+0;
        System.out.println("The City is "+ cityList[ranNum2]);
        DataPull city2 = new DataPull(cityList[ranNum2]);

        setWeather(city2.getTemp());
    }
}
