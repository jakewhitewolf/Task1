package com.examle.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Triangle extends Shape {
    double base;
    double height;

    public Triangle(Color color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    void draw(GraphicsContext gc) {
        double[] xs = { x, x + base, x };
        double[] ys = { y, y, y - height };

        gc.setFill(color);
        gc.fillPolygon(xs, ys, 3);

        gc.setStroke(Color.BLACK);
        gc.strokePolygon(xs, ys, 3);
    }

    @Override
    public String toString() {
        return "Triangle color is " + super.color + " and area is : " + area();
    }
}
