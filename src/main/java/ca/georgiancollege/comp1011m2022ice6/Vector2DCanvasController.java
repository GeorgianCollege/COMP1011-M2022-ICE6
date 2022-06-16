package ca.georgiancollege.comp1011m2022ice6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Vector2DCanvasController implements Initializable
{
    // class variables
    private Vector2D start = new Vector2D();
    private Vector2D end = new Vector2D();
    private Color color = Color.BLACK;
    private float line_width = 1.0f;

    @FXML
    private Canvas canvas;

    @FXML
    private ComboBox<Vector2D> endVectorComboBox;

    @FXML
    private Spinner<Double> lineWidthSpinner;

    @FXML
    private ColorPicker shapeColorPicker;

    @FXML
    private ComboBox<Vector2D> startVectorComboBox;

    @FXML
    void clearCanvasButtonClicked(ActionEvent event) {

    }

    @FXML
    void drawCircleButtonClicked(ActionEvent event)
    {

    }

    @FXML
    void drawLineButtonClicked(ActionEvent event)
    {

    }

    @FXML
    void drawRectangleButtonClicked(ActionEvent event)
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        GraphicsContext context = canvas.getGraphicsContext2D();

        context.setLineWidth(1.0);
        context.setStroke(Color.ORANGE);
        context.strokeLine(100, 100, 300, 300);
    }
}