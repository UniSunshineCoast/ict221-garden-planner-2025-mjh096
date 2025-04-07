package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public GuiMain() {
        planner = new GardenPlanner();
        planner.createBasicDesign(); // Setting up default beds
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));

        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        final int SCALE = 100;

        for (RectBed bed : planner.getBeds()) {
            Rectangle rect = new Rectangle();

            rect.setX(bed.getLeft() * SCALE);
            rect.setY(bed.getTop() * SCALE);
            rect.setWidth(bed.getWidth() * SCALE);
            rect.setHeight(bed.getHeight() * SCALE);

            rect.setFill(Color.LIGHTBLUE);
            root.getChildren().add(rect);
        }

        root.setStyle("-fx-background-color: #007700;");
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show(); // Display scene

    }


    public static void main(String[] args) {
        launch(args);
    }
}
