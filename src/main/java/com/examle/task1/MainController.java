package com.examle.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML private ColorPicker colorpicker;
    @FXML private Canvas canvas;

    private final List<Shape> shapes = new ArrayList<>();
    private final ShapeFactory shapeFactory = new ShapeFactory(); // <-- добавили

    private Momento temp;
    private double offsetX;
    private double offsetY;

    @FXML
    public void initialize() {
        canvas.setOnMousePressed(this::onBegin);
        canvas.setOnMouseDragged(this::onDrag);
        canvas.setOnMouseReleased(this::onEnd);
    }

    private void addShapeBySides(int numberOfSides, double x, double y) {
        Shape s = shapeFactory.createShape(numberOfSides, colorpicker.getValue());
        s.relocate(x, y);
        shapes.add(s);
        redraw();
    }

    @FXML
    protected void onRectangleClick() {
        addShapeBySides(4, 50, 30);
    }

    @FXML
    protected void onTriangleClick() {
        addShapeBySides(3, 50, 150);
    }

    @FXML
    protected void onCircleClick() {
        addShapeBySides(0, 100, 100);
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