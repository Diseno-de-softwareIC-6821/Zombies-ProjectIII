/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameClasses;

import Files.IFile;
import Interfaces.iLeveled;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Esteb
 */
public class Game implements IFile<Game,String> , Serializable, iLeveled { //serializable to export Game
    private String name = "No name";
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Defense> defenses = new ArrayList<>();
    private int level = 0;

    private static Game instance = null;

    private Game(){}
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
}
