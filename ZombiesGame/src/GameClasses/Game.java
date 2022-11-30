/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameClasses;

import Files.IFile;
import GameControl.DefenseThread;
import GameControl.Settings;
import GameControl.ThreadComponent;
import Interfaces.iLeveled;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class Game extends ThreadComponent implements IFile<Game,String> , Serializable, iLeveled, Runnable { //serializable to export Game
    private String name = "No name";
    private Defense life_tree = Settings.LIFE_TREE;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Defense> defenses = new ArrayList<>();
    private int level = 1;
    private boolean inGame = true;

    private static Game instance = null;


    public Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    @Override
    public String load(Game classToLoad) {
        this.name = classToLoad.getName();
        this.enemies = classToLoad.getEnemies();
        this.defenses = classToLoad.getDefenses();
        this.level = classToLoad.getLevel();
        return "Game loaded";
    }


    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public void levelDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Defense> getDefenses() {
        return defenses;
    }

    public int getLevel() {
        return level;
    }

    public static Game load(String route) throws IOException, ClassNotFoundException, FileNotFoundException {
        FileInputStream fis ;
        ObjectInputStream entry;
        fis = new FileInputStream(route);
        entry = new ObjectInputStream(fis);
        return (Game) entry.readObject();
    }
    public static void export(Game game, String route) throws IOException{
        FileOutputStream fos;
        ObjectOutputStream entry;
        fos = new FileOutputStream(route);
        entry = new ObjectOutputStream(fos);
        entry.writeObject(game);
    }


    @Override
    protected void defaultComponentValue() {
        this.setBackground(Color.red);
        this.setMinimum(0);
        this.setMaximum(life_tree.getHealth());
        this.setValue(life_tree.getHealth());
    }

    @Override
    public void run() {
        while(life_tree.getHealth()> 0 && inGame){

        }
        inGame = false;

    }
}
