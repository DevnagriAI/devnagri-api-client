package com.devnagri.api;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * Created by Gaurav on 11.06.18.
 */

public class RestClient {

    private int statusCode=0;

    public String callService(String myUrl, MultipartEntityBuilder myRequest, String token)
    {

        /* TARGET URL AND JSON */
        String url = myUrl;


        /* HTTPCLIENT AND HTTPPOST OOBJECT */
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);


        /* ADD HEADER INFO */
        if(!token.equalsIgnoreCase("")){
            request.addHeader("authorization", "Bearer "+token);
        }

        request.addHeader(/*"content-type"*/"Accept", "application/json");

        HttpEntity multiPartEntity = myRequest.build();
        request.setEntity(multiPartEntity);

        /* SEND AND RETRIEVE RESPONSE */
        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* RESPONSE AS JSON STRING */
        String result = null;
        if(null!=response){
            if (statusCode==200){
                try {
                    result = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(statusCode==204){
                result = "No files available";
            }else{
                result = response.toString();
            }
        }

        return result;
    }

   public int getstatusCode(){
       return statusCode;
   }
}
