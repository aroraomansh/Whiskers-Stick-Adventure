package com.example.stickhero;

import java.util.Objects;

public class Tower {
    private double defaultX;
    private double defaultY;
    private double standardWidth;
    private double baseHeight;
    private double distance;

    public double getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(double defaultX) {
        this.defaultX = defaultX;
    }

    public double getDefaultY() {
        return defaultY;
    }

    public void setDefaultY(double defaultY) {
        this.defaultY = defaultY;
    }

    public double getStandardWidth() {
        return standardWidth;
    }

    public void setStandardWidth(double standardWidth) {
        this.standardWidth = standardWidth;
    }

    public double getBaseHeight() {
        return baseHeight;
    }

    public void setBaseHeight(double baseHeight) {
        this.baseHeight = baseHeight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Tower() {
        this.defaultX = defaultX;
        this.defaultY = defaultY;
        this.standardWidth = standardWidth;
        this.baseHeight = baseHeight;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tower tower = (Tower) o;
        return Double.compare(defaultX, tower.defaultX) == 0 && Double.compare(defaultY, tower.defaultY) == 0 && Double.compare(standardWidth, tower.standardWidth) == 0 && Double.compare(baseHeight, tower.baseHeight) == 0 && Double.compare(distance, tower.distance) == 0;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "defaultX=" + defaultX +
                ", defaultY=" + defaultY +
                ", standardWidth=" + standardWidth +
                ", baseHeight=" + baseHeight +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultX, defaultY, standardWidth, baseHeight, distance);


    }
}

