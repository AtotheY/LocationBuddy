/**
 * Created by AnthonyS on 11/27/2015.
 */
public class Main {

    public static void main (String args[]) throws Exception
    {
        DataPull test = new DataPull("toronto");
        System.out.println (test.getCloudyPercent() + " " + test.getHumidity()+ " " + test.getMaxTemp()+ " " + test.getMinTemp()+ " " + test.getPressure()+ " " + test.getSeaLevel()
                + " " + test.getTemp()+ " " + test.getWindDegree()+ " " + test.getWindSpeed()+ " " + test.getDesc()+ " " + test.getSunriseDate()+ " " + test.getSunsetDate());
    }

}
