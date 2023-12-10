package com.example.stickhero;

import java.util.Objects;

public class currRectangle extends Tower {
    private double x;
    private double y;
    private double width;
    private double height;
    private double distance;

    public currRectangle() {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.distance = distance;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        currRectangle that = (currRectangle) o;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0 && Double.compare(width, that.width) == 0 && Double.compare(height, that.height) == 0 && Double.compare(distance, that.distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height, distance);
    }

    @Override
    public String toString() {
        return "currRectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }
}
