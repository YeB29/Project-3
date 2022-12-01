package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Model.User;

public class SignUpController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField name;
    @FXML
    private CheckBox male;
    @FXML
    private CheckBox female;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password1;
    @FXML
    private TextField emailadress;
    @FXML
    private DatePicker birth;

    public void createAccount(MouseEvent mouseEvent) throws IOException {

        try {
            File file = new File("user.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            LocalDate date = birth.getValue();

            pw.println( username.getText());
            pw.println( password.getText());
            pw.println("Name: " + name.getText());
            if(male.isSelected()){
                pw.println(male.getText());}
            else if(female.isSelected()){
                pw.println(female.getText());}
            pw.println("E-mailadress: " + emailadress.getText());
            pw.println("Date of birth: " + date.toString());
            pw.println("---------");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        rootPane.getChildren().setAll(pane);

    }
    public void back(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = new User(username.getText(),password.getText(),emailadress.getText(), name.getText(),male.getText(),birth.toString(),"ds");
    }
}
