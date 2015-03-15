package BenchManagementTool;

import Constants.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by tlaw on 12/03/2015.
 */
public class EmployeeController {
    public void goHome(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BenchManagementTool.fxml"));
        Scene scene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
