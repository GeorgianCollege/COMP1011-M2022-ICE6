package ca.georgiancollege.comp1011m2022ice6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Vector2DCanvasController implements Initializable
{
    // class variables (private data members)
    private Vector2D start = new Vector2D();
    private Vector2D end = new Vector2D();
    private Color color = Color.BLACK;
    private float line_width = 1.0f;
    private float radius = 50.0f;
    private boolean filled = false;

    @FXML
    private Canvas canvas;

    @FXML
    private CheckBox circleFilledCheckBox;

    @FXML
    private ComboBox<Vector2D> endVectorComboBox;

    @FXML
    private Spinner<Double> lineWidthSpinner;

    @FXML
    private Spinner<Double> radiusSpinner;

    @FXML
    private ColorPicker shapeColorPicker;

    @FXML
    private ComboBox<Vector2D> startVectorComboBox;

    @FXML
    void circleFilledCheckBoxChanged(ActionEvent event)
    {
        filled = circleFilledCheckBox.isSelected();
    }

    @FXML
    void clearCanvasButtonClicked(ActionEvent event)
    {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    void drawCircleButtonClicked(ActionEvent event)
    {
        GraphicsContext context = canvas.getGraphicsContext2D();
        line_width = lineWidthSpinner.getValue().floatValue();
        radius = radiusSpinner.getValue().floatValue();
        Utility.Instance().DrawCircle(context, color, line_width, start, radius, filled);
    }

    @FXML
    void drawLineButtonClicked(ActionEvent event)
    {
        GraphicsContext context = canvas.getGraphicsContext2D();
        line_width = lineWidthSpinner.getValue().floatValue();
        Utility.Instance().DrawLine(context, color, line_width, start, end);
    }

    @FXML
    void drawRectangleButtonClicked(ActionEvent event)
    {
        GraphicsContext context = canvas.getGraphicsContext2D();
        Utility.Instance().DrawRect(context, color, start, end);
    }

    @FXML
    void shapeColorPickerChanged(ActionEvent event)
    {
        color = shapeColorPicker.getValue();
    }

    @FXML
    void endVector2DComboBoxChanged(ActionEvent event)
    {
        end = endVectorComboBox.getSelectionModel().getSelectedItem();
    }

    @FXML
    void startVector2DComboBoxChanged(ActionEvent event)
    {
        start = startVectorComboBox.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        // Get the Vector2D Data from the Database
        ArrayList<Vector2D> vectors = DBManager.Instance().readVectorTable();

        // Display the Vector2D Data in each ComboBox
        for(var vector: vectors)
        {
            startVectorComboBox.getItems().add(vector);
            endVectorComboBox.getItems().add(vector);
        }

        // Configured the Line Width Spinner
        Utility.Instance().ConfigureVector2DSpinner(lineWidthSpinner, 0.25f, 10.0f, 1.0f, 0.25f);

        // Configured the radius Spinner
        Utility.Instance().ConfigureVector2DSpinner(radiusSpinner, 1.0f, 200.0f, 50.0f, 5.0f);
    }
}