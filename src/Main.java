
/**
 * Created by Serban Badea  on 12/5/2015.
 */
public class Main {

    public static void main (String args[]) throws Exception{
        DataPull the6 = new DataPull("Toronto");
        DataPull boston = new DataPull("Boston");
        dataGrab grab1 = new dataGrab();
        DataObs obs1 = new DataObs(grab1);
        dataGrab grab2 = new dataGrab();
        DataObs obs2 = new DataObs(grab2);

        
        grab1.setWinds(the6.getWindSpeed());
        grab1.setHumid(the6.getHumidity());


        grab2.setWinds(boston.getWindSpeed());
        grab2.setHumid(boston.getHumidity());
    }
}