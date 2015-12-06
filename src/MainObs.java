import org.json.simple.JSONObject;
/**
 * Created by Serban  on 12/5/2015.
 */
public class MainObs {
    private dataGrab grab1 = new dataGrab();
    private DataObs obs1 = new DataObs(grab1);
    private dataGrab grab2 = new dataGrab();
    private DataObs obs2 = new DataObs(grab2);
    private double compPress;
    private double compWind;
    private long compHumid;
    private double compPress1;
    private double compWind1;
    private long compHumid1;
    DataPull the6;
    DataPull boston;

    public void runThis() throws Exception{
        the6 = new DataPull("Toronto");
        boston = new DataPull("Boston");
        initialize();
        checkHumid();
        checkHumid1();
        checkPress();
        checkPress1();
        checkWinds();
        checkWinds1();
    }


    public void initialize(){

        compPress = the6.getPressure();
        compWind = the6.getWindSpeed();
        compHumid = the6.getHumidity();

        compPress1 = boston.getPressure();
        compWind1 = boston.getWindSpeed();
        compHumid1 = boston.getHumidity();
        getValues();
    }

    public void getValues(){

        grab1.setPress(the6.getPressure());
        grab1.setWinds(the6.getWindSpeed());
        grab1.setHumid(the6.getHumidity());

        grab2.setPress(boston.getPressure());
        grab2.setWinds(boston.getWindSpeed());
        grab2.setHumid(boston.getHumidity());
    }
    public void checkPress(){
        if(compPress == the6.getPressure()){
            System.out.println("There has been no change in Pressure in: " + the6);
        }
        else if(compPress != the6.getPressure()){
            System.out.println("The Pressure in " + the6 + " has changed from " + compPress + "to" + the6.getPressure());
        }

    }
    public void checkHumid(){
        if(compHumid == the6.getPressure()){
            System.out.println("There has been no change in Humidity in: " + the6);
        }
        else if(compHumid != the6.getPressure()){
            System.out.println("The Humidity in " + the6 + " has changed from " + compHumid + "to" + the6.getPressure());
        }

    }
    public void checkWinds(){
        if(compWind == the6.getPressure()){
            System.out.println("There has been no change in Wind Speed in: " + the6);
        }
        else if(compWind != the6.getPressure()){
            System.out.println("The Wind Speed in " + the6 + " has changed from " + compWind + "to" + the6.getPressure());
        }

    }

    public void checkPress1(){
        if(compPress1 == boston.getPressure()){
            System.out.println("There has been no change in Pressure in: " + boston);
        }
        else if(compPress1 != boston.getPressure()){
            System.out.println("The Pressure in " + boston + " has changed from " + compPress1 + "to" + boston.getPressure());
        }

    }
    public void checkHumid1(){
        if(compHumid1 == boston.getPressure()){
            System.out.println("There has been no change in Humidity in: " + boston);
        }
        else if(compHumid1 != boston.getPressure()){
            System.out.println("The Humidity in " + boston + " has changed from " + compHumid1 + "to" + boston.getPressure());
        }

    }
    public void checkWinds1(){
        if(compWind1 == boston.getPressure()){
            System.out.println("There has been no change in Wind Speed in: " + boston);
        }
        else if(compWind1 != boston.getPressure()){
            System.out.println("The Wind Speed in " + boston + " has changed from " + compWind1 + "to" + boston.getPressure());
        }

    }

}
