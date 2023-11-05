package com.projectapi.projectapi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectapi.projectapi.shop.model.Product;
import com.projectapi.projectapi.shop.repository.ProductRepository;

@Service
public class ProductService implements IProduct{

	ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(id);
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return this.productRepository.findByName(name);
	}

	@Override
	public Product save(Product std) {
		// TODO Auto-generated method stub
		return productRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}
	
	public Optional<Product> findOptionalById(long id){
		return productRepository.findOpionalById(id);
	}

}
