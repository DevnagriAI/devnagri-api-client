package com.devnagri.api;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;


import java.io.File;

/**
 * Created by Gaurav on 11.06.18.
 */

public class SyncClient {

    private String response;
    private String accessToken;
    private String clientId;
    private String clientSecret;
    private String projectKey;
    private File file;
    private String fileLocation;

    public SyncClient(String accessToken, String clientId, String clientSecret, String projectKey, File file, String fileLocation){
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.projectKey = projectKey;
        this.file = file;
        this.fileLocation = fileLocation;
    }

    public String syncData(){

        String urlSync = "https://staging.devnagri.com/api/project/sync";

        MultipartEntityBuilder entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.STRICT)
                .addTextBody("client_id", clientId)
                .addTextBody("client_secret", clientSecret)
                .addTextBody("project_key", projectKey)
                .addBinaryBody("file[file]", file)
                .addTextBody("file[location]", fileLocation);

        RestClient restClient = new RestClient();
        response = restClient.callService(urlSync, entity, accessToken);
        System.out.println("Response is : "+ response);

        return response;
    }
}
