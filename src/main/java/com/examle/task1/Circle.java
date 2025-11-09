package com.examle.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Circle extends Shape {
    double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    void draw(GraphicsContext gc) {
        double d = radius * 2;
        gc.setFill(fill);
        gc.fillOval(x, y, d, d);
        gc.setStroke(getStroke());
        gc.setLineWidth(getStrokeWidth());
        gc.strokeOval(x, y, d, d);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.color + " and area is : " + area();
    }

    @Override
    public boolean contains(double mx, double my) {
        double cx = x + radius;
        double cy = y + radius;
        double dx = mx - cx;
        double dy = my - cy;
        return dx * dx + dy * dy <= radius * radius;
    }

}
