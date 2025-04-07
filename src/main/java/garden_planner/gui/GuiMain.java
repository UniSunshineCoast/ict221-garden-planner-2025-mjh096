package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    private GardenPlanner planner;
    private TextField widthField;

    public GuiMain() {
        planner = new GardenPlanner();
        planner.createBasicDesign(); // Setting up default beds
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        final int SCALE = 100;

        Pane gardenPane = new Pane();
        gardenPane.setStyle("-fx-background-color: #007700;");

        BorderPane root = new BorderPane();
        root.setCenter(gardenPane);

        widthField = new javafx.scene.control.TextField("Cool Text");
        root.setBottom(widthField);

        for (RectBed bed : planner.getBeds()) {
            Rectangle rect = new Rectangle();

            rect.setX(bed.getLeft() * SCALE);
            rect.setY(bed.getTop() * SCALE);
            rect.setWidth(bed.getWidth() * SCALE);
            rect.setHeight(bed.getHeight() * SCALE);

            rect.setFill(Color.LIGHTBLUE);
            gardenPane.getChildren().add(rect);
        }


        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(scene);
        primaryStage.show(); // Display scene

    }


    public static void main(String[] args) {
        launch(args);
    }
}
