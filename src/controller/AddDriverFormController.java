package controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import db.DataSet;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Driver;

public class AddDriverFormController  {
    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextArea txtAddress;
    public JFXTextField txtContactNo;

    public void addDriverOnAction(ActionEvent actionEvent) {
        if (DataSet.driverDetails.size()<16) {
            Driver driver = new Driver(
                    txtDriverName.getText(), txtNIC.getText(), txtDrivingLicenseNo.getText(), txtAddress.getText(), Integer.parseInt(txtContactNo.getText())
            );
            if (DataSet.driverDetails.add(driver))
                new Alert(Alert.AlertType.CONFIRMATION, "Driver added to the system successfully...").show();
            else
                new Alert(Alert.AlertType.ERROR, "Unsuccessful!....").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "The number of drivers required for the company is sufficient").show();
        }
    }
}
