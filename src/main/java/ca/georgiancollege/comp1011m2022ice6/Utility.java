package ca.georgiancollege.comp1011m2022ice6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Vector;

/* Singleton */
public final class Utility
{
    // Step 1. - Create a private static instance member variable
    private static Utility m_instance = null;

    // Step 2. - Make the default constructor private
    private Utility()  {}

    // Step 3. - Create a public static access method that returns an instance of the class
    public static Utility Instance()
    {
        // Step 4. - ensure that your instance member variable is null
        if(m_instance == null)
        {
            // Step 5. - create an instance of the class and save a reference int the private variable
            m_instance = new Utility();
        }
        // Step 5. - return an instance (reference) of the class
        return m_instance;
    }

    /*
     * This method returns the distance from start to end
     *
     * @param start - start vector2D
     * @param end - ending vector2D
     * */
    public float Distance(Vector2D start, Vector2D end)
    {
        float diffXs = end.getX() - start.getX();
        float diffYs = end.getY() - start.getY();
        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);
    }


    public float Distance(float x1, float y1, float x2, float y2)
    {
        float diffXs = x2 - x1;
        float diffYs = y2 - y1;
        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);
    }

    /**
     * This is a helper method that configures a spinner of type Double for a Vector2D component (e.g. x or y)
     * @param spinner
     * @param min
     * @param max
     * @param default_value
     * @param increment_value
     */
    public void ConfigureVector2DSpinner(Spinner<Double> spinner, double min, double max, double default_value, double increment_value)
    {
        // Configure each spinner
        // Step 1. Define a SpinnerValueFactory
        SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, default_value, increment_value);
        // Step 2. Set Value factory
        spinner.setValueFactory(spinnerValueFactory);
        // Step 3. get access to the Spinner's TextField
        TextField spinnerTextField = spinner.getEditor();
        // Step 4. create an Event Listener / Event Handler -> Observer Pattern
        spinnerTextField.textProperty().addListener( (observable, oldValue, newValue) ->
        {
            try
            {
                Float.parseFloat(newValue);
            }
            catch (Exception e)
            {
                spinnerTextField.setText(oldValue);
            }
        });
    }

    /**
     * This method Draws a Line with various options
     * @param context
     * @param color
     * @param line_width
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void DrawLine(GraphicsContext context, Color color, float line_width, float x1, float y1, float x2, float y2)
    {
        context.setStroke(color);
        context.setLineWidth(line_width);
        context.strokeLine(x1, y1, x2, y2);
    }

    /**
     * This method Draws a Line with various options
     * @param context
     * @param color
     * @param line_width
     * @param start
     * @param end
     */
    public void DrawLine(GraphicsContext context, Color color, float line_width, Vector2D start, Vector2D end)
    {
        DrawLine(context, color, line_width, start.getX(), start.getY(), end.getX(), end.getY());
    }

    /**
     * This method draws a Filled Rectangle
     * @param context
     * @param color
     * @param x1
     * @param y1
     * @param width
     * @param height
     */
    public void DrawRect(GraphicsContext context, Color color, float x1, float y1, float width, float height)
    {
        context.setFill(color);
        context.fillRect(x1, y1, width, height);
    }

    /**
     * This method draws a Filled Rectangle
     * @param context
     * @param color
     * @param top_left
     * @param bottom_right
     */
    public void DrawRect(GraphicsContext context, Color color, Vector2D top_left, Vector2D bottom_right)
    {
        float width = bottom_right.getX() - top_left.getX();
        float height = bottom_right.getY() - top_left.getY();
        DrawRect(context, color, top_left.getX(), top_left.getY(), width, height);
    }

    /**
     * This method draws a Circle
     * @param context
     * @param color
     * @param line_width
     * @param center_x
     * @param center_y
     * @param radius
     * @param filled
     */
    public void DrawCircle(GraphicsContext context, Color color, float line_width, float center_x, float center_y, float radius, boolean filled)
    {
        Vector2D top_left = new Vector2D(center_x - radius, center_y - radius);
        float width = radius * 2.0f;
        float height = radius * 2.0f;

        if(filled)
        { /* filled circle */
            context.setFill(color);
            context.fillOval(top_left.getX(), top_left.getY(), width, height);
        }
        else
        { /* simple circle - no fill */
            context.setStroke(color);
            context.setLineWidth(line_width);
            context.strokeOval(top_left.getX(), top_left.getY(), width, height);
        }
    }

    /**
     * This method draws a Circle
     * @param context
     * @param color
     * @param line_width
     * @param center
     * @param radius
     * @param filled
     */
    public void DrawCircle(GraphicsContext context, Color color, float line_width, Vector2D center, float radius, boolean filled)
    {
        DrawCircle(context, color, line_width, center.getX(), center.getY(), radius, filled);
    }
}