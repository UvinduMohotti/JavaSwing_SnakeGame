/*
 *Time   :- 11:06 AM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame.model;

public final class BoardSettingsOptions {

    // normal board dot size and dimension of dot numbers
    public static final int DOT_SIZE = 16;
    public static final int DOTS_NUMBER_PER_DIMENSION = 40;

    //image location/path
    public static final String APPLE_IMAGE_LOCATION = "images.png";
    public static final String SNAKE_DOT_IMAGE_LOCATION = "snakeicon.png";

    // variable declaration for board
    private final int dotSize;
    private final int windowSizePerDimension;
    private final int allDotsNumber;

    private final String snakeDotImageLocation;
    private final String appleImageLocation;

    //constructor
    public BoardSettingsOptions(
            int dotSize,
            int dotNumberPerDimension,
            String snakeDotImageLocation,
            String appleImageLocation) {

        this.dotSize = dotSize;

        windowSizePerDimension = this.dotSize * dotNumberPerDimension;
        allDotsNumber = (int) Math.pow(dotNumberPerDimension, 2);

        this.snakeDotImageLocation = snakeDotImageLocation;
        this.appleImageLocation = appleImageLocation;
    }

    public int getDotSize() {
        return dotSize;
    }

    public int getWindowSizePerDimension() {
        return windowSizePerDimension;
    }

    public int getAllDotsNumber() {
        return allDotsNumber;
    }

    public String getSnakeDotImageLocation() {
        return snakeDotImageLocation;
    }

    public String getAppleImageLocation() {
        return appleImageLocation;
    }
}
