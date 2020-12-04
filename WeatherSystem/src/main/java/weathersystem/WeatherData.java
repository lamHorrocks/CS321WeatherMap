/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * CS 321-02 Group 2 
 * Weather Map 
 * Dr. Stacy Lunkins
 * This is the WeathData Package below
 * This is where the data is collected and stored from the API for the WeatherSystem to use
 */
package weathersystem;

/**
 * This class holds all the weatherdata that is collected from the api and sets the varaibles
 * @author Chad
 */
public class WeatherData {
    
    private double temp;
    private double tempMin;
    private double tempMax;
    private double windSpeed;
    private double humidity;
    private double clouds;
    private String description;
/**
 * The below block is where the data collected from the API is set too the matching variable
 * 
 * @param temp this is the variable that holds the collected temp data
 * @param tempMin this is the variable that holds the collected tempMin data
 * @param tempMax this is the variable that holds the collected tempMax data
 * @param windSpeed this is the variable that holds the collected windSpeed data
 * @param humidity this is the variable that holds the collected humidity data
 * @param clouds this is the variable that holds the collected clouds data
 * @param description this is the variable that holds the collected description data
 */    
    public WeatherData(double temp, double tempMin, double tempMax, double windSpeed, double humidity, double clouds, String description){
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.clouds = clouds;
        this.description = description;
    }
/**
 * Collects the Temperature Data from the API and returns it to the variable temp
 * @author Chad
 */    
    public double getTemp(){
        return this.temp;
    }
/**
 * Collects the Temperature Minimum Data from the API and returns it to the variable tempMin
 * @author Chad
 */      
    public double getTempMin(){
        return this.tempMin;
    }
/**
 * Collects the Temperature Maximum Data from the API and returns it to the variable tempMax
 * @author Chad
 */     
    public double getTempMax(){
        return this.tempMax;
    }
/**
 * Collects the Wind Speed Data from the API and returns it to the variable windSpeed
 * @author Chad
 */  
    public double getWindSpeed(){
        return this.windSpeed;
    }
/**
 * Collects the Humidity Data from the API and returns it to the variable humidity
 * @author Chad
 */   
    public double getHumidity(){
        return this.humidity;
    }
/**
 * Collects the Clouds Data from the API and returns it to the variable clouds
 * @author Chad
 */    
    public double getClouds(){
        return this.clouds;
    }
/**
 * Collects the description data as a string that is then returned to the description variable
 * @author Chad
 */     
    public String getDescription(){
        return this.description;
    }
    
}
