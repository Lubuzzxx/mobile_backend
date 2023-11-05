package com.projectapi.projectapi.shop.business;

import com.projectapi.projectapi.shop.service.ProductService;
import com.projectapi.projectapi.shop.json.ProductListJson;
import com.projectapi.projectapi.shop.model.Product;
import com.projectapi.projectapi.shop.payload.ProductPayload;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBusiness {

	@Autowired
	ProductService productService;
	
	public List<ProductListJson> getListProduct(){
		return ProductListJson.packJsons(productService.getAllProducts());
	}
	
	public ProductListJson getProductId(long id) {
		return ProductListJson.packJson(productService.findById(id));
	}
	
	public ProductListJson getProductByName(String name) {
		return ProductListJson.packJson(productService.findByName(name));
	}
	
	public void saveProduct(ProductPayload ppl) {
		Product product = new Product(
				ppl.getName(),
				ppl.getPicture(),
				ppl.getPrice(),
				ppl.getSize(),
				ppl.getColor(),
				ppl.getDescription(),
				ppl.getAmount(),
				ppl.getType(),
				ppl.getRating());
		productService.save(product);
	}
	
	public void updateProduct(long id, ProductPayload payload) {
		Product productData = productService.findById(id);
		productData.setName(payload.getName());
		productData.setPicture(payload.getPicture());
		productData.setPrice(payload.getPrice());
		productData.setColor(payload.getColor());
		productData.setDescription(payload.getDescription());
		productData.setAmount(payload.getAmount());
		productData.setType(payload.getType());
		productData.setRating(payload.getRating());
		productService.save(productData);
	}
	public void deleteProduct(long id) {
		productService.deleteById(id);
	}
}
