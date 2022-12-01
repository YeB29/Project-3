package controller;

import Model.Receipt;
import Model.User;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WinkelmandController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button closeButton;

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, String> name;

    @FXML
    private TableColumn<Product, Double> price;

    @FXML
    private TableColumn<Product, String> category;

    @FXML
    TextArea bruh;

    ArrayList<Product> products = new ArrayList<>();

    void initData(ObservableList<Product> shoppingcart){
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        table.setItems(shoppingcart);

        for(Product product: shoppingcart){
            products.add(product);
        }

        bruh.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    @FXML
    void closeShop(MouseEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void printReceipt(MouseEvent mouseEvent) throws IOException {
        bruh.setVisible(true);
        Receipt receipt = new Receipt(products);

        bruh.setText(receipt.getReceipt());
    }

    public void back(MouseEvent mouseEvent) {
    }

    public void logOut(MouseEvent mouseEvent) {
    }
}