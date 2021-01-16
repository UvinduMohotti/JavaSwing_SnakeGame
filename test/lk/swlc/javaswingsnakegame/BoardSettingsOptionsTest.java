/*
 *Time   :- 4:39 PM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame;

import lk.swlc.javaswingsnakegame.model.BoardSettingsOptions;
import org.junit.Test;

import static lk.swlc.javaswingsnakegame.model.BoardSettingsOptions.*;
import static org.junit.Assert.*;

public class BoardSettingsOptionsTest {
    BoardSettingsOptions boardSettingsOptions= new BoardSettingsOptions(DOT_SIZE,
                                                  DOTS_NUMBER_PER_DIMENSION,
                                                  SNAKE_DOT_IMAGE_LOCATION,
                                                  APPLE_IMAGE_LOCATION);

    @Test
    public void TestgetDotSize() {
        assertEquals(16,boardSettingsOptions.getDotSize());
    }

    @Test
    public void TestgetWindowSizePerDimension() {
        assertEquals(boardSettingsOptions.getDotSize()*DOTS_NUMBER_PER_DIMENSION,boardSettingsOptions.getWindowSizePerDimension());
    }

    @Test
    public void TestgetAllDotsNumber() {
        assertEquals((int) Math.pow(DOTS_NUMBER_PER_DIMENSION, 2),boardSettingsOptions.getAllDotsNumber());
    }

    @Test
    public void TestgetSnakeDotImageLocation() {
        assertEquals(SNAKE_DOT_IMAGE_LOCATION,boardSettingsOptions.getSnakeDotImageLocation());
    }
    @Test
    public void TestgetAppleImageLocation() {
        assertEquals(APPLE_IMAGE_LOCATION,boardSettingsOptions.getAppleImageLocation());
    }


}
