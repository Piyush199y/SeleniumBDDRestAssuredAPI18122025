package org.piyush.pojo;

public class ProductRequest {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    // constructor
    public ProductRequest(String title, double price, String description,
                          String image, String category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }
}
