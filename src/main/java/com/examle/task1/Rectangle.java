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

        return length*width;   }

    @Override
    void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, length);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, width, length);
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.color +  "and area is : " + area();   }
}
