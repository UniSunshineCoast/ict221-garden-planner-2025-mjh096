package garden_planner.gui;

import garden_planner.model.CircleBed;
import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    private TextArea summary;

    @FXML
    private Button addRect;

    @FXML
    private Button addCircle;

    @FXML
    public void initialize() {
        planner = new GardenPlanner();
        planner.createBasicDesign();

        garden.setStyle("-fx-background-color: #007700; -fx-background-image: url(\"grass.png\")");

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

        addRect.setOnAction(e -> {
            planner.getBeds().add(new RectBed());
            updateGUI();
        });

        addCircle.setOnAction(e -> {
            planner.getBeds().add(new CircleBed(1.0));
            updateGUI();
        });
    }

    public void updateGUI() {
        // Hook with a GardenPlanner instance
        // A default garden layout is created in the constructor
        garden.getChildren().clear();
        for (GardenBed bed : planner.getBeds()) {
            if (bed instanceof RectBed) {
                Rectangle rect = new Rectangle(bed.getWidth() * 100, bed.getHeight() * 100);
                rect.setX(bed.getLeft()*100);
                rect.setY(bed.getTop()*100);

                Image map = new Image("vege.jpg");
                ImagePattern pattern = new ImagePattern(map, 20, 20, 40, 40, false);
                rect.setFill(pattern);

                rect.setOnMouseDragged(ev -> {
                    // System.out.println("x=" + ev.getX() + " r=" + bed);
                    rect.setX(ev.getX());
                    rect.setY(ev.getY());
                    bed.setLeft(ev.getX() / 100); // scale is 100 to adjust the display
                    bed.setTop(ev.getY() / 100);
                });

                garden.getChildren().add(rect);
            } else if (bed instanceof CircleBed) {
                double radius = ((CircleBed) bed).getRadius();
                Circle cir = new Circle(radius * 100);
                cir.setCenterX((bed.getLeft()+radius)*100);
                cir.setCenterY((bed.getTop()+radius)*100);

                Image map = new Image("flowers.jpg");
                ImagePattern pattern = new ImagePattern(map, 20, 20, 40, 40, false);
                cir.setFill(pattern);

                cir.setOnMouseDragged(ev -> {
                    // System.out.println("x=" + ev.getX() + " r=" + bed);
                    cir.setCenterX(ev.getX());
                    cir.setCenterY(ev.getY());
                    bed.setLeft(ev.getX() / 100); // scale is 100 to adjust the display
                    bed.setTop(ev.getY() / 100);
                });

                garden.getChildren().add(cir);
            }
        }

        RectBed firstRect = (RectBed) planner.getBeds().get(0);
        area.setText(String.valueOf(firstRect.getArea()));
        perimeter.setText(String.valueOf(firstRect.getPerimeter()));

        planner.recalculateTotals();
        String summaryText = String.format("Total garden area is: %8.2f m2.\n " +
                "Total wall length is: %8.2f m.\n" +
                "Total soil required:  %8.2f m3.\n" +
                "Total garden cost is: $%7.2f.\n",
                planner.getTotalGardenArea(),
                planner.getTotalWallLength(),
                planner.getTotalGardenArea() * planner.SOIL_DEPTH,
                planner.getTotalCost()
        );

        summary.setText(summaryText);


    }

}