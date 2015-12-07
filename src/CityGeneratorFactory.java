/**
 * Created by neethan on 2015-12-02.
 */

//This class is the factory class which returns the random city class back.
public class  CityGeneratorFactory {
    public CityGenerator generateCity() throws Exception{

        //return the created random city.
        return new RandomCity();
    }
}
