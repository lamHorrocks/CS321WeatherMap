/*
 * Copyright (c) 2012 , 2013 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * CS 321-02 Group 2 
 * Weather Map 
 * Dr. Stacy Lukins
 * This is the WeatherSystem Package below
 * This is where the application is formed, formatted and started to run
 */
package weathersystem;
/**
 * Below is where we import all the Panes, columns, images, buttons, text and font formatting.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Insets; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;

/**
 * Weather application provides a map and weather data for select cities
 * in northern Alabama.
 */
public class WeatherSystem extends Application {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stage) throws IOException {

        // Use a border pane as the root for scene
        //set weather pane
        setWeather(sCity);

        //set map pane
        border.setLeft(addCityPane(addMapPane()));

        //set title
        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("North Alabama Weather");
        stage.show();
    }

    
/**
 * Creates a grid for the map.
 * @return grid, a GridPane used to position cities relative to the map.
 */
    private GridPane addMapPane() throws IOException {

        GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(0);
        grid.getColumnConstraints().addAll(column1); // each get 50% of width

        // Map
        String image_path = "map.png";
        try (InputStream stream = new FileInputStream(image_path)) {
            ImageView imageMap = new ImageView(new Image(stream, 900, 900, true, true));
            grid.add(imageMap, 4, 4);   
        }
              
        return grid;
    }

/**
 * Creates an anchor pane using the provided grid and an HBox with buttons or 
 * hyperlinks and adds city links to map
 * 
 * @param pane, a GridPane to anchor to the top of the anchor pane
 * @return anchorpane, an AnchorPane used to position pane within the border.
 */
    private AnchorPane addCityPane(GridPane pane) {

        AnchorPane anchorpane = new AnchorPane();

        //Creates all buttons that represent the 
        Button hamilton = new Button("Hamilton");
        Button florence = new Button("Florence");
        Button huntsville = new Button("Huntsville");
        Button decatur = new Button("Decatur");
        Button scottsboro = new Button("Scottsboro");
        Button cullman = new Button("Cullman");
        Button fortpayne = new Button("Fort Payne");
        Button gadsden = new Button("Gadsden");
        
        Pane hb = new Pane();
        
        hb.getChildren().addAll(hamilton, florence, huntsville, decatur, scottsboro, cullman, fortpayne, gadsden);

        //Set fonts and locations for all buttons on the map
        hamilton.relocate(50,310);
        hamilton.setFont(Font.font("Arial", 18));
        
        florence.relocate(140,66);
        florence.setFont(Font.font("Arial", 18));
        
        huntsville.relocate(465,93);
        huntsville.setFont(Font.font("Arial", 18));
        
        decatur.relocate(360,139);
        decatur.setFont(Font.font("Arial", 18));
        
        scottsboro.relocate(640,114);
        scottsboro.setFont(Font.font("Arial", 18));
        
        cullman.relocate(400,297);
        cullman.setFont(Font.font("Arial", 18));
        
        fortpayne.relocate(725,199);
        fortpayne.setFont(Font.font("Arial", 18));
        
        gadsden.relocate(655,357);
        gadsden.setFont(Font.font("Arial", 18));
        
        
        //On clicked functionality for the buttons
        hamilton.setOnAction(e -> setWeather("Hamilton"));
        florence.setOnAction(e -> setWeather("Florence"));
        huntsville.setOnAction(e -> setWeather("Huntsville"));
        decatur.setOnAction(e -> setWeather("Decatur"));        
        scottsboro.setOnAction(e -> setWeather("Scottsboro"));
        cullman.setOnAction(e -> setWeather("Cullman"));        
        fortpayne.setOnAction(e -> setWeather("Fort Payne"));
        gadsden.setOnAction(e -> setWeather("Gadsden"));
        
        //Adds all of the buttons to the pane
        anchorpane.getChildren().addAll(pane,hb);
        
        return anchorpane;
    }
    
 /**
 * Creates a pane to list daily weather conditions for a given city.
 */
    private void addWeatherPane() {
        
        DateFormat dateFormat = new SimpleDateFormat("h:mm aa");
    	sTime = dateFormat.format(new Date());  
   
        //GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();    
        column1.setPercentWidth(0);

        //Setting the padding  
        weathergrid.setPadding(new Insets(10, 10, 10, 10)); 
        weathergrid.getColumnConstraints().addAll(column1); // each get 50% of width

        // Category in column 1, row 1
        Text city = new Text(sCity + ", AL Weather");
        city.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        weathergrid.add(city, 0, 0); 
        
        Text currentTime = new Text("as of " + sTime + " CST");
        currentTime.setFont(Font.font("Arial", FontWeight.LIGHT, 11));
        weathergrid.add(currentTime, 0, 1); 
        
        Text currentTemp = new Text(sTemp + "\u00B0");
        currentTemp.setFont(Font.font("Arial", FontWeight.BOLD, 55));
        weathergrid.add(currentTemp, 0, 2, 2, 3); 
        
        Text currentDesc = new Text(sCondition);
        currentDesc.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        weathergrid.add(currentDesc, 0, 5);
         
        Text currentForecast = new Text("\nToday's Forecast for \n" + sCity + ", AL\n");
        currentForecast.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        weathergrid.add(currentForecast, 0, 9);
        
        Text currentMin = new Text("Minimum Temperature\n" + minTemp + "\u00B0");
        currentMin.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        weathergrid.add(currentMin, 0, 10);
        
        Text currentMax = new Text("\nMaximum Temperature\n" + maxTemp + "\u00B0");
        currentMax.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        weathergrid.add(currentMax, 0, 11);
        
        weathergrid.setGridLinesVisible(false);
        
    }
    
    /**
    * Collects the data from the city forecast and sets it equal to the weather for the matching city. 
    * @param cityName, a String of the selected city.
    */
    private void setWeather(String cityName){
        
        WeatherData cityData = parser.getCityForecast(cityName);
        sCity = cityName;
        
        //use old data if api has reached max tries
        if(cityData.getTemp() != 0.0)
        {
            sTemp = cityData.getTemp();
            sCondition = cityData.getDescription();
            maxTemp = cityData.getTempMax();
            minTemp = cityData.getTempMin();
        }
        
        weathergrid.getChildren().clear();
        addWeatherPane();
        border.setRight(weathergrid);
        
       
    }

    private String sCity = "Huntsville";
    private String sTime = "";
    private double sTemp = 60;
    private String sCondition = "Clear";
    private double maxTemp = 68; 
    private double minTemp = 47;
    private final APIParser parser = new APIParser();
    private final GridPane weathergrid = new GridPane();;
    private final BorderPane border = new BorderPane();;
    
}
