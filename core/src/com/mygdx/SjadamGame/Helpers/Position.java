package com.mygdx.SjadamGame.Helpers;

/**
 * Created by Anders-Hopland on 15.06.2017.
 */

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y> 8) {
            throw new IllegalStateException();
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 1 || x > 8) {
            throw new IllegalStateException();
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 1 || y > 8) {
            throw new IllegalStateException();
        }
        this.y = y;
    }
}


