package BenchManagementTool;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Constants.Constants;
import java.io.IOException;

/**
 * Created by tlaw on 12/03/2015.
 */
public class EmployeeController {
    public GridPane gpEmployeeHeading;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblBranch;
    public Label lblEmail;
    public Button btnAddEmployee;

    public void goHome(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BenchManagementTool.fxml"));
        Scene scene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        stage.setScene(scene);
    }

    public void goToAddEmployee(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        Scene scene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        stage.setScene(scene);
    }
}
