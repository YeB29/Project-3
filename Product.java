package Model;

import javafx.scene.control.Button;

public class Product {
    private String name;
    private Double price;
    private String category;
    private Button button;


    public Product(String title,Double price,String category, Button button){
        this.name = title;
        this.price = price;
        this.category = category;
        this.button = button;
        this.button.setText("Add");
    }
    public String getName(){
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Button getButton() {
        return button;
    }
}

