import java.util.ArrayList;

/**
 * Created by Serban Badea on 12/4/2015.
 */
public class dataGrab implements Updates {

    private ArrayList<Observers> obsList;
    private double winds;
    private double press;
    private long humid;

    public dataGrab(){
        obsList = new ArrayList<Observers>();
    }
    @Override
    public void regObs(Observers newO) {

        obsList.add(newO);
    }

    @Override
    public void deReg(Observers delO) {

        int index = obsList.indexOf(delO);
        obsList.remove(index);
    }

    @Override
    public void notification() {

        for (Observers notify : obsList)
            notify.update(winds, humid, press);
    }

    public double getWinds(){
        return winds;
    }
    public long getHumid(){
        return humid;
    }
    public double getPress(){
        return press;
    }

    public void setWinds(double newWinds) { //Sets new values for wind, pressure, humidity; calls notification
        this.winds = newWinds;              //to let the observers know
        notification();
    }

    public void setHumid(long newHumid) {
        this.humid = newHumid;
        notification();
    }

    public void setPress(double newPress){
        this.press = newPress;
        notification();
    }
}
