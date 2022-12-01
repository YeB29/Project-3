package controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JobController implements Initializable {
    @FXML
    private ListView<String> Listviewc;
    @FXML
    private ListView<String> Listv;
    @FXML
    private AnchorPane rootPane;
    String [] job ={"Farmer","Carpenter","Baker","Cleaner","Mechanic",
    "Teacher","Nurse","Painter","Officer","Construction worker"};

    public void back(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/HomeScreen.fxml"));
        rootPane.getChildren().setAll(pane);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Listviewc.getItems().addAll(job);
        Listviewc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
               String jobs = Listviewc.getSelectionModel().getSelectedItem();
                Listv.getItems().addAll(jobs);
            }
        });
    }


}
