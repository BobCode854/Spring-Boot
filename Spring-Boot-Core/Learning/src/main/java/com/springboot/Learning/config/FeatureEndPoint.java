package com.springboot.Learning.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 
 *   **) With the help of this class we can add any new end-point.
 *   **) Monitoring our custom service can  be done from here.
 *   **) We can include and exclude end-points from application.yml
 *   
 *   
 */

@Component
@Endpoint(id="features")
public class FeatureEndPoint {

	private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();
	
	public FeatureEndPoint() {
		featureMap.put("Department", new Feature(true));
		featureMap.put("users", new Feature(false));
	}
	@ReadOperation
	public Map<String, Feature> features()
	{
		return featureMap;
	}
	
	//@Selector is necessary 
	@ReadOperation
	public  Feature feature(@Selector String featureName){
		return featureMap.get(featureName);
	}
	

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Feature {
		private boolean isEnabled;
	}
}
