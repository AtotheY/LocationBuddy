/**
 * Created by neethan on 2015-12-02.
 */

//This class is the factory class which returns the RandomCity and RandomCity2 classes back.
public class CityGeneratorFactory {
    public CityGenerator generateCity() throws Exception{

        return new RandomCity();
    }
}
