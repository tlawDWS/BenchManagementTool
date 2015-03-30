package BenchManagementTool;

import DAL.DatabaseOperations;
import Models.Employee;
import UI.ScreenFlow;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by tlaw on 24/03/2015.
 */
public class AddEmployeeController {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtEmail;
    public TextField txtBranch;

    public void goToEmployee(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        ScreenFlow.goToScene(root, actionEvent);
    }

    public void addEmployee(ActionEvent actionEvent) throws IOException {
        Employee emp = new Employee(-1, txtFirstName.getText(), txtLastName.getText(), txtBranch.getText(), txtEmail.getText());
        DatabaseOperations.addEmployee(emp);

        Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        ScreenFlow.goToScene(root, actionEvent);
    }
}
