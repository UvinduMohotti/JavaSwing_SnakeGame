/*
 *Time   :- 1:58 AM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame.model;

import java.awt.*;

public class Snake {

    private final Image snakeDotImage;
    private final int dotSize;
    private int size;
    private final int[] xs;
    private final int[] ys;

    private Directions directions;

    public Snake(Image snakeDotImage,
                 final int dotSize,
                 final int maxSize,
                 final int startX) {

        this.snakeDotImage = snakeDotImage;
        this.dotSize = dotSize;
        size = 3;

        xs = new int[maxSize];
        ys = new int[xs.length];
        initCoords(startX);

        directions = Directions.RIGHT;
    }

    private void initCoords( int startX) {
        for (int dotIndex = 0; dotIndex < getSize(); dotIndex++) {
            xs[dotIndex] = startX - dotIndex * dotSize;
            ys[dotIndex] = startX;
        }
    }

    public Image getSnakeDotImage() {
        return snakeDotImage;
    }

    public int getSize() {
        return size;
    }

    public void incSize() {
        size++;
    }

    public int getX(int index) {
        return xs[index];
    }

    public int getY(int index) {
        return ys[index];
    }

    public void setX(int index, int value) {
        xs[index] = value;
    }

    public void setY(int index, int value) {
        ys[index] = value;
    }

    public void move() {
        moveTail();
        moveHead();
    }

    private void moveTail() {
        for (int i = getSize(); i > 0; i--) {
            setX(i, getX(i - 1));
            setY(i, getY(i - 1));
        }
    }

    private void moveHead() {
        if (isMovingLeft()) {
            xs[0] -= dotSize;
        } else if (isMovingRight()) {
            xs[0] += dotSize;
        } else if (isMovingUp()) {
            ys[0] -= dotSize;
        } else if (isMovingDown()) {
            ys[0] += dotSize;
        }
    }

    public void setMovingDirection(Directions direction) {
        directions = direction;
    }

    public boolean isMovingLeft() {
        return directions == Directions.LEFT;
    }

    public boolean isMovingUp() {
        return directions == Directions.UP;
    }

    public boolean isMovingRight() {
        return directions == Directions.RIGHT;
    }

    public boolean isMovingDown() {
        return directions == Directions.DOWN;
    }

    public int getMaxDotsNumber() {
        return xs.length;
    }
}
