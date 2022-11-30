package ZombiesGame.GUI.GameControl.BoardMarks;

import ZombiesGame.GUI.GameControl.Settings;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    private LinkedList<JLabel> labelsY = new LinkedList<>();
    private LinkedList<JLabel> labelsX = new LinkedList<>();
    private JLabel lifeTreeImage = new JLabel();
    private Square[][] squares = new Square[Settings.NUM_SQUARES][Settings.NUM_SQUARES];
    private final Font FONT = new Font("Unispace", 0, 15);
    private final Color COLOR = new Color(10,10,10,50);
    private final Border BORDER = BorderFactory.createLineBorder(new Color(200,255,255, 20));
    public Board(){}
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
            labelX.setBackground(Color.BLACK);
            JLabel labelY  = cloneLabel(labelX);
            labelX.setLocation(0, i*sizeXsquare);
            labelY.setLocation(i*sizeXsquare, 0);
            labelsX.add(labelX);
            labelsY.add(labelY);
            xSpecs.add(labelY);
            ySpecs.add(labelX);
        }

    }
    public Square getSquare(int x, int y){
        return squares[x][y];
    }
    public ArrayList<Square> getSquaresList(){
        ArrayList<Square> squares = new ArrayList<>();
        for(int i = 0; i < Settings.NUM_SQUARES; i++){
            for(int j = 0; j < Settings.NUM_SQUARES; j++){
                squares.add(this.squares[i][j]);
            }
        }
        return squares;
    }
    private JLabel cloneLabel(JLabel labelCloneable) {
        JLabel newLabel = new JLabel();
        newLabel.setForeground(labelCloneable.getForeground());
        newLabel.setSize(labelCloneable.getSize());
        newLabel.setFont(labelCloneable.getFont());
        newLabel.setText(labelCloneable.getText());
        return newLabel;
    }

    public void paintLifeTree(JPanel pboard){
        ImageIcon image = new ImageIcon(Settings.LIGFE_TREE_ROUTE);
        lifeTreeImage.setBounds(
                (pboard.getWidth()/2)-2*(Settings.GAME_BOARD_SIZE/Settings.NUM_SQUARES),
                (pboard.getHeight()/2)- (4*(Settings.GAME_BOARD_SIZE/Settings.NUM_SQUARES)/2),
                3*(Settings.GAME_BOARD_SIZE/Settings.NUM_SQUARES),
                3*(Settings.GAME_BOARD_SIZE/Settings.NUM_SQUARES));

        Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                lifeTreeImage.getWidth(),
                lifeTreeImage.getHeight(),
                Image.SCALE_DEFAULT));
        lifeTreeImage.setIcon(icon);
        pboard.add(lifeTreeImage);
        pboard.repaint();

    }
    //Functions to see selected coordinates
    public LinkedList<JLabel> getLabelsY() {
        return labelsY;
    }
    public void refreshLabels(){
        for(JLabel label: labelsY){
            label.setForeground(Color.WHITE);
            label.repaint();
        }
        for(JLabel label: labelsX){
            label.setForeground(Color.WHITE);
            label.repaint();
        }
    }

    public LinkedList<JLabel> getLabelsX() {
        return labelsX;
    }
}
