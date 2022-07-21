package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import db.DataSet;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Optional;


public class MainFormController implements OpenPages{
    public AnchorPane mainContext;
    public JFXComboBox cmbSelectVehicle;
    public JFXComboBox cmbDrier;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDelivery;
    public Label lblVehicleType;
    public Label lblSlotNumber;
    public Label lblDriver;
    public Label lblSelectVehicle;
    public Label lblClock;

    String clickValue;

    public void initialize(){

        dateAndTime();

        //===========comboBox SelectVehicle======================================

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        for (Vehicle v: DataSet.vehicleDetails
             ) {
            obList1.add(v.getVehicleNum());
        }
        cmbSelectVehicle.setItems(obList1);

        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clickValue= (String) newValue;
            lblSelectVehicle.setText((String) newValue);
            vehicleType();
            parkingSlot();
            btnDisable();

        });

        //===========================================================================


        //=================comboBox Driver===========================================

        ObservableList<String> obList2 = FXCollections.observableArrayList();
        for (Driver d:DataSet.driverDetails
             ) {
            obList2.add(d.getDriverName());
        }
        cmbDrier.setItems(obList2);

        cmbDrier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                lblDriver.setText((String) newValue);
        });

        //=====================================================================


    }


    public void parkingSlot() {
        String type = null;
        for (int i = 0; i < DataSet.vehicleDetails.size(); i++){
            if (clickValue.equals(DataSet.vehicleDetails.get(i).getVehicleNum())){
                type=DataSet.vehicleDetails.get(i).getVehicleType();
            }
        }

        switch (type){
            case "Van" : {
                setSlot("Van");
            }break;
            case "Cargo Lorry" : {
                setSlot("Cargo Lorry");
            }break;
            case "Bus" : {
                setSlot("Bus");
            }break;
        }

    }
    private void setSlot(String vehicleType) {

        for (int i=0; i<DataSet.slotNumbers.size(); i++){
                if (vehicleType.equals(DataSet.slotNumbers.get(i).getVehicleType()) && DataSet.slotNumbers.get(i).getSlotStatus().equals("Not Use")) {
                    lblSlotNumber.setText(DataSet.slotNumbers.get(i).getSlotNumber());
                    return;
                }
        }

    }



    public void openLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUi(mainContext,"LoginForm");
    }


    public void btnSaveParkVehicleOnAction(ActionEvent actionEvent) {

        InPark p1 = new InPark((String) cmbSelectVehicle.getValue(),lblVehicleType.getText(),Integer.parseInt(lblSlotNumber.getText()),lblClock.getText());
        DataSet.inParkDetails.add(p1);
        //=============slot number eka use karanwa=========================================

        for (int i=0;i<DataSet.slotNumbers.size();i++){
            if (lblSlotNumber.getText().equals(DataSet.slotNumbers.get(i).getSlotNumber())){
                DataSet.slotNumbers.get(i).setSlotStatus("Use");
            }
        }
        //======================================================================================

        //=========inPark unhama OnDelivery table eken remove =============================
        for (int j = 0;j<DataSet.OnDeliveryDetails.size();j++){
            if (clickValue.equals(DataSet.OnDeliveryDetails.get(j).getVehicleNum())){
                DataSet.OnDeliveryDetails.remove(j);
            }
        }
        //======================================================================================

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You can park the vehicle in slot number " + lblSlotNumber.getText(),ButtonType.OK);
        Optional<ButtonType> buttonType = alert.showAndWait();


         if(buttonType.get().equals(ButtonType.OK)){
            lblSelectVehicle.setText("");
            lblVehicleType.setText("");
            lblDriver.setText("");
            lblSlotNumber.setText("");

        }

    }

    public void btnSaveOnDeliveryOnAction(ActionEvent actionEvent) {

        OnDelivery d1=new OnDelivery(lblSelectVehicle.getText(),lblVehicleType.getText(),lblDriver.getText(),lblClock.getText());
        DataSet.OnDeliveryDetails.add(d1);

        //===================slot num eka free karanwa================================================
        for (int i=0 ;i<DataSet.inParkDetails.size();i++){
            if (clickValue.equals(DataSet.inParkDetails.get(i).getVehicleNum())){
                String slot=String.valueOf(DataSet.inParkDetails.get(i).getParkingSlot());
                for (int j=0;j<DataSet.slotNumbers.size();j++){
                    if (slot.equals(DataSet.slotNumbers.get(j).getSlotNumber())){
                        DataSet.slotNumbers.get(j).setSlotStatus("Not Use");
                    }
                }

            }
        }
        //=================================================================================

        //=========Ondeliver unhama inPark table eken remove =============================
        for (int k=0;k<DataSet.inParkDetails.size();k++){
            if (clickValue.equals(DataSet.inParkDetails.get(k).getVehicleNum())){
                DataSet.inParkDetails.remove(k);
                DataSet.slotNumbers.get(k).setSlotStatus("Not Use");
            }
        }
        //=================================================================================

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You can start your delivery...",ButtonType.OK);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.OK)) {
            lblSelectVehicle.setText("");
            lblVehicleType.setText("");
            lblDriver.setText("");
            lblSlotNumber.setText("");
        }

    }

    private void dateAndTime() {
        Calendar cln = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat(" aa");


        Timeline clock = new Timeline(new KeyFrame(Duration.INDEFINITE.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
            lblClock.setText(currentDate.getDayOfMonth() + "-" + currentDate.getMonthValue() + "-" + currentDate.getYear()+"   "+currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond() + "  " + format1.format(cln.getTime()) );

        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


        private void btnDisable(){
        for (int i = 0;i< DataSet.inParkDetails.size();i++){
            if (clickValue.equals(DataSet.inParkDetails.get(i).getVehicleNum())){
                btnParkVehicle.setDisable(true);
                return;
            }else {
                btnParkVehicle.setDisable(false);
            }
        }

        for (int j=0; j<DataSet.OnDeliveryDetails.size();j++){
            if (clickValue.equals(DataSet.OnDeliveryDetails.get(j).getVehicleNum())){
                btnOnDelivery.setDisable(true);
                return;
            }else {
                btnOnDelivery.setDisable(false);
            }
        }
    }

    private void vehicleType(){
        for (int i = 0; i < DataSet.vehicleDetails.size(); i++) {
            if (clickValue.equals(DataSet.vehicleDetails.get(i).getVehicleNum())){
                lblVehicleType.setText(DataSet.vehicleDetails.get(i).getVehicleType());
            }
        }
    }

}
