package hw8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;
    static public int WINDOW_X = (screenSize.width - WINDOW_WIDTH) / 2;
    static public int WINDOW_Y = (screenSize.height - WINDOW_HEIGHT) / 2;
    int s = screenSize.width;


    private SettingWindow settingWindow;
    private BattleMap battleMap;
    public GameOver gameOver;

    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        settingWindow = new SettingWindow(this);
        gameOver = new GameOver(this);
        battleMap = new BattleMap(this, gameOver);

        add(battleMap, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnStartNewGame = new JButton("Start New Game");
        panel.add(btnStartNewGame);
        JButton btnExit = new JButton("Exit");
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);

        btnStartNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleMap.startNewGame(mode, fieldSize, winningLength);
    }

}
