package BenchManagementTool;

import javafx.fxml.Initializable;
import Models.BenchRecord;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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

    public void goHome(ActionEvent actionEvent) {
        helloWorld.setText("Let's go home!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        loadBenchRecordsForDisplay();
        //initialiseHeadingText();
//        Label lbl1 = new Label("Label 1");
//        gridPane.add(lbl1, 1, 4);
//        Label lbl2 = new Label("Label 2");
//        gridPane.add(lbl2, 1, 5);
        //helloWorld.setText(br.getBenchActivity());
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

            //Label lbl1 = new Label();

            for (int i = 0; i < brL.size(); i++)
            {
                labels.add(new Label(brL.get(i).getEmployeeName(br.getEmployeeID())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 0, i + 1);

                labels.add(new Label(String.valueOf(brL.get(i).getBenchHours())));
                gpBenchRecords.add(labels.get(labels.size() - 1), 1, i + 1);

                labels.add(new Label(brL.get(i).getBenchActivity()));
                gpBenchRecords.add(labels.get(labels.size() - 1), 2, i + 1);
            }


            //gpBenchRecords.add(lbl1, 2, 1);
        }
        catch (ParseException e)
        {

        }
    }

    public void sayHelloWorld(ActionEvent actionEvent) throws ParseException
    {

    }

    private void initialiseHeadingText() {
        lblEmployeeHeading.setText("Employee");
        lblBenchHours.setText("Bench Hours");
        lblBenchActivity.setText("Bench Activity");
    }
}
