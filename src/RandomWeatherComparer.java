import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        Label name1 = new Label("City: "+randComp.city1name());
        name1.setStyle("-fx-font: 22 arial; -fx-text-fill: #358766;");
        Label name2 = new Label("City: "+randComp.city2name());
        name2.setStyle("-fx-font: 22 arial; -fx-text-fill: #358766");
        Label temp1 = new Label(randComp.city1temp());
        temp1.setStyle("-fx-text-fill: #6a9cdf;");
        Label wind1 = new Label(randComp.city1wind());
        wind1.setStyle("-fx-text-fill: #6a9cdf;");
        Label temp2 = new Label(randComp.city2temp());
        temp2.setStyle("-fx-text-fill: #6a9cdf;");
        Label wind2 = new Label(randComp.city2wind());
        wind2.setStyle("-fx-text-fill: #6a9cdf;");
        Label tempComp = new Label(randComp.randTempCompare());
        tempComp.setStyle("-fx-text-fill: #dfdd9f;");
        Label windComp = new Label(randComp.randWindCompare());
        windComp.setStyle("-fx-text-fill: #dfdd9f;");
        ret.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                backToMain(primaryStage);
            }
        });
        String url1 = randComp.city1name()+".jpg";
        String url2 = randComp.city2name()+".jpg";
        System.out.println (url1);
        System.out.println (url2);
        Image image1 = new Image(Main.class.getResourceAsStream(url1));
        Image image2 = new Image(Main.class.getResourceAsStream(url2));
        ImageView pic1 = new ImageView();
        ImageView pic2 = new ImageView();
        pic1.setFitWidth(130);
        pic2.setFitWidth(130);
        pic2.setFitHeight(130);
        pic1.setFitHeight(130);
        pic1.setImage(image1);
        pic2.setImage(image2);
        grid.setStyle("-fx-background-image: url('Toronto.jpg')");

        grid.add(name1,5,2);
        grid.add(pic1,6,2);
        grid.add(temp1,5,3);
        grid.add(wind1,5,4);

        grid.add(new Label("                                                        "),9,2);
        grid.add(name2,10,2);
        grid.add(pic2,11,2);
        grid.add(temp2,10,3);
        grid.add(wind2,10,4);

        grid.add(new Label("                                             "),5,5);
        grid.add(new Label("                                             "),5,6);
        grid.add(new Label("                                             "),5,7);
        grid.add(tempComp,5,8);
        grid.add(windComp,5,9);
        grid.add(new Label("                                             "),5,10);
        grid.add(ret, 5,11);

        Scene scene = new Scene(grid, 1200, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
