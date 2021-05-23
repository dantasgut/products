package br.com.lab.products.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lab.products.api.dtos.ProductDTO;
import br.com.lab.products.repositories.entities.Product;
import br.com.lab.products.repositories.interfaces.ProductRepository;
import br.com.lab.products.services.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	public List<ProductDTO> findAll() {
		//List<ProductDTO> productsDTO = customerRepository.findAll().stream().map(this::Product.class)
		List<Product> products =  productRepository.findAll();
		return mapList(products, ProductDTO.class);
	}

	public ProductDTO findById(ProductDTO productDTO) {
		Product product = productRepository.findById(productDTO.getId()).orElse(new Product());
		return modelMapper.map(product, ProductDTO.class);
	}

	public void save(ProductDTO productDTO) {
		Product customer = modelMapper.map(productDTO, Product.class);		
		productRepository.save(customer);
		
	}

	public void delete(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		productRepository.delete(product);
	}
	
}
