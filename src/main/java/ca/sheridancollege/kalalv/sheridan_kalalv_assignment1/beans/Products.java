package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans;


public class Products {

    private double price;
    private int product_id;
    private String product_name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Products{" +
                "price=" + price +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}


