package controller;

import com.jfoenix.controls.JFXComboBox;
import db.DataSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InPark;
import view.tm.InParkTM;

import java.io.IOException;
import java.net.URL;

public class InParkingFormController implements OpenPages{
    public JFXComboBox cmbOption;
    public AnchorPane inParkingContext;
    public TableView<InParkTM> tblParkIn;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;

    public void initialize() throws IOException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("In Parking");
        obList.add("On Delivery");

        cmbOption.setItems(obList);


        cmbOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("On Delivery")){
                try {
                    setUi(inParkingContext,"OnDeliveryForm");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNum"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("parkedTime"));


        loadAllInPark();

    }


    private void loadAllInPark() {
        ObservableList<InParkTM> obList = FXCollections.observableArrayList();
        for (InPark p: DataSet.inParkDetails
             ) {
            InParkTM tm = new InParkTM(p.getVehicleNum(),p.getVehicleType(),p.getParkingSlot(),p.getParkedTime());
            obList.add(tm);
        }
        tblParkIn.setItems(obList);
    }

    public void backToStartOnAction(ActionEvent actionEvent) throws IOException {
        setUi(inParkingContext,"StartForm");
    }


    public void openAddDriverOnAction(ActionEvent actionEvent) throws IOException {
       setUI("AddDriverForm");
    }

    public void openAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AddVehicleForm");
    }
}
