package br.com.lab.products.services.interfaces;

import java.util.List;

import br.com.lab.products.api.dtos.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> findAll();
	public ProductDTO findById(ProductDTO productDTO);
	public void save(ProductDTO productDTO);
	public void delete(ProductDTO productDTO);

}
