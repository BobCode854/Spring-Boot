package com.example.elasticSearch.elastic;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    String elasticHost;
    @Bean
    public RestHighLevelClient client() {
    	System.out.println("Elastic host :  "+elasticHost);
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(elasticHost)));
    }
}