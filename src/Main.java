import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.ExecutionException;

import static javafx.application.Application.launch;

/**
 * Created by AnthonyS on 11/27/2015.
 */
public class Main extends Application {
    private Stage primaryStage = null;
    public static void main (String args[]) throws Exception
    {
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 100, 0, 100));

        DropShadow shadow = new DropShadow();
        Button random =  new Button ("Compare two random cities");
        grid.add(random,6,1);
        Button comp = new Button ("Get info on a city");
        grid.add(comp,6,3);
        Button exit = new Button ("Exit");
        grid.add(exit,6,7);

        RandomWeatherComparer rand = new RandomWeatherComparer();
        CityInfo cityInfo = new CityInfo();
        Scene scene = new Scene(grid, 500, 500);
        random.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event){
               random.setEffect(shadow);
               redirect(rand);
           }
        });
        comp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comp.setEffect(shadow);
                redirect(cityInfo);
            }}
        );
        exit.setStyle("-fx-font: 22 arial; -fx-base: #cc0000;");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exit.setEffect(shadow);
                System.exit(0);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void redirect (MainMenuDirect o)
    {
        Stage newStage = new Stage();
        try {
            o.start(newStage);
            primaryStage.hide();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
