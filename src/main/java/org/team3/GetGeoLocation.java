package org.team3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.json.JSONArray;
import java.net.URLEncoder;

public class GetGeoLocation {

    public static String getCensusTract(String[] args) {
        try {

            String query = "benchmark=" + URLEncoder.encode("Public_AR_Current", "UTF-8") +
                    "&vintage=" + URLEncoder.encode("Current_Current", "UTF-8") +
                    "&address=" + URLEncoder.encode("700 E 7th St, St Paul, MN 55106", "UTF-8") +
                    "&format=" + URLEncoder.encode("json", "UTF-8");
            // create URL object
            URL url = new URL("https://geocoding.geo.census.gov/geocoder/geographies/onelineaddress?" + query);

            // create HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set request method to GET
            conn.setRequestMethod("GET");

            // read response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // parse JSON response
            JSONObject jsonObj = new JSONObject(response.toString());
            JSONObject result = jsonObj.getJSONObject("result");
            JSONArray addressMatches = result.getJSONArray("addressMatches");
            JSONObject firstMatch = addressMatches.getJSONObject(0);
            JSONObject geographies = firstMatch.getJSONObject("geographies");
            JSONArray census = geographies.getJSONArray("Census Tracts");
            JSONObject firstTract = census.getJSONObject(0);
            String tract = firstTract.getString("GEOID");

            return tract;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}
