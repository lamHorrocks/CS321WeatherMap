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

package weathersystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
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
        //launch(WeatherSystem.class, args);
        launch();
    }
    
    @Override
    public void start(Stage stage) throws IOException {

        // Use a border pane as the root for scene
        BorderPane border = new BorderPane();
        
        //set weather pane
        GridPane weathergrid = addWeatherPane();
        border.setRight(weathergrid);      
        
        //set map pane
        border.setLeft(addCityPane(addMapPane()));

        //set title
        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("North Alabama Weather");
        stage.show();
    }

    
/**
 * Creates a grid for the map
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
              
        //grid.setGridLinesVisible(true);
        return grid;
    }

/**
 * Creates an anchor pane using the provided grid and an HBox with buttons or 
 * hyperlinks and adds city links to map
 * 
 * @param grid Grid to anchor to the top of the anchor pane
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
        hamilton.setOnAction(e -> System.out.println("Hyperlink clicked"));
        florence.setOnAction(e -> System.out.println("Hyperlink clicked"));
        huntsville.setOnAction(e -> System.out.println("Hyperlink clicked"));
        decatur.setOnAction(e -> System.out.println("Hyperlink clicked"));        
        scottsboro.setOnAction(e -> System.out.println("Hyperlink clicked"));
        cullman.setOnAction(e -> System.out.println("Hyperlink clicked"));        
        fortpayne.setOnAction(e -> System.out.println("Hyperlink clicked"));
        gadsden.setOnAction(e -> System.out.println("Hyperlink clicked"));
        
        
        //Adds all of the buttons to the pane
        anchorpane.getChildren().addAll(pane,hb);
        
        return anchorpane;
    }
    
 /**
 * Creates a weather pane for the map
 */
    private GridPane addWeatherPane() throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("h:mm aa");
    	sTime = dateFormat.format(new Date());  
   
        GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();    
        column1.setPercentWidth(0);

    
        grid.getColumnConstraints().addAll(column1); // each get 50% of width

        // Category in column 1, row 1
        Text city = new Text(sCity + ", AL Weather");
        city.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        grid.add(city, 0, 0); 
        
        Text currentTime = new Text("as of " + sTime + " CST");
        currentTime.setFont(Font.font("Arial", FontWeight.LIGHT, 11));
        grid.add(currentTime, 0, 1); 
        
        Text currentTemp = new Text(sTemp + "\u00B0");
        currentTemp.setFont(Font.font("Arial", FontWeight.BOLD, 55));
        grid.add(currentTemp, 0, 2, 2, 3); 
        
        Text currentDesc = new Text(sCondition);
        currentDesc.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        grid.add(currentDesc, 0, 5); 
        
        Text currentWeatherUpdate = new Text(sWeather + "\n\n\n\n\n\n\n");
        currentWeatherUpdate.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        grid.add(currentWeatherUpdate, 0, 6); 
         
        Text currentForecast = new Text(sForecast + "\n");
        currentForecast.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        grid.add(currentForecast, 0, 9);
        
        Text currentMorningAfternoonForecast = new Text("Morning\t\tAfternoon\n" + morningTemp + "\u00B0\t\t\t" 
                + afternoonTemp + "\u00B0");
        currentMorningAfternoonForecast.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        grid.add(currentMorningAfternoonForecast, 0, 10);
                   
        Text currentEveningForecast = new Text("Evening\t\tOvernight\n" + eveningTemp + 
                "\u00B0\t\t\t" + overnightTemp + "\u00B0");
        currentEveningForecast.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        grid.add(currentEveningForecast, 1, 10);
        
        // House icon in column 1, rows 1-2
        String image_path = sImage;
        try (InputStream stream = new FileInputStream(image_path)) {
            ImageView imageHouse = new ImageView(new Image(stream));
            grid.add(imageHouse, 1, 2, 2, 3);
        }

        grid.setGridLinesVisible(false);
        
        return grid;
    }
    
    private String sCity = "Huntsville";
    private String sTime = "";
    private String sTemp = "70";
    private String sCondition = "Clear";
    private String sWeather = "5% chance of rain through 8 pm";
    private String sImage = "sunny.png";
    private String sForecast = "Today's Forecast for \n" + sCity + ", AL";
    private int morningTemp = 60; 
    private int afternoonTemp = morningTemp + 6 ;
    private int eveningTemp = morningTemp - 4;
    private int overnightTemp = morningTemp - 14;
    
}
