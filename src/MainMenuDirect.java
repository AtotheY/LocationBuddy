import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by AnthonyS on 12/5/2015.
 */
public abstract class MainMenuDirect  {
    private Main back = null;

    public void backToMain(Stage stage){
        Stage temp = new Stage();
        back = new Main();
        try {
            back.start(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.hide();
    }
    abstract void start(Stage primaryStage) throws Exception;

}
