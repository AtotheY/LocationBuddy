import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by AnthonyS on 11/27/2015.
 */
public class Main extends Application {

    public static void main (String args[]) throws Exception
    {
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception {
        primaryStage.setTitle("LocationBuddy");
        Button btn = new Button();
        DataPull dp = new DataPull("Toronto");
        btn.setText("Press this");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                primaryStage.show();
                btn.setText("The weather in toronto is: " + (int)dp.getTemp());

            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
