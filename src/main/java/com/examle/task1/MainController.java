package com.examle.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class MainController {
    @FXML private ColorPicker colorpicker;
    @FXML private Canvas canvas;


    @FXML
    protected void onRectangleClick() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Rectangle rectangle=new Rectangle(colorpicker.getValue(), 100, 150);
        rectangle.x = 50;
        rectangle.y = 30;
        rectangle.draw(graphicsContext);
        System.out.println(rectangle.toString());
    }

    @FXML
    protected void onTriangleClick() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Triangle t = new Triangle(colorpicker.getValue(), 100, 80);
        t.x = 50;
        t.y = 150;
        t.draw(gc);
        System.out.println(t.toString());
    }

    @FXML
    protected void onCircleClick() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Circle c = new Circle(colorpicker.getValue(), 40);
        c.x = 100;
        c.y = 100;
        c.draw(gc);
        System.out.println(c.toString());
    }
}