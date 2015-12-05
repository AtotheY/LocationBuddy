/**
 * Created by AnthonyS on 11/27/2015.
 */
public class Main {

    public static void main (String args[]) throws Exception
    {
        DataPull tor = new DataPull("Toronto");
        DataPull ny = new DataPull("NewYork");
        double torTemp = tor.getTemp();
        double nyTemp = ny.getTemp();
        String torDesc = tor.getDesc();
        String nyDesc = ny.getDesc();

        dataGrab grab1 = new dataGrab();

        DataObs obs1 = new DataObs(grab1);

        grab1.setWinds(195.00);
        grab1.setHumid(15);
        grab1.setPress(168.00);

        System.out.println ("Toronto temp is: "+ torTemp + "degrees celsius  " + torDesc);
        System.out.println ("New York temp is: "+ nyTemp + "degrees celsius  " + nyDesc);

        if (torTemp > nyTemp)
        {
            System.out.println ("Toronto is hotter today!");
        }
        else
            System.out.println ("New York  is hotter today!");
    }
}
