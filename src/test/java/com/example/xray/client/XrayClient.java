package com.example.xray.client;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.example.pojos.TestRun;
import com.example.pojos.UpdateTestRun;
import com.google.gson.Gson;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

public class XrayClient {
	

	  private static final MediaType MEDIA_TYPE_MULTIPART = MediaType.parse("application/octet-stream");
	  private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");
	  private static final String BASE_URL= "http://localhost:8080";
	  private final Gson gson = new Gson();

	  private  OkHttpClient client;
	  
	  
	  public XrayClient basicAuth(String username,String password){
		  client = basicAuthentication(username,password); 
		  return this;
	  }

	  public void exportTestngResult(String projectKey,String filePath) throws Exception {
	    RequestBody requestBody = new MultipartBody.Builder()
	        .setType(MultipartBody.FORM)
	        .addFormDataPart("file", "testng-results.xml",
	            RequestBody.create(MEDIA_TYPE_MULTIPART, new File(filePath)))
	        .build();

	    Request request = new Request.Builder()
	        .url(BASE_URL +"/rest/raven/1.0/import/execution/testng?projectKey="+projectKey)
	        .post(requestBody)
	        .build();

	    try (Response response = client.newCall(request).execute()) {
	    	 System.out.println(response.body().string());
	      if (!response.isSuccessful()) 	    	 
	    	  throw new IOException("Unexpected code " + response);
	    }
	  }
	
	  private OkHttpClient basicAuthentication(String username,String password) {
		    return new OkHttpClient.Builder()
		        .authenticator(new Authenticator() {
		          @Override public Request authenticate(Route route, Response response) throws IOException {
		            if (response.request().header("Authorization") != null) {
		              return null; // Give up, we've already attempted to authenticate.
		            }

		            System.out.println("Authenticating for response: " + response);
		            System.out.println("Challenges: " + response.challenges());
		            String credential = Credentials.basic(username,password);
		            return response.request().newBuilder()
		                .header("Authorization", credential)
		                .build();
		          }
		        })
		        .build();
		   
	}
	  
	public TestRun getTestRun(String execKey,String issueKey) throws Exception{

			Request request = new Request.Builder()
	        .url(BASE_URL +"/rest/raven/1.0/api/testrun?testExecIssueKey="+execKey+"&testIssueKey="+issueKey)
	        .get()
	        .build();

	    try (Response response = client.newCall(request).execute()) {
	    	 
	      if (!response.isSuccessful()) 	    	 
	    	  throw new IOException("Unexpected code " + response);
	      	 String responseString = response.body().string();
	    	 System.out.println(responseString);
	    	 TestRun testRun = gson.fromJson(responseString, TestRun.class);
	    	 return testRun;
	    }
	}
	
	public void updateTestRun(String runId,UpdateTestRun testRun) throws Exception{
		
		Request request = new Request.Builder()
        .url(BASE_URL +"/rest/raven/1.0/api/testrun/"+runId)
        .put(RequestBody.create(MEDIA_TYPE_JSON,gson.toJson(testRun)))
        .build();

		try (Response response = client.newCall(request).execute()) {
    	 
		if (!response.isSuccessful()) 	    	 
    	  throw new IOException("Unexpected code " + response);
		}
	}
	  
	public static void main(String [] args) throws Exception{
	
	     XrayClient client = new XrayClient();
	     client.basicAuth("vivek.125","sylvester-1");
	     TestRun run = client.getTestRun("TES-11","TES-8");
	     UpdateTestRun update = new UpdateTestRun();
	     update.setStatus("PASS");
	     client.updateTestRun(Integer.toString(run.getId()),update);
	}


}
