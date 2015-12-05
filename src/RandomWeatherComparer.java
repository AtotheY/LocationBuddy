import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by AnthonyS on 12/5/2015.
 */
public class RandomWeatherComparer extends Application{


    public static void main (String args[]) throws Exception
    {
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception {

        Text scenetitle = new Text("Random Weather Comparer!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane grid = new GridPane();
        Button ret = new Button("Return to main menu");
        Main back = new Main();
        Stage secondary = new Stage();
        ret.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    back.start(secondary);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.hide();
            }
        });
        grid.add(ret, 0,1);
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
