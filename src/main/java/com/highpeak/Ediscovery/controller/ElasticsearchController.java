package com.highpeak.Ediscovery.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
		/*String host=("Host -" + response.getHost() );
		System.out.println(host);
		String request=("RequestLine -"+ response.getRequestLine() );
		System.out.println(request);*/
	return json;
	}
	
	 @RequestMapping(value = "/pdf/{docname}",method = RequestMethod.GET,produces = "application/pdf")
	    public ResponseEntity<byte[]>  showPdf(@PathVariable("docname") String docname) throws IOException{

	        /*URL url=new URL("https://mozilla.github.io/pdf.js/web/compressed.tracemonkey-pldi-09.pdf");
	        URLConnection urlConn = url.openConnection();
	        InputStream in = (url.openStream());
	        ByteArrayOutputStream pdf= new ByteArrayOutputStream();

	        byte[] buffer=new byte[(1024)];
	        int byteread;
	        while ((byteread=in.read(buffer))!=-1){
	            pdf.write(buffer,0,byteread);
	        }
	        byte[] pdfContents=pdf.toByteArray();*/
	    	File file =new File(docname+".pdf");
	    	String doc_path=(file.getCanonicalPath());

           
	       Path path = Paths.get(doc_path);
	        byte[] pdfContents = null;
	        try {
	            pdfContents = Files.readAllBytes(path);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        //String filename ="test.pdf";
	        headers.add("Content-Disposition", "inline;filename=test.pdf");
	        //headers.setContentDispositionFormData(filename, filename);
	        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

	        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(
	                pdfContents, headers, HttpStatus.OK);
	        return response;
	        
	    }

	
	
}

