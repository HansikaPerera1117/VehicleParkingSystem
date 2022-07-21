package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DataSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.Vehicle;

import java.util.Optional;

public class AddVehicleFormController  {

    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaximumWeight;
    public JFXTextField txtNoOfPassengers;
    public JFXComboBox cmbVehicleType;
    public Label lblVehicleType;

    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("Van");
        obList.add("Bus");
        obList.add("Cargo Lorry");

        cmbVehicleType.setItems(obList);

        cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            lblVehicleType.setText((String) newValue);
        });

    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
        if (DataSet.vehicleDetails.size()<14){

            Vehicle vehicle = new Vehicle(
                    txtVehicleNumber.getText(),lblVehicleType.getText() ,Integer.parseInt(txtMaximumWeight.getText()),Integer.parseInt(txtNoOfPassengers.getText()));

            if (DataSet.vehicleDetails.add(vehicle))
                new Alert(Alert.AlertType.CONFIRMATION,"Vehicle added to the system successfully...").show();
            else
                new Alert(Alert.AlertType.ERROR,"Unsuccessful!....").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"The number of vehicles required for the company is sufficient").show();

        }

       }
}
