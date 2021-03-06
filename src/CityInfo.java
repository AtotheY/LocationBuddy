import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by AnthonyS on 12/5/2015.
 */
public class CityInfo  extends MainMenuDirect{

    public void start (Stage primaryStage) throws Exception {
        Text scenetitle = new Text("City Info");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane grid = new GridPane();
        Button ret = new Button("Return to main menu");
        ret.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backToMain(primaryStage);
            }
        });

        // 12 items
        final ToggleGroup group = new ToggleGroup();

        ToggleButton cloud = new ToggleButton("Cloudy Percentage");
        cloud.setToggleGroup(group);
        cloud.setStyle("-fx-base: #66c8ff;");

        ToggleButton desc = new ToggleButton("Weather Description");
        //desc.setSelected(true);
        desc.setToggleGroup(group);
        desc.setStyle("-fx-base: #ffedf0;");

        ToggleButton humid = new ToggleButton("Humidity Percentage");
        humid.setToggleGroup(group);
        humid.setStyle("-fx-base: #ffb88d;");

        ToggleButton maxtemp = new ToggleButton("Max Temperature");
        maxtemp.setToggleGroup(group);
        maxtemp.setStyle("-fx-base: #ff4034;");

        ToggleButton mintemp = new ToggleButton("Min Temperature");
        mintemp.setToggleGroup(group);
        mintemp.setStyle("-fx-base: #4d6cff;");

        ToggleButton pressure = new ToggleButton("Air Pressure");
        pressure.setToggleGroup(group);
        pressure.setStyle("-fx-base: #47ffda;");

        ToggleButton sealev = new ToggleButton("Sea Level Pressure");
        sealev.setToggleGroup(group);
        sealev.setStyle("-fx-base: #474cff;");

        ToggleButton sunr = new ToggleButton("Sunrise Date");
        sunr.setToggleGroup(group);
        sunr.setStyle("-fx-base: #e8ff60;");

        ToggleButton suns = new ToggleButton("Sunset Date");
        suns.setToggleGroup(group);
        suns.setStyle("-fx-base: #ff7a45;");

        ToggleButton avgtemp = new ToggleButton("Average Temperature");
        avgtemp.setToggleGroup(group);
        avgtemp.setStyle("-fx-base: #c6a1ff;");

        ToggleButton windd = new ToggleButton("Wind Degree");
        windd.setToggleGroup(group);
        windd.setStyle("-fx-base: #b4ff7c;");

        ToggleButton winds = new ToggleButton("Wind Speed");
        winds.setToggleGroup(group);
        winds.setStyle("-fx-base: #7dffb2;");

        grid.add(desc,1,2);
        grid.add(maxtemp,1,3);
        grid.add(mintemp,1,4);
        grid.add(avgtemp,1,5);
        grid.add(humid,1,6);
        grid.add(cloud,1,7);
        grid.add(pressure,1,8);
        grid.add(sealev,1,9);
        grid.add(winds,1,10);
        grid.add(windd,1,11);
        grid.add(sunr,1,12);
        grid.add(suns,1,13);
        grid.add(new Label(" "),1,14);
        grid.add(ret,1,15);
        Main main2 = new Main();
        String name2 = main2.getCity();
        Label name1 = new Label(name2);
        name1.setStyle("-fx-font: 22 arial; -fx-text-fill: #527ecf;");
        grid.add (name1,1,0);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                try {
                    Main main = new Main();
                    String name = main.getCity();
                    DataPull tor = new DataPull(name);

                    Label out = null;

                    if (group.getSelectedToggle() == cloud) {
                        out = new Label(name+"'s cloudy percentage is: " + Long.toString(tor.getCloudyPercent()) + "%");
                        out.setStyle("-fx-text-fill: #66c8ff;");
                        grid.add(out, 2, 7);}
                    else if (group.getSelectedToggle() == desc) {
                        out = new Label(name+"'s weather is: " + tor.getDesc());
                        out.setStyle("-fx-text-fill: #ffedf0;");
                        grid.add(out, 2, 2);}
                    else if (group.getSelectedToggle() == maxtemp) {
                        out = new Label(name+"'s max temp today is: " + Double.toString(tor.getMaxTemp()) + " degrees celcius");
                        out.setStyle("-fx-text-fill: #ff4034;");
                        grid.add(out, 2, 3);}
                    else if (group.getSelectedToggle() == mintemp) {
                        out = new Label(name+"'s min temp today is: " + Double.toString(tor.getMinTemp()) + " degrees celcius");
                        out.setStyle("-fx-text-fill: #4d6cff;");
                        grid.add(out, 2, 4);}
                    else if (group.getSelectedToggle() == avgtemp) {
                        out = new Label(name+"'s average temp today is: " + Double.toString(tor.getTemp()) + " degrees celcius");
                        out.setStyle("-fx-text-fill: #c6a1ff;");
                        grid.add(out, 2, 5);}
                    else if (group.getSelectedToggle() == humid) {
                        out = new Label(name+"'s humidity percentage is : " + Double.toString(tor.getHumidity()) + "%");
                        out.setStyle("-fx-text-fill: #ffb88d;");
                        grid.add(out, 2, 6);}
                    else if (group.getSelectedToggle() == sealev) {
                        out = new Label(name+"'s Sea Level Pressure is : " + Double.toString(tor.getSeaLevel()) + "hPa");
                        out.setStyle("-fx-text-fill: #474cff;");
                        grid.add(out, 2, 9);}
                    else if (group.getSelectedToggle() == pressure) {
                            out = new Label(name+"'s Air Pressure is : " + Double.toString(tor.getPressure()) + " hPa");
                        out.setStyle("-fx-text-fill: #47ffda;");
                            grid.add(out, 2, 8);}
                    else if (group.getSelectedToggle() == windd) {
                        out = new Label(name+"'s Wind Degree is : " + Double.toString(tor.getWindDegree()) + " degrees");
                        out.setStyle("-fx-text-fill: #b4ff7c;");
                        grid.add(out, 2, 11);}
                    else if (group.getSelectedToggle() == winds) {
                        out = new Label(name+"'s Wind Speed is : " + Double.toString(tor.getWindSpeed()) + " m/s");
                        out.setStyle("-fx-text-fill: #7dffb2;");
                        grid.add(out, 2, 10);}
                    else if (group.getSelectedToggle() == sunr) {
                        out = new Label(name+"'s next sunrise is : " + tor.getSunriseDate());
                        out.setStyle("-fx-text-fill: #e8ff60;");
                        grid.add(out, 2, 12);}
                    else if (group.getSelectedToggle() == suns) {
                        out = new Label(name+"'s next sunset is : " + tor.getSunsetDate());
                        out.setStyle("-fx-text-fill: #ff7a45;");
                        grid.add(out, 2, 13);}
                    else
                        out = new Label("Please make a selection!");
                } catch (Exception e){e.printStackTrace();}


            }
        });
        grid.setStyle("-fx-background-image: url('Toronto.jpg')");
        Scene scene = new Scene(grid, 1200, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
