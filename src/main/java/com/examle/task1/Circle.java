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
        gc.setFill(color);
        gc.fillOval(x, y, d, d);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, d, d);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.color + " and area is : " + area();
    }

}
