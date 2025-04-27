package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Controller {
    GardenPlanner planner;

    @FXML
    private Pane garden; // This is automatically linked to the widget defined in .fxml with the ID 'garden'

    @FXML
    private TextField width;

    @FXML
    private TextField height;

    @FXML
    private TextField area;

    @FXML
    private TextField perimeter;

    @FXML
    public void initialize() {
        planner = new GardenPlanner();
        planner.createBasicDesign();

        garden.setStyle("-fx-background-color: #007700;");

        updateGUI();
        RectBed firstRect = (RectBed) planner.getBeds().get(0);
        width.setText(String.valueOf(firstRect.getWidth()));
        height.setText(String.valueOf(firstRect.getHeight()));


        width.textProperty().addListener(e -> {
            double widthValue = Double.parseDouble(width.getText());
            firstRect.setWidth(widthValue);

            updateGUI();
        });

        height.textProperty().addListener(e -> {
            double heightValue = Double.parseDouble(height.getText());
            firstRect.setHeight(heightValue);

            updateGUI();
        });
    }

    public void updateGUI() {
        // Hook with a GardenPlanner instance
        // A default garden layout is created in the constructor
        garden.getChildren().clear();
        for (GardenBed bed : planner.getBeds()) {
            Rectangle rec = new Rectangle(bed.getWidth()*100, bed.getHeight()*100);
            rec.setX(bed.getLeft()*100);
            rec.setY(bed.getTop()*100);
            garden.getChildren().add(rec);
        }

        RectBed firstRect = (RectBed) planner.getBeds().get(0);
        area.setText(String.valueOf(firstRect.getArea()));
        perimeter.setText(String.valueOf(firstRect.getPerimeter()));


    }

}