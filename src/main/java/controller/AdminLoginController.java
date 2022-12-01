package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Model.Login;

public class AdminLoginController implements Initializable {
    @FXML
    private Button loginbutton;
    @FXML
    private Label id;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane rootPane;


    public void back(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        rootPane.getChildren().setAll(pane);

    }


    public void login(MouseEvent mouseEvent) throws IOException {
        checklogin();
    }

    public void checklogin() throws IOException{
        if(username.getText().equals("Younes") && password.getText().equals("123")) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/HomeScreen.fxml"));
            rootPane.getChildren().setAll(pane);
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data.");
        }
        else {
            wrongLogin.setText("Wrong username or password.");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
