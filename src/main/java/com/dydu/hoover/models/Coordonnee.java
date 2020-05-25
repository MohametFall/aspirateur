package com.dydu.hoover.models;


public class Coordonnee {
    /**
     * abcisse de la position
     */
    private int x;

    /**
     * ordonnée de la positiov
     */
    private int y;

    public Coordonnee(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x +","+ y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnee)) return false;
        Coordonnee that = (Coordonnee) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }


}
