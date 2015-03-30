package BenchManagementTool;

import Constants.Constants;
import DAL.DatabaseOperations;
import Models.BenchRecord;
import Models.Employee;
import UI.ScreenFlow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by tlaw on 16/03/2015.
 */
public class AddBenchRecordController implements Initializable {
//    public TextField txtFirstName;
//    public TextField txtLastName;
    public TextField txtBenchActivity;
    public DatePicker dateOnBench;
    public ComboBox cbEmployees;
    private ObservableList<Employee> employees = null;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            employees = FXCollections.observableArrayList(DatabaseOperations.getEmployees());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= employees.size() - 1; i++) {
            cbEmployees.getItems().add(employees.get(i).getFirstName() + " " + employees.get(i).getLastName());
        }
    }

    public void addBenchRecord(ActionEvent actionEvent) throws IOException {
        int selectedComboBoxIndex = cbEmployees.getSelectionModel().getSelectedIndex();
        int employeeID = employees.get(selectedComboBoxIndex).getEmployeeID();
        DatabaseOperations.addBenchRecord(new BenchRecord(employeeID, Date.from(dateOnBench.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), txtBenchActivity.getText()));

        Parent root = FXMLLoader.load(getClass().getResource("BenchManagementTool.fxml"));
        ScreenFlow.goToScene(root, actionEvent);
    }

    public void goHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BenchManagementTool.fxml"));
        ScreenFlow.goToScene(root, actionEvent);
    }

    public void goToAddEmployee(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
            ScreenFlow.goToScene(root, actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
