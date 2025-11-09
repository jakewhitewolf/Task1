package com.examle.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {
    protected Color color;

    protected double x, y;

    private double strokeWidth = 1;
    private Color stroke = Color.BLACK;

    protected Color fill;

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public Color getStroke() {
        return stroke;
    }

    public void setStroke(Color stroke) {
        this.stroke = stroke;
    }

    abstract double area();

    abstract void draw(GraphicsContext gr);

    public Shape(Color color) {

        System.out.println("Shape constructor called");

        this.color = color;
        this.fill = color;
    }

    public void setColor(Color color) {

        this.color=color;
    }

    public abstract boolean contains(double mx, double my);

    public void relocate(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

}
