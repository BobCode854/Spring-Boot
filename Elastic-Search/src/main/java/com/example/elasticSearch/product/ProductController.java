package com.example.elasticSearch.product;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping
	public IndexResponse addProduct(@RequestBody Product product) throws IOException {
		System.out.println("product  : "+product);
	    return productRepository.save(product);
	}
	
	@PostMapping("/bulk")
	public BulkResponse addProducts(@RequestBody List<Product> products) throws IOException {
	    return productRepository.saveAll(products);
	}
}