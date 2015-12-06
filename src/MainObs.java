
/**
 * Created by Serban Badea  on 12/5/2015.
 */
public class MainObs {
    private dataGrab grab1 = new dataGrab();
    private DataObs obs1 = new DataObs(grab1);
    private dataGrab grab2 = new dataGrab();
    private DataObs obs2 = new DataObs(grab2);
    DataPull the6;
    DataPull boston;

    public void runThis() throws Exception {  //Initialize the cities, call all the functions
        the6 = new DataPull("Toronto");
        boston = new DataPull("Boston");
        getValues();
    }


    public void getValues() {           //Sets value of current pressure etc into the observer objects

        grab1.setPress(the6.getPressure());
        grab1.setWinds(the6.getWindSpeed());
        grab1.setHumid(the6.getHumidity());

        grab2.setPress(boston.getPressure());
        grab2.setWinds(boston.getWindSpeed());
        grab2.setHumid(boston.getHumidity());
    }
}