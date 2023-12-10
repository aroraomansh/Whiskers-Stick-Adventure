package com.example.stickhero;

import static org.junit.Assert.*;

public class AppTest {

    @org.junit.Test
    public void start() {
    }

    @org.junit.Test
    public void calculate() {
        Player player = Player.getInstance();
        assertNull(player);
    }

    @org.junit.Test
    public void main() {
        latestRectangle latestRectangle = new latestRectangle();
        assertTrue(latestRectangle.getX()>0);
    }


}