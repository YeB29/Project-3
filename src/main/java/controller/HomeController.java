package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomeController {

    @FXML
    private Button community;
    @FXML
    private Button edu;
    @FXML
    private Button shop;
    @FXML
    private Button logOut;
    @FXML
    private AnchorPane rootPane;

    public void edu(MouseEvent mouseEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/AccountScreen.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void openCommunity(MouseEvent mouseEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/CommunityScreen.fxml"));
        rootPane.getChildren().setAll(pane);
    }


    public void shop(MouseEvent mouseEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ShopScreen.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    public void prof(MouseEvent mouseEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Job.fxml"));
        rootPane.getChildren().setAll(pane);
    }


    public void logOut(MouseEvent mouseEvent) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
