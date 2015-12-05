import org.json.simple.JSONObject;

/**
 * Created by neethan on 2015-12-05.
 */

public class Main {

    public static void main (String args[]) throws Exception {


        CityGenerator x = null;
        CityGeneratorFactory factory = new CityGeneratorFactory();

        x = factory.generateCity();
        getInfo(x);


    }

    public static void getInfo(CityGenerator city)
    {
        city.showMessageOne();

    }
}
