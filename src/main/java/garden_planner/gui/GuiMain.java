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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    private final GardenPlanner planner;
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

        VBox propertyBox = new VBox(5); // spacing 5 pixels between fields
        propertyBox.setStyle("-fx-padding: 10; -fx-background-color: #dddddd;");

        widthField = new TextField();
        TextField heightField = new TextField("???");
        TextField leftField = new TextField("???");
        TextField topField = new TextField("???");

        propertyBox.getChildren().addAll(
                new javafx.scene.control.Label("Width:"), widthField,
                new javafx.scene.control.Label("Height:"), heightField,
                new javafx.scene.control.Label("Left:"), leftField,
                new javafx.scene.control.Label("Top:"), topField
        );

        root.setRight(propertyBox); // Adds Propery box to scene, on the right side.

        for (RectBed bed : planner.getBeds()) {
            Rectangle rect = new Rectangle();

            rect.setX(bed.getLeft() * SCALE);
            rect.setY(bed.getTop() * SCALE);
            rect.setWidth(bed.getWidth() * SCALE);
            rect.setHeight(bed.getHeight() * SCALE);

            rect.setFill(Color.LIGHTBLUE);
            gardenPane.getChildren().add(rect);
        }

        RectBed first = planner.getBeds().get(0);
        widthField.setText(Double.toString(first.getWidth()));
        heightField.setText(Double.toString(first.getHeight()));
        leftField.setText(Double.toString(first.getLeft()));
        topField.setText(Double.toString(first.getTop()));

        Scene scene = new Scene(root, 1000, 500); // Add extra width to incorporate PropertyBox
        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(scene);
        primaryStage.show(); // Display scene

    }


    public static void main(String[] args) {
        launch(args);
    }
}
