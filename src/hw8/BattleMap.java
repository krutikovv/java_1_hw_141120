package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;
    private GameOver gameOver;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public BattleMap(GameWindow gameWindow, GameOver gameOver) {
        this.gameWindow = gameWindow;
        this.gameOver = gameOver;

        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (Logic.gameFinished == 0) {
                    Logic.humanTurn(cellX, cellY);
                    // тут можете проверить кто победил и вывести результат графически
                    // например через gameWindow
                }
                if (Logic.gameFinished > 0 && Logic.gameFinished < 4){
                    gameOver.showGameOver(Logic.resultStrings[Logic.gameFinished - 1]);
                }
                repaint();
            }
        });
    }



    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g, j, i);
                }
            }
        }
        if (Logic.gameFinished == 1 || Logic.gameFinished == 2) {
            int tempCell0;
            int tempCellX0;
            int tempCellY0;
            int tempCell1;
            int tempCellX1;
            int tempCellY1;
            tempCell0 = Integer.parseInt(Logic.winMassive[0].toString());
            tempCell1 = Integer.parseInt(Logic.winMassive[Logic.winMassive.length - 1].toString());
            tempCellX0 = tempCell0 / 10;
            tempCellY0 = tempCell0 % 10;
            tempCellX1 = tempCell1 / 10;
            tempCellY1 = tempCell1 % 10;

            drawWinLine(g, tempCellY0, tempCellX0, tempCellY1, tempCellX1, Logic.winMassive.length);
        }


//        ((Graphics2D)g).setStroke(new BasicStroke(5));
//        g.setColor(Color.RED);
//        g.drawString("qweqweqwe", 200, 200);

//        g.drawLine(100, 100, 400, 400);
//        g.drawOval(100, 100, 300, 300);
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellX * cellWidth + 10, cellY * cellHeight + 10,
                (cellX + 1) * cellWidth - 10, (cellY + 1) * cellHeight - 10);
        g.drawLine((cellX + 1) * cellWidth - 10, cellY * cellHeight + 10,
                cellX * cellWidth + 10, (cellY + 1) * cellHeight - 10);

    }
    private void drawO(Graphics g, int cellX, int cellY){
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.GREEN);
        g.drawOval(cellX * cellWidth + 10,
                   cellY * cellHeight + 10,
                    cellWidth - 20,
                    cellHeight - 20);
    }
    private void drawWinLine(Graphics g, int cellX1, int cellY1, int cellX2, int cellY2, int num){
        ((Graphics2D) g).setStroke(new BasicStroke(15));
        g.setColor(Color.BLACK);
        g.drawLine(cellX1 * cellWidth + cellWidth / 2, cellY1 * cellHeight + cellHeight / 2,
                   cellX2 * cellWidth + cellWidth / 2, cellY2 * cellHeight + cellHeight / 2);

    }
}
