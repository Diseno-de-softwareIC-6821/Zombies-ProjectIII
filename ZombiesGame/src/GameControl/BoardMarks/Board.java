package GameControl.BoardMarks;

import GameControl.Settings;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Board {
    private Square[][] squares = new Square[Settings.NUM_SQUARES][Settings.NUM_SQUARES];
    private final Font FONT = new Font("Unispace", 0, 15);
    private final Color COLOR = new Color(10,10,10,50);
    private final Border BORDER = BorderFactory.createLineBorder(new Color(200,255,255, 20));
    public Board(){

    }
    public void buildBoard(JPanel xSpecs, JPanel ySpecs, JPanel board){
        int sizeXsquare = Settings.GAME_BOARD_SIZE / Settings.NUM_SQUARES;
        int panelWidth = xSpecs.getWidth(); // Will be the same panel yspecs
        for (int i = 0; i < Settings.NUM_SQUARES; i++) {
            for (int j = 0; j < Settings.NUM_SQUARES; j++) {
                JPanel panel = new JPanel();
                panel.setSize(sizeXsquare, sizeXsquare);
                panel.setLocation(i*sizeXsquare, j*sizeXsquare);
                panel.setBackground(COLOR);
                panel.setBorder(BORDER);
                squares[i][j] = new Square(i, j,panel);
                board.add(panel);
            }
            //Set up labels for x coordinates and y coordinates
            JLabel labelX = new JLabel();
            labelX.setForeground(Color.WHITE);
            labelX.setSize(panelWidth/2, sizeXsquare);
            labelX.setFont(FONT);
            labelX.setText(String.valueOf(i));
            JLabel labelY  = cloneLabel(labelX);
            labelX.setLocation(0, i*sizeXsquare);
            labelY.setLocation(i*sizeXsquare, 0);
            xSpecs.add(labelY);
            ySpecs.add(labelX);
        }

    }
    private JLabel cloneLabel(JLabel labelCloneable) {
        JLabel newLabel = new JLabel();
        newLabel.setForeground(labelCloneable.getForeground());
        newLabel.setSize(labelCloneable.getSize());
        newLabel.setFont(labelCloneable.getFont());
        newLabel.setText(labelCloneable.getText());
        return newLabel;
    }
}
