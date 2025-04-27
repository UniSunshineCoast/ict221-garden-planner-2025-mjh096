package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 * Sample solution for Lab 5 Section 7 Optional
 */
public class GuiMainOpt extends Application {

    GardenPlanner planner;
    TextField widthField;
    TextField heightField;

    public GuiMainOpt() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        BorderPane root = new BorderPane();

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #007700;");

        /* Create and add a rectangle shape to the pane
        Rectangle rec = new Rectangle(100, 100);
        pane.getChildren().add(rec);
        rec.setX(10);
        rec.setY(10);
        */

        // Hook with a GardenPlanner instance
        // A default garden layout is created in the constructor
        for (GardenBed bed : planner.getBeds()) {
            Rectangle rec = new Rectangle(bed.getWidth()*100, bed.getHeight()*100);
            rec.setX(bed.getLeft()*100);
            rec.setY(bed.getTop()*100);
            pane.getChildren().add(rec);
        }

        root.setCenter(pane);

        // Display the width and height of the first bed
        Pane leftPane = new VBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setStyle("-fx-background-color: #107700;");
        root.setLeft(leftPane);

        widthField = new TextField();
        double width = planner.getBeds().get(0).getWidth();
        String str = Double.toString(width);
        widthField.setText(str);
        leftPane.getChildren().add(widthField);

        heightField = new TextField();
        double height = planner.getBeds().get(0).getWidth();
        str = Double.toString(height);
        heightField.setText(str);
        leftPane.getChildren().add(heightField);

        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 960, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
