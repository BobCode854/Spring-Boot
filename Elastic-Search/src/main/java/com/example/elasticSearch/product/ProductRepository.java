package com.example.elasticSearch.product;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;



public interface ProductRepository {
  //  SearchResponse search(SearchQueryDto searchQueryDto) throws IOException;

    IndexResponse save(Product product) throws IOException;

    BulkResponse saveAll(List<Product> products) throws IOException;
}