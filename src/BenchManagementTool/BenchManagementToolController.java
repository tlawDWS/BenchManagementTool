package BenchManagementTool;

import Constants.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import Models.BenchRecord;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BenchManagementToolController implements Initializable {
    public Label helloWorld;
    public Label lblEmployeeHeading;
    public Label lblBenchHours;
    public Label lblBenchActivity;
    public GridPane gpBenchRecords;
    public Label lblEmployeeHeading2;
    public Label lblEmployeeHeading3;
    public Label lblEmployeeHeading4;

    public void goHome(ActionEvent actionEvent) {
        helloWorld.setText("Let's go home!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        loadBenchRecordsForDisplay();
    }

    private void loadBenchRecordsForDisplay() {
        try {
            List<BenchRecord> brL = new ArrayList<BenchRecord>();
            List<Label> labels = new ArrayList<Label>();
            Employee e = new Employee(1, "Tony", "Law", "Sydney");
            BenchRecord br = new BenchRecord(1, (new SimpleDateFormat("yyyyMMdd")).parse("20150302"), 8, "Browsed the web lulz");
            brL.add(br);
            BenchRecord br2 = new BenchRecord(1, (new SimpleDateFormat("yyyyMMdd")).parse("20150303"), 8, "More browsing");
            brL.add(br2);
            BenchRecord br3 = new BenchRecord(1, (new SimpleDateFormat("yyyyMMdd")).parse("20150303"), 8, "Read some books");
            brL.add(br3);

            for (int i = 0; i < brL.size(); i++)
            {
                labels.add(new Label(brL.get(i).getEmployeeName(br.getEmployeeID())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 0, i + 1);

                labels.add(new Label(String.valueOf(brL.get(i).getBenchHours())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 1, i + 1);

                labels.add(new Label(brL.get(i).getBenchActivity()));
                gpBenchRecords.add(labels.get(labels.size() - 1), 2, i + 1);
            }
        }
        catch (ParseException e)
        {

        }
    }

    public void sayHelloWorld(ActionEvent actionEvent)  {

    }

    private void initialiseHeadingText() {
        lblEmployeeHeading.setText("Employee");
        lblBenchHours.setText("Bench Hours");
        lblBenchActivity.setText("Bench Activity");
    }

    public void openEmployees(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        Scene scene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
