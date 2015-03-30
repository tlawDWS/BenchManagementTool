package BenchManagementTool;

import DAL.DatabaseOperations;
import Models.BenchRecord;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Constants.Constants;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by tlaw on 12/03/2015.
 */
public class EmployeeController implements Initializable {
    public GridPane gpEmployeeHeading;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblBranch;
    public Label lblEmail;
    public Button btnAddEmployee;
    public GridPane gpEmployees;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadActiveEmployees();
    }

    private void loadActiveEmployees() {
        List<Employee> empList = new ArrayList<Employee>();
        List<Label> labels = new ArrayList<Label>();

        try {
            empList = DatabaseOperations.getEmployees();

            for (int i = 0; i < empList.size(); i++)
            {
                labels.add(new Label(empList.get(i).getFirstName()));
                gpEmployeeHeading.add(labels.get(labels.size() - 1), 0, i + 1);

                labels.add(new Label(empList.get(i).getLastName()));
                gpEmployeeHeading.add(labels.get(labels.size() - 1), 1, i + 1);

                labels.add(new Label(empList.get(i).getEmail()));
                gpEmployeeHeading.add(labels.get(labels.size() - 1), 2, i + 1);

                labels.add(new Label(empList.get(i).getBranch()));
                gpEmployeeHeading.add(labels.get(labels.size() - 1), 3, i + 1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
