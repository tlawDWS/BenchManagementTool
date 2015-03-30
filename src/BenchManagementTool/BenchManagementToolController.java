package BenchManagementTool;

import Constants.*;
import UI.ScreenFlow;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import Models.BenchRecord;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import DAL.DatabaseOperations;

public class BenchManagementToolController implements Initializable {
    public Label helloWorld;
    public Label lblEmployeeHeading;
    public Label lblBenchHours;
    public Label lblBenchActivity;
    public GridPane gpBenchRecords;
    public DatePicker dateStart;
    public DatePicker dateEnd;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dateStart.setValue(LocalDate.now());
        dateEnd.setValue(LocalDate.now());
        try {
            loadBenchRecordsForDisplay();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadBenchRecordsForDisplay() throws SQLException, ClassNotFoundException {
        List<BenchRecord> brL;
        List<Label> labels = new ArrayList<Label>();

        try {
            brL = DatabaseOperations.getBenchRecords();
            for (int i = 0; i < brL.size(); i++)
            {
                labels.add(new Label(brL.get(i).getEmployeeName(brL.get(i).getEmployeeID())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 0, i + 1);

                labels.add(new Label(String.valueOf(brL.get(i).getBenchHours())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 1, i + 1);

                labels.add(new Label(brL.get(i).getBenchActivity()));
                gpBenchRecords.add(labels.get(labels.size() - 1), 2, i + 1);

                labels.add(new Label(String.valueOf(brL.get(i).getRecordDate())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 3, i + 1);
            }
        }
        finally {

        }
    }


    public void sayHelloWorld(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DatabaseOperations.openConnection();
        helloWorld.setText("Let's go home!");
        DatabaseOperations.closeConnection();
    }

    private void initialiseHeadingText() {
        lblEmployeeHeading.setText("Employee");
        lblBenchHours.setText("Bench Hours");
        lblBenchActivity.setText("Bench Activity");
    }

    public void goToEmployees(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        ScreenFlow.goToScene(root, actionEvent);
    }

    public void goHome(ActionEvent actionEvent) {
        helloWorld.setText("Let's go home!");
    }

    public void goToAddBenchRecord(ActionEvent actionEvent) throws IOException {
        //stage.setTitle("Add Bench Record");
        Parent root = FXMLLoader.load(getClass().getResource("AddBenchRecord.fxml"));
        ScreenFlow.goToScene(root, actionEvent);
    }

    public void searchRecordsByDates(ActionEvent actionEvent) {

    }
}
