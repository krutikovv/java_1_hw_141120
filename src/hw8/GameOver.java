package hw8;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame {
    private int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 200;
    private static final int WINDOW_HEIGHT = 100;
    private int WINDOW_X = GameWindow.WINDOW_X + (GameWindow.WINDOW_WIDTH - WINDOW_WIDTH) / 2;
    private int WINDOW_Y = GameWindow.WINDOW_Y + (GameWindow.WINDOW_HEIGHT - WINDOW_WIDTH) / 2;

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private JLabel labelWin = new JLabel();

    public GameOver(GameWindow gameWindow) {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Game over");
        setLayout(new GridLayout(1, 1));

        add(labelWin);

        setVisible(false);

    }

    public void setLabelWinText(String textLabel) {
        labelWin.setText(textLabel);
    }

    public void showGameOver(String text){
        setLabelWinText(text);
        setVisible(true);
    }
}
