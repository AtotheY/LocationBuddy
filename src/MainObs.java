import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by Serban Badea  on 12/5/2015.
 */
public class MainObs extends MainMenuDirect {

    private static double iteration = 0.0;
    public void start (Stage primaryStage) throws Exception {
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-image: url('Toronto.jpg')");
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 100, 0, 100));


         // CLASS CODE
        DataPull the6 = new DataPull("Toronto");
        dataGrab grab1 = new dataGrab();
        DataObs obs1 = new DataObs(grab1);

        double wind = the6.getWindSpeed();
        long humid = the6.getHumidity();
        double press = the6.getPressure();

        Random rand = new Random();
        boolean val = rand.nextBoolean();
        boolean val2 = rand.nextBoolean();
        boolean val3 = rand.nextBoolean();


        if (iteration > 0.0)
        {
            if (val)
            {
                wind = wind - (iteration/(iteration + 9.0));
            }
            else
                wind = wind + (iteration/(iteration + 10.0));
            if (val2)
            {
                humid = humid - (long)((iteration+1)/(iteration));
            }
            else
                humid = humid + (long)((iteration+iteration+1)/(iteration+3));
            if (val3)
            {
                press = press - ((iteration + 2)/iteration);
            }
            else
                press = press + ((iteration + 3)/iteration);
        }

        long tempH = obs1.getHumid();
        double tempP = obs1.getPress();
        double tempW = obs1.getWind();
        long tempH2 = tempH;
        tempH = humid - tempH;
        tempP = press - tempP;
        tempW = wind - tempW;

        if (humid > 100)
        {
            humid = 100;
            tempH = humid - tempH2;
        }
        String hchange = String.valueOf(tempH);
        String pchange = String.valueOf(tempP);
        String wchange = String.valueOf(tempW);


        obs1.update(wind,humid,press);
        // CLASS CODE ENDS


        Label h = new Label("Current humidity: "+ humid+"%");
        h.setStyle("-fx-text-fill: #c580ff;");
        Label p = new Label("Current pressure: "+ press+" hPa");
        p.setStyle("-fx-text-fill: #c580ff;");
        Label w = new Label("Current wind speed "+ wind+" m/s");
        w.setStyle("-fx-text-fill: #c580ff;");
        if (iteration > 0) {
            Label hc = new Label("Change in humidity since last visit: " + hchange + "%");
            if (!val2)
                hc.setStyle("-fx-text-fill: #54ff4e;");
            else
                hc.setStyle("-fx-text-fill: #ff3e31;");
            Label pc = new Label("Change in pressure since last visit: " + pchange + " hPa");
            if (!val3)
                pc.setStyle("-fx-text-fill: #54ff4e;");
            else
                pc.setStyle("-fx-text-fill: #ff3e31;");
            Label wc = new Label("Change in wind speed since last visit: " + wchange + " m/s");
            if (!val)
                wc.setStyle("-fx-text-fill: #54ff4e;");
            else
                wc.setStyle("-fx-text-fill: #ff3e31;");
            grid.add(hc,0,3);
            grid.add(pc,0,4);
            grid.add(wc,0,5);
        }
        grid.add(h,0,0);
        grid.add(p,0,1);
        grid.add(w,0,2);
        iteration ++;





        Button ret = new Button("Return to main menu");

        ret.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backToMain(primaryStage);
            }
        });
        grid.add(ret, 5,11);

        Scene scene = new Scene(grid, 1200, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //All you need is in this main method
    //Two cities are created as well as a corresponding Subject for each city.

}