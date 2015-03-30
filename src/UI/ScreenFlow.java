package UI;

import Constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by tlaw on 25/03/2015.
 */
public final class ScreenFlow {
    public static void goToScene(Parent root, ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getTarget()).getScene().getWindow();
        Scene scene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        stage.setScene(scene);
    }
}