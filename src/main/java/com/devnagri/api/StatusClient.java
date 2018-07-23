package com.devnagri.api;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/**
 * Created by Gaurav on 11.06.18.
 */

public class StatusClient {

    private String response;
    private String clientId;
    private String clientSecret;
    private String projectKey;
    private String accessToken;

    public StatusClient(String accessToken, String clientId, String clientSecret, String projectKey){
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.projectKey = projectKey;
    }

    public String getStatus(){

        String urlStatus = "https://staging.devnagri.com/api/project/status";

        MultipartEntityBuilder entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.STRICT)
                .addTextBody("client_id", clientId)
                .addTextBody("client_secret", clientSecret)
                .addTextBody("project_key", projectKey);

        RestClient restClient = new RestClient();
        response = restClient.callService(urlStatus, entity, accessToken);
        System.out.println("Response is : "+ response);

        return response;
    }

}
