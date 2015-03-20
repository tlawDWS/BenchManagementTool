package BenchManagementTool;

import DAL.DBConnection;
import Models.BenchRecord;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

/**
 * Created by tlaw on 16/03/2015.
 */
public class AddBenchRecordController {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtBenchActivity;

    public void addBenchRecord(BenchRecord br) {
        //DBConnection.addBenchRecord(br);
    }

    public void addBenchRecord(ActionEvent actionEvent) {
        DBConnection.addBenchRecord();
    }
}
