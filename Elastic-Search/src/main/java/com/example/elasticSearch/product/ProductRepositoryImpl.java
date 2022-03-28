package com.example.elasticSearch.product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	RestHighLevelClient restHighLevelClient;

	@Autowired
	ObjectMapper objectMapper;

	private static final String INDEX_NAME = "product";

	private Map<String, Object> convertProductToMap(Product product) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(product);
		return objectMapper.readValue(json, Map.class);
	}

//	@Override
//	public SearchResponse search(SearchQueryDto searchQueryDto) throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public IndexResponse save(Product product) throws IOException {
		System.out.println("Entered into save");
		IndexRequest indexRequest = Requests.indexRequest(INDEX_NAME).id(product.getId().toString())
				.source(convertProductToMap(product));

		System.out.println("index request ready : " + indexRequest);

		RequestOptions options = RequestOptions.DEFAULT;
		return restHighLevelClient.index(indexRequest, options);
	}

	@Override
	public BulkResponse saveAll(List<Product> products) throws IOException {
		BulkRequest bulkRequest = Requests.bulkRequest();
		products.forEach(product -> {
			try {
				IndexRequest indexRequest = Requests.indexRequest(INDEX_NAME).source(convertProductToMap(product));
				bulkRequest.add(indexRequest);
			} catch (JsonProcessingException e) {
				// log error
			}
		});

		RequestOptions options = RequestOptions.DEFAULT;
		return restHighLevelClient.bulk(bulkRequest, options);
	}
}