/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public WeatherData(double temp, double tempMin, double tempMax, double windSpeed, double humidity, double clouds, String description){
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.clouds = clouds;
        this.description = description;
    }
    
    public double getTemp(){
        return this.temp;
    }
    
    public double getTempMin(){
        return this.tempMin;
    }
    
    public double getTempMax(){
        return this.tempMax;
    }
    
    public double getWindSpeed(){
        return this.windSpeed;
    }
    
    public double getHumidity(){
        return this.humidity;
    }
    
    public double getClouds(){
        return this.clouds;
    }
    
    public String getDescription(){
        return this.description;
    }
    
}
