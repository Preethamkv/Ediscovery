package com.highpeak.Ediscovery.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping("/elasticsearch")
public class ElasticsearchController {
	

	@RequestMapping("/entity")
	public String selectdata(@RequestParam(value="Docname", required=true) String docname ) throws IOException {
		
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		
		HttpEntity entity1 = new NStringEntity(
				 "{\n" +
			    " \"_source\": [\"entities_people\",\"entities_place\",\"entities_date_time\",\"entities_organisation\",\"filename\"],"+
				"    \"query\" : {\n" +
		        "    \"match\":{\"filename.raw\":\""+docname+"\"}\n"+
				"   }\n"+
				
				"}", ContentType.APPLICATION_JSON);
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("filename", "DX202.pdf");
		paramMap.put("pretty", "true");
		                               
		Response response = restClient.performRequest("GET", "/document/_search",paramMap,entity1);
		HttpEntity data=response.getEntity();
	    //System.out.println(data);
		
		String json=EntityUtils.toString(response.getEntity());
		/*System.out.println(json);
		String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);*/
	return json ;
	}
	
	
	@RequestMapping("/{entities}")
	public String selectdata(@PathVariable("entities") String entities,
			@RequestParam(value="value", required=true) String values) throws IOException {
		System.out.println(values);
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		
		HttpEntity entity1 = new NStringEntity(
				 "{\n" +
		        "  \"size\":3657,"+
				" \"_source\": [\"filename\",\"page_number\"],"+
				"    \"query\" : {\n" +
				"    \"match\": {\""+entities+"\" :{\"query\":\""+values+"\",\n"+
			    "                                      \"operator\":\"and\"   } }\n" +
				"} \n"+
				"}", ContentType.APPLICATION_JSON);
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("filename", "DX202.pdf");
		paramMap.put("pretty", "true");
		//paramMap.put("size","15");
		                               
		Response response = restClient.performRequest("GET", "/document/_search",paramMap,entity1);
		
		String json=EntityUtils.toString(response.getEntity());
		/*System.out.println(json);
		String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);*/
	return json ;
	}
	
	@RequestMapping("/email")
	public String select() throws IOException {
	
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("q", "filename : JX028.pdf");
		paramMap.put("pretty", "true");
		                               
		Response response = restClient.performRequest("GET", "/email/_search",paramMap);
		String json=EntityUtils.toString(response.getEntity());
		/*System.out.println(json);
		String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);*/
	return json;
	}
	

	@RequestMapping("/document")
	public String selectdoc() throws IOException {
		HttpEntity entity1 = new NStringEntity(
				 "{\n" +
				/*" \"_source\": [\"filename\"],"+*/
				"\"from\":10,"+		 
				" \"aggs\" : {"+
				 " \"genres\" : {"+
				 " \"terms\" : { \"field\" : \"filename.raw\",\"size\":500,\"order\": {\n" + 
				 "                \"_term\" : \"asc\" \n" + 
				 "              }}"+
				  "   }    }"+
				"}", ContentType.APPLICATION_JSON);
	
		RestClient restClient = RestClient.builder(
			       new HttpHost("192.168.39.48", 9200, "http")).build();
		Map<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("q", "filename : JX028.pdf");
		paramMap.put("pretty", "true");
		//paramMap.put("from","100");
		paramMap.put("size","0");
		                               
		Response response = restClient.performRequest("GET", "/document/_search",paramMap,entity1);
		//HttpEntity data=response.getEntity();
		String json=EntityUtils.toString(response.getEntity());
		/* JSONObject result = new JSONObject(json);
		 System.out.println(result);
		 JSONArray tokenList = result.getJSONArray("filename");
         JSONObject oj = tokenList.getJSONObject(0);
         String token = oj.getString("filename"); */
		//System.out.println(json);
		/*String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);*/
	return json;
	}
	
	
}

