import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by AnthonyS on 12/5/2015.
 */
public class RandomWeatherComparer extends MainMenuDirect{

    public void start (Stage primaryStage) throws Exception {


        Text scenetitle = new Text("Random Weather Comparer!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane grid = new GridPane();
        Button ret = new Button("Return to main menu");
        MainRandomCompare randComp = new MainRandomCompare();
        randComp.setup();
        Label name1 = new Label(randComp.city1name());
        name1.setStyle("-fx-font: 22 arial; -fx-text-fill: #4c6b87;");
        Label name2 = new Label(randComp.city2name());
        name2.setStyle("-fx-font: 22 arial; -fx-text-fill: #4c6b87");
        Label temp1 = new Label(randComp.city1temp());
        Label wind1 = new Label(randComp.city1wind());
        Label temp2 = new Label(randComp.city2temp());
        Label wind2 = new Label(randComp.city2wind());
        Label tempComp = new Label(randComp.randTempCompare());
        Label windComp = new Label(randComp.randWindCompare());
        ret.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backToMain(primaryStage);
            }
        });
        grid.add(name1,5,2);
        grid.add(new Label(" "),5,3);
        grid.add(temp1,5,5);
        grid.add(wind1,5,6);
        grid.add(new Label(" "),5,7);
        grid.add(name2,5,8);
        grid.add(new Label(" "),5,9);
        grid.add(temp2,5,10);
        grid.add(wind2,5,11);
        grid.add(new Label(" "),5,12);
        grid.add(tempComp,5,13);
        grid.add(windComp,5,14);
        grid.add(new Label(" "),5,15);
        grid.add(ret, 5,17);

        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
