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
import java.util.ArrayList;
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



        //GraphicsContext context = canvas.getGraphicsContext2D();


    }
}