package io.decisionlab.steam.collector;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * io.decisionlab.steam.collector
 * Created by nathan on 2/29/2016.
 */
public class CollectUsersFromSeedUser {
    private static String FRIENDS_LIST ="friendslist";
    private static String FRIENDS_ARRAY ="friends";
    private static String STEAM_ID ="steamid";
    private static String RELATIONSHIP ="relationship";
    private static String FRIEND_SINCE ="friend_since";

    public static void main(String[] args){
        String requestBase = "http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=";
        String apiKey = "";
        String seedUser = "76561197962943226";//unkron
        String additionalParams = "&steamid="+seedUser+"&relationship=friend";

        String requestString = requestBase+apiKey+additionalParams;

        //System.out.println(requestString);

        try{
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(requestString);

            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == 200){
                System.out.println("Received response for user: "+seedUser);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String output;
                while((output = reader.readLine())!=null){
                    System.out.println(output);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Map<String,String> parse(String jsonLine) {
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject(FRIENDS_LIST);
        JsonArray jarray = jobject.getAsJsonArray(FRIENDS_ARRAY);
        jobject = jarray.get(0).getAsJsonObject();
        String friendSteamId = jobject.get(STEAM_ID).toString();
        String relationship = jobject.get(RELATIONSHIP).toString();
        String friendSince = jobject.get(FRIEND_SINCE).toString();
        Map<String,String> result = new HashMap<String, String>();
        result.put(STEAM_ID,friendSteamId);
        result.put(RELATIONSHIP,relationship);
        result.put(FRIEND_SINCE,friendSince);
        return result;
    }
}
