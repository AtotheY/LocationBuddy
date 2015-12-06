import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private static String city;
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
        Button comp = new Button ("Get info on city");
        grid.add(comp,6,3);
        Button exit = new Button ("Exit");

        RandomWeatherComparer rand = new RandomWeatherComparer();
        CityInfo cityInfo = new CityInfo();
        Scene scene = new Scene(grid, 700, 700);

        TextField textField = new TextField();
        textField.setPromptText("City Name (no spaces)");
        grid.add(textField,5,3);

        random.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event){
               random.setEffect(shadow);
               redirect(rand);
           }
        });
        final Label error = new Label ("Sorry, invalid input!");
        String errorStyle = "-fx-font: 14 arial; -fx-text-fill: #cc0000;";
        error.setStyle(errorStyle);
        comp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textField.getText();
                grid.getChildren().remove(error);

                if (textField.getText() != null && !(textField.getText().isEmpty()))
                {
                    city = textField.getText();
                    setCity(city);
                    System.out.println ("Sending city: "+ city);
                    redirect(cityInfo);
                }
                else {
                    grid.add(error, 5, 4);
                }
                comp.setEffect(shadow);

            }}
        );
        String exitStyle = "-fx-font: 22 arial; -fx-base: #cc0000;";
        exit.setStyle(exitStyle);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exit.setEffect(shadow);
                System.exit(0);
            }
        });
        grid.add(exit,6,8);

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

    public void setCity(String c)
    {
        city = c;
    }
    public String getCity()
    {
        return city;
    }


}
