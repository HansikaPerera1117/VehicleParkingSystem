package controller;

import com.jfoenix.controls.JFXComboBox;
import db.DataSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InPark;
import model.OnDelivery;
import view.tm.InParkTM;
import view.tm.OnDeliveryTM;

import java.io.IOException;

public class OnDeliveryFormController implements OpenPages{
    public JFXComboBox cmbOption;
    public AnchorPane onDeliveryContext;
    public TableView<OnDeliveryTM> tblOnDelivery;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public void initialize() throws IOException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("In Parking");
        obList.add("On Delivery");

        cmbOption.setItems(obList);

        cmbOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("In Parking")){
                try {
                    setUi(onDeliveryContext,"InParkingForm");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNum"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory("leftTime"));


        loadAllOnDelivery();

    }

    private void loadAllOnDelivery() {

        ObservableList<OnDeliveryTM> obList = FXCollections.observableArrayList();
        for (OnDelivery d: DataSet.OnDeliveryDetails
        ) {
            OnDeliveryTM tm = new OnDeliveryTM(d.getVehicleNum(),d.getVehicleType(),d.getDriverName(),d.getLeftTime());
            obList.add(tm);
        }

        tblOnDelivery.setItems(obList);

    }

    public void backToStartOnAction(ActionEvent actionEvent) throws IOException {
        setUi(onDeliveryContext,"StartForm");
    }

    public void openAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AddDriverForm");
    }

    public void openAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUI("AddVehicleForm");
    }
}
