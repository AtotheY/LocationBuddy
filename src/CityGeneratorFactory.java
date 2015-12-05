/**
 * Created by neethan on 2015-12-02.
 */

public class CityGeneratorFactory {
    public CityGenerator generateCity() throws Exception{

        return new RandomCity();
    }
}
