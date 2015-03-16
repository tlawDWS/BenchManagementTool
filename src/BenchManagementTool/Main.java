package BenchManagementTool;

import Constants.Constants;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("BenchManagementTool.fxml"));
        mainScene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);

        primaryStage.setTitle("Bench Management Tool");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
