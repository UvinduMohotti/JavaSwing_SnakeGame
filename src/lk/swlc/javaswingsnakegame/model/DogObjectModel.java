/*
 *Time   :- 1:36 AM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame.model;

import java.awt.*;

public final class DogObjectModel {
    private Image image;
    private int x;
    private int y;

    public DogObjectModel(Image image) {
        this.image = image;
        x=0;
        y=0;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
        return "DogObjectModel{" +
                "image=" + image +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
