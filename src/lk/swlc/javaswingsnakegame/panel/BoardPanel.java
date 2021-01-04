/*
 *Time   :- 1:40 AM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame.panel;

import lk.swlc.javaswingsnakegame.model.BoardSettingsOptions;
import lk.swlc.javaswingsnakegame.model.Directions;
import lk.swlc.javaswingsnakegame.model.DogObjectModel;
import lk.swlc.javaswingsnakegame.model.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class BoardPanel extends JPanel implements ActionListener {

    private final int dotSize;

    private final DogObjectModel dogObjectModel;
    private final Random random;

    private Snake snake;

    private boolean isPlaying;
    private Timer timer;

    public BoardPanel(final BoardSettingsOptions settings) {
        dotSize = settings.getDotSize();
        dogObjectModel = new DogObjectModel(new ImageIcon(settings.getAppleImageLocation()).getImage());
        random = new Random();
        snake = new Snake(new ImageIcon(settings.getSnakeDotImageLocation()).getImage(),
                dotSize, settings.getAllDotsNumber(), getWidth() / 2);
        isPlaying = true;
        timer = new Timer(100, this);

        addKeyListener(new FieldKeyListener());

        setSize(new Dimension(settings.getWindowSizePerDimension(), settings.getWindowSizePerDimension()));
        setPreferredSize(getSize());
        setBackground(Color.WHITE);
        setFocusable(true);
        setVisible(true);

        startGame();
    }

    private void startGame() {
        isPlaying = true;
        timer.start();

        snake = new Snake(
                snake.getSnakeDotImage(),
                dotSize,
                snake.getMaxDotsNumber(),
                getWidth() / 2);

        randomAppleCoords();
    }

    private void randomAppleCoords() {
        dogObjectModel.setX(random.nextInt(getWidth() / dotSize) * dotSize);
        dogObjectModel.setY(random.nextInt(getHeight() / dotSize) * dotSize);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isPlaying
                && !isBadCollision()) {

            if (isAppleCollision()) {
                snake.incSize();
                randomAppleCoords();
            }

            snake.move();
        }

        repaint();
    }

    private boolean isBadCollision() {
        return isSnakeCollision() || isBorderCollision();
    }

    private boolean isSnakeCollision() {
        for (int i = snake.getSize(); i > 0; i--) {
            if (i > 4
                    && snake.getX(0) == snake.getX(i)
                    && snake.getY(0) == snake.getY(i)) {

                isPlaying = false;
                return true;
            }
        }

        return false;
    }

    private boolean isBorderCollision() {
        if (snake.getX(0) >= getWidth()
                || snake.getX(0) < 0
                || snake.getY(0) >= getHeight()
                || snake.getY(0) < 0) {

            isPlaying = false;
            return true;
        }

        return false;
    }

    private boolean isAppleCollision() {
        return snake.getX(0) == dogObjectModel.getX()
                && snake.getY(0) == dogObjectModel.getY();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        if (isPlaying) {
            drawSnake(gr);
            drawApple(gr);
        } else {
            timer.stop();
            drawGameOver(gr);
        }
    }

    private void drawSnake(Graphics gr) {
        for (int snakeDot = 0; snakeDot < snake.getSize(); snakeDot++) {
            gr.drawImage(snake.getSnakeDotImage(), snake.getX(snakeDot), snake.getY(snakeDot), this);
        }
    }

    private void drawApple(Graphics gr) {
        gr.drawImage(dogObjectModel.getImage(), dogObjectModel.getX(), dogObjectModel.getY(), this);
    }

    private void drawGameOver(Graphics gr) {
        gr.setColor(Color.black);
        gr.drawString("End Game ! Press Enter Play again !", getWidth() / 3, getHeight() / 2);

    }

    private class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent ev) {
            super.keyPressed(ev);
            int key = ev.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !snake.isMovingRight()) {
                snake.setMovingDirection(Directions.LEFT);
            } else if (key == KeyEvent.VK_RIGHT && !snake.isMovingLeft()) {
                snake.setMovingDirection(Directions.RIGHT);
            } else if (key == KeyEvent.VK_UP && !snake.isMovingDown()) {
                snake.setMovingDirection(Directions.UP);
            } else if (key == KeyEvent.VK_DOWN && !snake.isMovingUp()) {
                snake.setMovingDirection(Directions.DOWN);
            } else if (key == KeyEvent.VK_ENTER && !isPlaying) {
                startGame();
            }
        }
    }
}
