package com.examle.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {
    protected Color color;

    protected double x, y;


    abstract double area();

    abstract void draw(GraphicsContext gr);

    public Shape(Color color) {

        System.out.println("Shape constructor called");

        this.color = color;     }

    public void setColor(Color color) {

        this.color=color;     }
}
