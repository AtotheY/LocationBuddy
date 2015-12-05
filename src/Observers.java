/**
 * Created by Serban Badea on 12/4/2015.
 */
public interface Observers {
    public void update(double windSpeed, long humidity, double pressure);
    //Observer interface, takes in the values we are observing
}
