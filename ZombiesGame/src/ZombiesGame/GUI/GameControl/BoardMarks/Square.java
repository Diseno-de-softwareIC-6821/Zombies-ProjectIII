package ZombiesGame.GUI.GameControl.BoardMarks;

import javax.swing.*;
import Classes.Character;

import java.awt.*;

public class Square {
    public static final JPanel SQUARE_MODEL = new JPanel(){
        @Override
        public boolean isOptimizedDrawingEnabled() {
            return false;
        }
    };
    private int x;
    private int y;
    private JPanel panel= new JPanel();
    private JLabel labelImage = new JLabel();
    private boolean isOccupated = false;
    private Character character;

 

    public Square(int x, int y, JPanel PANE){
        this.x = x;
        this.y = y;
        this.panel = PANE;
        labelImage.setSize(panel.getWidth()/2, panel.getHeight()/2);
    }

    public void setCharacter(Character character){
        this.character = character;
        this.isOccupated = true;
        paintImage(character.getCurrentTexture());
        this.panel.add(labelImage);
    }
    public void removeCharacter(){
        this.character = null;
        this.panel.remove(labelImage);
        this.isOccupated = false;
    }
    private void paintImage(String route){
        ImageIcon image = new ImageIcon(character.getCurrentTexture());

        Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                labelImage.getWidth(),
                labelImage.getHeight(),
                Image.SCALE_DEFAULT));
        labelImage.setIcon(icon);
        labelImage.setBounds(0, 0, panel.getWidth(),  panel.getHeight());
        this.panel.add(labelImage);
        this.panel.repaint();
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupated() {
        return isOccupated;
    }

    public Character getCharacter() {
        return character;
    }
}
