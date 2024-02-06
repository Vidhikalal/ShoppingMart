package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity(name="PRODUCTS")
public class Products {
    @Id
    @Column(name="Id")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="PRICE")
    private double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



