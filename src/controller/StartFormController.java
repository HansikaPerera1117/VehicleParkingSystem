package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartFormController implements OpenPages{
    public AnchorPane startContext;

    public void openMainOnAction(ActionEvent actionEvent) throws IOException {
        setUi(startContext,"MainForm");
    }


}
