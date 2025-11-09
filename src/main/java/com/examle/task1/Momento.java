package com.examle.task1;

import javafx.scene.paint.Color;

public class Momento {
    private final Shape shape;
    private final double width;
    private final Color color;

    public Momento(Shape state) {
        this.shape = state;
        this.width = state.getStrokeWidth();
        this.color = state.getStroke();
    }

    public Shape getState() {
        shape.setStrokeWidth(width);
        shape.setStroke(color);
        return shape;
    }

    public Shape initState() {
        shape.setStrokeWidth(2);
        shape.setStroke(Color.RED);
        return shape;
    }
}
