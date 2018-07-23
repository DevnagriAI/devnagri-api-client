package com.devnagri.api;


import java.io.File;
import java.io.IOException;

/**
 * Created by Gaurav on 11.06.18.
 */

public class MainClass {

    private static String response="";
    private static String requestType;
    public static String accessToken;
    public static String clientId;
    public static String clientSecret;
    public static String projectKey;
    public static File file;
    public static String fileLocation;
    public static String project;


    public String setConfigData(String requestType, String accessToken, String clientId, String clientSecret, String projectKey, File file , String fileLocation, String project){
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.projectKey = projectKey;
        this.file = file;
        this.fileLocation = fileLocation;
        this.requestType = requestType;
        this.project = project;
        if(null!= requestType && !requestType.equalsIgnoreCase("")){
            InitClient initClient = new InitClient();
            response = initClient.getResponseRequest(requestType, accessToken, clientId, clientSecret, projectKey, file, fileLocation, project);
        }else{
            //Notifications.Bus.notify(new com.intellij.notification.Notification("devnagri", "Error", "Please set config first", NotificationType.ERROR));
        }
        return response;
    }

    public static void main(String[] args) throws IOException {

        /*InitClient initClient = new InitClient();
        response = initClient.getResponseRequest("push","eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjI1YjllZjNkZjQyNmRlNDdhOGYxYjI3YzIwMDYyNjA4N2FjMWIwOWE2NGU4N2QxNzM0NTM1ZWMyZmFkNWI4YmNiZTg1ZDVkMTM3YzBjMGZiIn0.eyJhdWQiOiI0IiwianRpIjoiMjViOWVmM2RmNDI2ZGU0N2E4ZjFiMjdjMjAwNjI2MDg3YWMxYjA5YTY0ZTg3ZDE3MzQ1MzVlYzJmYWQ1YjhiY2JlODVkNWQxMzdjMGMwZmIiLCJpYXQiOjE1Mjk2NTMxNzYsIm5iZiI6MTUyOTY1MzE3NiwiZXhwIjoxNTYxMTg5MTc2LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.hDQVhbZlX0TmHYzR6oJ4W1ehpIFqd61GEwQ7BDGLWNAoBWKN3SFsAaExhZ0qlHBSC4NjeDUO97t3-ew1V3V3tJmejLR9pP7huxgc_9AWyiMMWsZ8pdeLj-kwxfhemPSK_btDg2IWIfr4cHKngpSCHd0-itBu6mLIUUFtJ7UZ1jQYr4h4PKrfOPy1EKqHBpodMET8ozmPZmFxVhMI4WsqiMMfVGGFw9m460m7hXC8H8tSCR6vUHau0nMQmL9AWqA7AWUazvAMhDZNnLDUTEeqpJp-Hc3Y1jc_HcqGA3WyEzgY5mJSMXIEZJCO5zgLj8kcbdN7D6qkeBUQm9a0o9XQo5nF3qXNGX5uBH9lLYP_ZxWuIMHnaYOxEFgUZcAd2KUSAMBHHLVbJFU5_oyHmyquR_QKGq55AxwAJ-AN-ngZdexbfz9JO0OQsVsDUDMgrllHoj3Zys33d-iLuxkxPxp5LxsYcE2CnsfeJxcI0Yes_RApgTSSwMBTutlPZy1kXdBQpoS5yLvFxo-fJ-X-Ox-OpEBxbAXGe_KhesfPCyMeiovic9okCE11c8worH8_MwpnAsgl0szxCByIJwFnw95j5mkteRdDhxQxaC1DpCdn4jdL4boTHvMwIGw7OlPSGtsQWZTnLFJ8QK6QHm0NnZ0o6c5JaDLkFSkL5i0CcsyupK8","3","vZ1pwI6CzwpBhz346KrdUrlvwA1evi3NghKsx1LK","5814648999ab58697788f61f871d7b7c",new File("/home/fourtek/Desktop/strings.xml"),"/home/fourtek/Desktop/strings.xml",System.getProperty("user-dir"));
        //DevnagriConfiguration d = new DevnagriConfiguration(System.getProperty("user-dir"));
        System.out.println("yaha aya"+response);*/
        /*d.getAccessToken();
        System.out.println(d.getAccessToken());*/

    }

    public static String getResponse(){
        return response;
    }

}
