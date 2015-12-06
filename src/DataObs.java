/**
 * Created by Serban Badea on 12/4/2015.
 */
public class DataObs implements Observers {

    private double winds;
    private double press;
    private long humid;

    private static int idTrack = 0;
    private int obsId;
    private Updates datGrab;


    //Increments observer ID; Creates and initializes object of type Updates for the subject's interface.
    public DataObs(Updates datGrab){
        this.datGrab = datGrab;
        this.obsId = ++idTrack;
        System.out.println("New Observer" + this.obsId);
        datGrab.regObs(this);
    }


    public void printDat(){

        System.out.println(obsId + "\n" + "Wind Speed has been updated to: " +winds + "\nPressure has been updated to: " + press + "Humidity has been updated to: " + humid );

    }
    @Override
    public void update(double windSpeed, long humidity, double pressure) {
        this.winds = windSpeed;
        this.press = pressure;
        this.humid = humidity;

        printDat();
    }


}
