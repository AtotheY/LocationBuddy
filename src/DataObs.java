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

    public DataObs(Updates datGrab){
        this.datGrab = datGrab;
        this.obsId = ++idTrack;
        System.out.println("New Observer" + this.obsId);
        datGrab.regObs(this);
    }

    public void printDat(){

        System.out.println(obsId + "Winds\n" + press + "Pressure\n" + humid + "Humidity");

    }
    @Override
    public void update(double windSpeed, long humidity, double pressure) {
        this.winds = winds;
        this.press = press;
        this.humid = humid;

        printDat();
    }


}
