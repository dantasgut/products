package br.com.lab.products.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.lab.products.api.dtos.ProductDTO;
import br.com.lab.products.services.interfaces.ProductService;

@Controller
@RequestMapping(path="/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	@ResponseBody
	public List<ProductDTO> findAll(){
		return productService.findAll();
	}
	
	@ResponseBody
	@GetMapping(value = "/{id}")
	public ProductDTO getById(@PathVariable("id") Integer id) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		return productService.findById(productDTO);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ProductDTO productDTO) {
		productService.save(productDTO);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
		productDTO.setId(id);
		productService.save(productDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Integer id) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productService.delete(productDTO);
	}
}
