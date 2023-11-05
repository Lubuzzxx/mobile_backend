package com.projectapi.projectapi.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectapi.projectapi.shop.business.ProductBusiness;
import com.projectapi.projectapi.shop.json.ProductListJson;
import com.projectapi.projectapi.shop.model.Product;
import com.projectapi.projectapi.shop.payload.ProductPayload;
import com.projectapi.projectapi.shop.service.ProductService;
import com.projectapi.projectapi.exception.BaseException;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@Autowired
	ProductBusiness pBusiness;
	
	public ProductController(ProductService productservice) {
		this.productservice = productservice;
	}
	
	//insert
//	{
//	    "name" : "Strawberry",
//	    "picture" : "link",
//	    "price" : 120,
//	    "size" : "S",
//	    "color" : "brown",
//	    "description" : "good quality",
//	    "amount" : 20,
//	    "type" : "long dress",
//	    "rating" : "3"
//	}
	@PostMapping(value = "/products")
	public ResponseEntity<Void> saveProduct(@RequestBody ProductPayload payload) throws BaseException{
		pBusiness.saveProduct(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	//find all
	@GetMapping(value="/products")
	public ResponseEntity<List<ProductListJson>> getAllProducts() throws BaseException{
		return ResponseEntity.ok(pBusiness.getListProduct());
	}
	
	//id
	@GetMapping(value="/products/{id}")
	public ResponseEntity<ProductListJson> getProductById(@PathVariable("id")  long id) throws BaseException{
		return ResponseEntity.ok(pBusiness.getProductId(id));
	}
	
	//find from name
	@GetMapping(value="/products/name/{name}")
	public ResponseEntity<ProductListJson> getProductByName(@PathVariable("name")  String name) throws BaseException{
		return ResponseEntity.ok(pBusiness.getProductByName(name));
	}
	
	//update
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductListJson> updateProduct(@PathVariable("id") long id,
			@RequestBody ProductPayload payload){
		Optional<Product> pData = productservice.findOptionalById(id);
		if(pData.isPresent()) {
			pBusiness.updateProduct(pData.get().getId(),payload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id){
		try {
			pBusiness.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
