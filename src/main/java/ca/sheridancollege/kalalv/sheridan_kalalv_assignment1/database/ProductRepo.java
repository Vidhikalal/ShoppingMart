package ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.database;


import ca.sheridancollege.kalalv.sheridan_kalalv_assignment1.beans.Products;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Products, Long> {

}
