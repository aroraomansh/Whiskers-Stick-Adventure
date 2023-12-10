package com.example.stickhero;

public class Towers {

    //implement factory pattern
    public static Tower getTower(String towerType) {

        if (towerType == null) {
            return null;
        }

        if (towerType.equalsIgnoreCase("SQUARE")) {
            return new currRectangle();
        } else if (towerType.equalsIgnoreCase("CIRCLE")) {
            return new latestRectangle();
        } else if (towerType.equalsIgnoreCase("TRIANGLE")) {
            return new Tower();
        }

        return null;
    }
}
