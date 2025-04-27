package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));

        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 960, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
