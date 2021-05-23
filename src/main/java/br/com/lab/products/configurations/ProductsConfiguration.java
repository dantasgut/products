package br.com.lab.products.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("br.com.lab.products.repositories")
@ComponentScan({
		"br.com.lab.products.api.services",
		"br.com.lab.products.services"
		})
@EntityScan("br.com.lab.products.repositories.entities")
public class ProductsConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
