/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weathersystem;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import com.jayway.jsonpath.*;

/**
 *
 * @author Chad
 */
public class APIParser {
    
    private String cityNames[] = {"Florence", "Hamilton", "Decatur", "Cullman", "Huntsville", "Scottsboro", "Fort Payne", "Gadsden"};
    
    public WeatherData getCityForecast(String cityName){
        
        double temp = 0, tempMin = 0, tempMax = 0, windSpeed = 0, humidity = 0, clouds = 0;
        String description = "";
        
        cityName = URLEncoder.encode(cityName);
        
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://community-open-weather-map.p.rapidapi.com/weather?q=" + cityName + "%2Cus&units=imperial"))
		.header("x-rapidapi-key", "d684e917d3msh87ecd7c7d586ee4p17009ajsn1966fbdfe9f5")
		.header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        try{
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            
            String jsonresponse = response.body();
            System.out.println(jsonresponse);            
            var parser = JsonPath.parse(jsonresponse);
            
            temp = parser.read("$.main.temp", Double.class);
            tempMin = parser.read("$.main.temp_min", Double.class);
            tempMax = parser.read("$.main.temp_max", Double.class);
            humidity = parser.read("$.main.humidity", Double.class);
            windSpeed = parser.read("$.wind.speed", Double.class);
            clouds = parser.read("$.clouds.all", Double.class);
            description = parser.read("$.weather[0].description");
        } catch(Exception e){
            System.out.println("ERROR: Could not retrieve data, try again in one minute\n" + e);
        }
        
        WeatherData forecast = new WeatherData(temp, tempMin, tempMax, windSpeed, humidity, clouds, description);
        
        return forecast;
    }
    
    public List<WeatherData> getMapForecast(){
        
        List<WeatherData> forecasts = new ArrayList<>();
        
        for(int i = 0; i < cityNames.length; i++){
            forecasts.add(getCityForecast(cityNames[i]));
        }
        
        return forecasts;
    }
    
}
