package com.highpeak.Ediscovery.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchController {
	

	@RequestMapping("/entity")
	public String selectdata() throws IOException {
		
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		
		HttpEntity entity1 = new NStringEntity(
				 "{\n" +
				" \"_source\": [\"entities_people\",\"entities_place\",\"entities_date_time\",\"entities_organisation\"],"+
				"    \"query\" : {\n" +
				"    \"match_all\": {} \n" +
				"} \n"+
				"}", ContentType.APPLICATION_JSON);
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("filename", "DX202.pdf");
		paramMap.put("pretty", "true");
		                               
		Response response = restClient.performRequest("GET", "/document/_search",paramMap,entity1);
		HttpEntity data=response.getEntity();
	    System.out.println(data);
		
		String json=EntityUtils.toString(response.getEntity());
		System.out.println(json);
		String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);
	return json ;
	}
	
	
	@RequestMapping("/email")
	public String select() throws IOException {
	
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("q", "filename : JX028.pdf");
		paramMap.put("pretty", "true");
		                               
		Response response = restClient.performRequest("GET", "/email/_search",paramMap);
		String json=EntityUtils.toString(response.getEntity());
		System.out.println(json);
		String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);
	return json;
	}
	@RequestMapping("/document")
	public String selectdoc() throws IOException {
	
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("q", "filename : JX028.pdf");
		paramMap.put("pretty", "true");
		                               
		Response response = restClient.performRequest("GET", "/document/_search",paramMap);
		String json=EntityUtils.toString(response.getEntity());
		System.out.println(json);
		String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);
	return json;
	}
	
	
}

