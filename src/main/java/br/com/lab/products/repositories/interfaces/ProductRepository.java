package br.com.lab.products.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.lab.products.repositories.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("select p from Product p")
	public List<Product> findAll();
}
