package com.devnagri.api;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/**
 * Created by Gaurav on 11.06.18.
 */

public class PullClient {

    private String response;
    private String clientId;
    private String clientSecret;
    private String projectKey;
    private String accessToken;

    public PullClient(String accessToken, String clientId, String clientSecret, String projectKey){
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.projectKey = projectKey;
    }

    public String pullData(){
        String urlPull = "https://staging.devnagri.com/api/project/pull";

        MultipartEntityBuilder entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.STRICT)
                .addTextBody("client_id", clientId)
                .addTextBody("client_secret", clientSecret)
                .addTextBody("project_key", projectKey);

        RestClient restClient = new RestClient();
        response = restClient.callService(urlPull, entity, accessToken);
        System.out.println("Response is : "+ response);
        return response;
    }

}
