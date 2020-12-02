/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weathersystem;

/**
 *
 * @author Chad
 */
public class WeatherData {
    
    private final double temp;
    private final double tempMin;
    private final double tempMax;
    private final double windSpeed;
    private final double humidity;
    private final double clouds;
    private final String description;
    
    public WeatherData(double temp, double tempMin, double tempMax, double windSpeed, double humidity, double clouds, String description){
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.clouds = clouds;
        this.description = description;
    }
    
    public void printInfo(){
        System.out.println("temp: " + temp);
        System.out.println("tempMin: " + tempMin);
        System.out.println("tempMax: " + tempMax);
        System.out.println("windSpeed: " + windSpeed);
        System.out.println("humidity: " + humidity);
        System.out.println("clouds: " + clouds);
        System.out.println("description: " + description);
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
