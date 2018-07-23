package com.devnagri.api;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Gaurav on 11.06.18.
 */

public class GenerateTokenClient {

    private String response;
    public String token = "";
    public String clientId;
    public String clientSecret;
    public String projectKey;
    private RestClient restClient;
    private int statusCode=0;
    private String src_lang="";

    public GenerateTokenClient(String clientId, String clientSecret, String projectKey){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.projectKey = projectKey;
    }

    public String getGeneratedToken(){
        String urlGenerateToken = "https://staging.devnagri.com/api/key/validations";

       /* MultipartEntityBuilder entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.STRICT)
                .addTextBody("client_id", "3")
                .addTextBody("client_secret", "vZ1pwI6CzwpBhz346KrdUrlvwA1evi3NghKsx1LK")
                .addTextBody("project_key", "dac5735828cd4a70819147fb36d24411");*/

        MultipartEntityBuilder entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.STRICT)
                .addTextBody("client_id", clientId)
                .addTextBody("client_secret", clientSecret)
                .addTextBody("project_key", projectKey);

        restClient = new RestClient();
        response = restClient.callService(urlGenerateToken, entity, token);
        statusCode = restClient.getstatusCode();
        if(null!=response && !response.equalsIgnoreCase("") && statusCode==200){
            JSONObject jsonObject = new JSONObject(response);

            String access_token = jsonObject.getString("access_token");
            JSONObject source_language = jsonObject.getJSONObject("source_language");
            src_lang = source_language.getString("code");
            token = access_token;
            final String fileName = "devnagri.yml";
            ArrayList<String> key = new ArrayList<String>();
            ArrayList<String> value = new ArrayList<String>();
            Yaml yaml = new Yaml();

            try {
                InputStream ios = new FileInputStream(new File(fileName));

                // Parse the YAML file and return the output as a series of Maps and Lists
                Map< String, Object> result = (Map< String, Object>) yaml.load(ios);
                for (Object name : result.keySet()) {
                    key.add(name.toString());
                    value.add(result.get(name).toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return response;
    }


    public String getToken(){
        return token;
    }

    public String getSrcLanguage(){
        return src_lang;
    }

    public int statusCode(){
        return statusCode;
    }

}
