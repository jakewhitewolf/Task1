package com.examle.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML private ColorPicker colorpicker;
    @FXML private Canvas canvas;

    private final List<Shape> shapes = new ArrayList<>();

    private Momento temp;
    private double offsetX;
    private double offsetY;

    @FXML
    public void initialize() {
        canvas.setOnMousePressed(this::onBegin);
        canvas.setOnMouseDragged(this::onDrag);
        canvas.setOnMouseReleased(this::onEnd);
    }

    @FXML
    protected void onRectangleClick() {
        Rectangle rectangle = new Rectangle(colorpicker.getValue(), 100, 150);
        rectangle.x = 50;
        rectangle.y = 30;
        shapes.add(rectangle);
        redraw();
    }

    @FXML
    protected void onTriangleClick() {
        Triangle t = new Triangle(colorpicker.getValue(), 100, 80);
        t.x = 50;
        t.y = 150;
        shapes.add(t);
        redraw();
    }

    @FXML
    protected void onCircleClick() {
        Circle c = new Circle(colorpicker.getValue(), 40);
        c.x = 100;
        c.y = 100;
        shapes.add(c);
        redraw();
    }

    private void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape s : shapes) {
            s.draw(gc);
        }
    }

    private Shape findShape(double mx, double my) {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            Shape s = shapes.get(i);
            if (s.contains(mx, my)) {
                return s;
            }
        }
        return null;
    }

    public void onBegin(MouseEvent e) {
        Shape s = findShape(e.getX(), e.getY());
        if (s == null) {
            temp = null;
            return;
        }

        temp = new Momento(s);

        temp.initState();

        shapes.remove(s);
        shapes.add(s);

        offsetX = e.getX() - s.x;
        offsetY = e.getY() - s.y;

        redraw();
    }

    public void onDrag(MouseEvent e) {
        if (temp == null) return;

        Shape s = temp.initState();
        s.relocate(e.getX() - offsetX, e.getY() - offsetY);

        redraw();
    }

    public void onEnd(MouseEvent e) {
        if (temp == null) return;

        Shape s = temp.getState();
        s.relocate(e.getX() - offsetX, e.getY() - offsetY);

        temp = null;

        redraw();
    }
}