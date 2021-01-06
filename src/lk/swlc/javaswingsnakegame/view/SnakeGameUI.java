/*
 *Time   :- 1:21 AM
 *Author :- Uvindu Mohotti
 *Special Thing :-
 */

package lk.swlc.javaswingsnakegame.view;

import lk.swlc.javaswingsnakegame.model.BoardSettingsOptions;
import lk.swlc.javaswingsnakegame.panel.BoardPanel;

import javax.swing.*;
import java.awt.*;

public class SnakeGameUI extends JFrame {

    //    Open Game

    public SnakeGameUI(final BoardSettingsOptions boardSettingsOptions) {
        super("~~~ Snake-Game ~~~");

        getContentPane().add(new BoardPanel(boardSettingsOptions));
        pack();

        setWindow();
    }

    /**
     * Open Windows Settings
     */
    private void setWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationInCenter();
        setVisible(true);
    }

    /**
     * Manage Windows Center on Screen
     */
    private void setLocationInCenter() {
        setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
    }
}
