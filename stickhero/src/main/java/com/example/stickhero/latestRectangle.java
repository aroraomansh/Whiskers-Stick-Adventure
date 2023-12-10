package com.example.stickhero;

import java.util.Objects;

public class latestRectangle extends Tower {

    private double x;
    private double y;
    private double width;
    private double height;
    private double nextInstance;

    public latestRectangle() {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.nextInstance = nextInstance;
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

    public double getNextInstance() {
        return nextInstance;
    }

    public void setNextInstance(double nextInstance) {
        this.nextInstance = nextInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        latestRectangle that = (latestRectangle) o;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0 && Double.compare(width, that.width) == 0 && Double.compare(height, that.height) == 0 && Double.compare(nextInstance, that.nextInstance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y, width, height, nextInstance);
    }

    @Override
    public String toString() {
        return "latestRectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", nextInstance=" + nextInstance +
                '}';
    }
}
