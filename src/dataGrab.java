import java.util.ArrayList;

/**
 * Created by Serban Badea on 12/4/2015.
 */
public class dataGrab implements Updates {

    private ArrayList<Observers> obsList;
    private double winds;
    private double press;
    private long humid;

    @Override
    public void regObs(Observers newO) {

        obsList.add(newO);
    }

    @Override
    public void deReg(Observers delO) {

        int index = obsList.indexOf(delO);
        obsList.remove(delO);
    }

    @Override
    public void notification() {

        for (Observers notify : obsList)
            notify.update(winds, humid, press);
    }


    public void setWinds(double newWinds) {
        this.winds = newWinds;
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
