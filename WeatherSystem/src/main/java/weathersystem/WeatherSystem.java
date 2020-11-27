
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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

/**
 * Sample application that shows examples of the different layout panes
 * provided by the JavaFX layout API.
 * The resulting UI is for demonstration purposes only and is not interactive.
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
        
        //HBox hbox = addHBox();
        //border.setLeft(hbox);
        //border.setLeft(addVBox());
        
// Add a stack to the HBox in the top region

    //addStackPane(hbox);  
    

// To see only the grid in the center, uncomment the following statement
// comment out the setCenter() call farther down        
//        border.setCenter(addGridPane());
        
// Choose either a TilePane or FlowPane for right region and comment out the
// one you aren't using        
        //border.setLeft(addFlowPane());
        //border.setRight(addTilePane());
        border.setRight(addWeatherPane());

        
// To see only the grid in the center, comment out the following statement
// If both setCenter() calls are executed, the anchor pane from the second
// call replaces the grid from the first call        
        border.setLeft(addAnchorPane(addGridPane()));

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("North Alabama Weather");
        stage.show();
    }

/*
 * Creates an HBox with two buttons for the top region
 */
    
    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

        //Button buttonCurrent = new Button("Current");
        //buttonCurrent.setPrefSize(100, 20);

        //Button buttonProjected = new Button("Projected");
        //buttonProjected.setPrefSize(100, 20);
        
        //hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        
        return hbox;
    }
    
/*
 * Creates a VBox with a list of links for the left region
 */
    private VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        Text title = new Text("Data");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);
        
        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Sales"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribution"),
            new Hyperlink("Costs")};

        for (int i=0; i<4; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
        
        return vbox;
    }

/*
 * Uses a stack pane to place links over map
 * 
 * @param hb HBox to add the stack to
 */
    private void addStackPane(HBox hb) {

        StackPane stack = new StackPane();

        Hyperlink huntsville = new Hyperlink("Huntsville");
         
        
        //Text helpText = new Text("Huntsvillexxxxxxxxxxxxxx");
        //helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        //helpText.setFill(Color.WHITE);
        //helpText.setStroke(Color.web("#7080A0")); 
        
        //stack.getChildren().addAll(helpIcon, helpText);
        stack.getChildren().addAll(huntsville);
        stack.setAlignment(Pos.TOP_LEFT);
        // Add offset to right for question mark to compensate for RIGHT 
        // alignment of all nodes
        StackPane.setMargin(huntsville, new Insets(0, 10, 0, 0));
        
        hb.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);
                
    }

/*
 * Creates a grid for the map
 */
    private GridPane addGridPane() throws IOException {

        GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(0);
        grid.getColumnConstraints().addAll(column1); // each get 50% of width

        // Map
        //TODO: erase city names from map.png
        String image_path = "map.png";
        try (InputStream stream = new FileInputStream(image_path)) {
            ImageView imageMap = new ImageView(new Image(stream, 900, 900, true, true));
            grid.add(imageMap, 4, 4);   
        }
              
        //grid.setGridLinesVisible(true);
        return grid;
    }

    /*
 * Creates a weather pane for the map
 */
    private GridPane addWeatherPane() throws IOException {

        GridPane grid = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(0);
        grid.getColumnConstraints().addAll(column1); // each get 50% of width

        //remove this image when implementing weather data
        String image_path = "weatherholder.png";
        try (InputStream stream = new FileInputStream(image_path)) {
            ImageView imageMap = new ImageView(new Image(stream, 480, 480, true, true));
            grid.add(imageMap, 4, 4);   
        }
        //end remove
        
        grid.setGridLinesVisible(true);
        return grid;
    }
    
/*
 * Creates a horizontal flow pane with eight icons in four rows
 */
    private FlowPane addFlowPane() throws IOException {

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

       
        ImageView pages[] = new ImageView[8];
        String path;
        for (int i=0; i<8; i++) {
            //path = "chart_"+(i+1)+".png";
            path = "chart_"+(i+1)+".png";
            try (InputStream stream = new FileInputStream(path)) {
                pages[i] = new ImageView(new Image(stream));
                flow.getChildren().add(pages[i]);
            }
        }

        return flow;
    }
    
/*
 * Creates a horizontal (default) tile pane with eight icons in four rows
 */
    private TilePane addTilePane() throws IOException {
        
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(5, 0, 5, 0));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(2);
        tile.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        String path;
        for (int i=0; i<8; i++) {
            path = "chart_"+(i+1)+".png";
            try (InputStream stream = new FileInputStream(path)) {
                pages[i] = new ImageView(new Image(stream));
                tile.getChildren().add(pages[i]);
            }
        }

        return tile;
    }
 
/*
 * Creates an anchor pane using the provided grid and an HBox with buttons
 * 
 * @param grid Grid to anchor to the top of the anchor pane
 */
    private AnchorPane addAnchorPane(GridPane grid) {

        AnchorPane anchorpane = new AnchorPane();
        
        //Button buttonSave = new Button("Save");
        //Button buttonCancel = new Button("Cancel");

        
        HBox hb = new HBox();
        //hb.setPadding(new Insets(0, 10, 10, 10));
        //hb.setSpacing(10);
        //hb.getChildren().addAll(buttonSave, buttonCancel);
        
        addStackPane(hb);

        anchorpane.getChildren().addAll(grid,hb);
        // Anchor buttons to bottom right, anchor grid to top
        //AnchorPane.setBottomAnchor(hb, 8.0);
        //AnchorPane.setRightAnchor(hb, 5.0);
        //AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
}