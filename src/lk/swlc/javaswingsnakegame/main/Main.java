/*
 *Time   :- 1:22 PM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame.main;

import lk.swlc.javaswingsnakegame.model.BoardSettingsOptions;
import lk.swlc.javaswingsnakegame.view.SnakeGameUI;


import static lk.swlc.javaswingsnakegame.model.BoardSettingsOptions.*;

public class Main {

    public static void main(String[] args) {
        new SnakeGameUI(new BoardSettingsOptions(DOT_SIZE,
                DOTS_NUMBER_PER_DIMENSION,
                SNAKE_DOT_IMAGE_LOCATION,
                APPLE_IMAGE_LOCATION));
    }
}
