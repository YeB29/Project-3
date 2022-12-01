package controller;

import Model.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class sController implements Initializable {
    private ObservableList<Product> products = FXCollections.observableArrayList();

    private ObservableList<Product> shoppingcart = FXCollections.observableArrayList();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<Product> table;

    @FXML
    private MenuItem woodworking;

    @FXML
    private MenuItem powertools;
    @FXML
    private MenuItem food;
    @FXML
    private MenuItem everything;

    private String productCategory;

    @FXML
    TableColumn<Product, String> productName;

    @FXML
    TableColumn<Product, Double> price;

    @FXML
    TableColumn<Product, String> category;

    @FXML
    TableColumn<Product, Button> button;

    Button[] buttons = new Button[3];

    private void buttonOnclick(ActionEvent event) {
        if (event.getSource() == buttons[0]) {
            shoppingcart.add(products.get(0));
        }
        else if (event.getSource() == buttons[1]) {
            shoppingcart.add(products.get(1));
        }
        else if (event.getSource() == buttons[2]) {
            shoppingcart.add(products.get(2));
        }
    }

    ObservableList<Product> woodworkList = FXCollections.observableArrayList();
    ObservableList<Product> powertoolList = FXCollections.observableArrayList();
    ObservableList<Product> foodList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        button.setCellValueFactory(new PropertyValueFactory<Product, Button>("button"));

        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new Button();
            buttons[i].setOnAction(this::buttonOnclick);
        }

        products.add(new Product("wood", 2.00, "woodworking",buttons[0]));
        products.add(new Product("drill", 10.00, "powertool",buttons[1]));
        products.add(new Product("water", 10.00, "food",buttons[2]));

        table.setItems(products);

        for (Product product : products) {
            if (product.getCategory().equals("powertool")) {
                powertoolList.add(product);
            }
            if (product.getCategory().equals("food")) {
                foodList.add(product);
            }
            if (product.getCategory().equals("woodworking")) {
                woodworkList.add(product);
            }
        }
        woodworking.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                table.setItems(woodworkList);
            }
        });
        everything.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                table.setItems(products);
            }
        });

        powertools.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                table.setItems(powertoolList);
            }
        });
        food.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                table.setItems(foodList);
            }
        });
    }

    public Stage showShop(ObservableList<Product> shoppingcart) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WinkelmandScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        WinkelmandController controller = loader.getController();
        controller.initData(shoppingcart);
        stage.show();
        return stage;
    }


    public void backToHome(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/HomeScreen.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void toShop(MouseEvent mouseEvent) throws IOException {
        showShop(shoppingcart);
    }
}
