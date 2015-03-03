package BenchManagementTool;

import Models.BenchRecord;
import Models.Employee;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BenchManagementToolController {
    public Label helloWorld;
    public Label lblEmployeeHeading;
    public Label lblBenchHours;
    public Label lblBenchActivity;

    public void goHome(ActionEvent actionEvent) {
        helloWorld.setText("Let's go home!");
    }

    public void sayHelloWorld(ActionEvent actionEvent) throws ParseException {
        Employee e = new Employee("Tony", "Law", "Sydney");
        BenchRecord br = new BenchRecord(e.getEmployeeID(), (new SimpleDateFormat("yyyyMMdd")).parse("20150302"), 8, "Browsed the web lulz");
        BenchRecord br2 = new BenchRecord(e.getEmployeeID(), (new SimpleDateFormat("yyyyMMdd")).parse("20150303"), 8, "More browsing");

        initialiseHeadingText();
//        Label lbl1 = new Label("Label 1");
//        gridPane.add(lbl1, 1, 4);
//        Label lbl2 = new Label("Label 2");
//        gridPane.add(lbl2, 1, 5);

        helloWorld.setText(br.getBenchActivity());
    }

    private void initialiseHeadingText() {
        lblEmployeeHeading.setText("Employee");
        lblBenchHours.setText("Bench Hours");
        lblBenchActivity.setText("Bench Activity");
    }
}
