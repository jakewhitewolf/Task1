package com.examle.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Rectangle extends Shape{
    double length;

    double width;


    public Rectangle(Color color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;  }

    @Override
    double area() {

        return length*width;
    }

    @Override
    void draw(GraphicsContext gc) {
        gc.setFill(fill);
        gc.fillRect(x, y, width, length);
        gc.setStroke(getStroke());
        gc.setLineWidth(getStrokeWidth());
        gc.strokeRect(x, y, width, length);
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.color +  "and area is : " + area();
    }

    @Override
    public boolean contains(double mx, double my) {
        return mx >= x && mx <= x + width && my >= y && my <= y + length;
    }
}
