package com.examle.task1;

import javafx.scene.paint.Color;

public class ShapeFactory {
    public Shape createShape(int numberOfSides, Color color) {
        if (numberOfSides == 0) {
            return new Circle(color, 40);
        } else if (numberOfSides == 3) {
            return new Triangle(color, 100, 80);
        } else if (numberOfSides == 4) {
            return new Rectangle(color, 100, 150);
        }
        else {
            return null;
        }
    }
}
