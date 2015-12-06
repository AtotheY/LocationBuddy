/**
 * Created by Serban Badea on 12/4/2015.
 */
public interface Updates {
    public void regObs(Observers o);
    public void deReg(Observers o);
    public void notification();
    //Subject interface, provides the methods required to add remove and notify observers
}
