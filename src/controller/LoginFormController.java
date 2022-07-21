package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class LoginFormController implements OpenPages {
    public AnchorPane loginContext;
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;

    int attempts = 0;

    public void openInParkingOnAction(ActionEvent actionEvent) throws IOException {

        attempts++;
        if (attempts<=3){
            if (txtUserName.getText().equals("Hansika") && pwdPassword.getText().equals("123")){
                new Alert(Alert.AlertType.CONFIRMATION, "Success!").show();
                setUi(loginContext,"InParkingForm");
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();
            }

        }else{
            txtUserName.setEditable(false);
            pwdPassword.setEditable(false);

        }

    }

    public void backToMainOnAction(ActionEvent actionEvent) throws IOException {
        setUi(loginContext,"MainForm");
    }



}
