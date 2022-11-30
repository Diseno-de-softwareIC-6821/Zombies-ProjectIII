/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameClasses;

import Files.IFile;
import ZombiesGame.GUI.GameControl.Settings;
import ZombiesGame.GUI.GameControl.Threads.ThreadComponent;
import Interfaces.iLeveled;

import javax.swing.*;
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
    private int housingSpaces = 20; //start with 20 housing spaces

    private static Game instance = null;


    public static Game getInstance(){
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
        housingSpaces+=Settings.HOUSING_SPACE_PLUS;//plus 5 housing spaces
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
    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
        IPrototypeFactory.add(enemy.getName(),enemy);
    }
    public void addDefense(Defense defense){
        defenses.add(defense);
        IPrototypeFactory.add(defense.getName(),defense);
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

    private void setDefenses(ArrayList<Defense> defenses) {
        this.defenses = defenses;
    }

    private void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public void run() {
        while(life_tree.getHealth()> 0 && inGame){

        }
        inGame = false;

    }
    public static class GameBuilder implements IFile<String, Game>{
        private ArrayList<Defense> defensesLoaded = new ArrayList<>();
        private ArrayList<Enemy> enemiesLoaded = new ArrayList<>();
        public void loadDefense(String classToLoad) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(classToLoad);
            ObjectInputStream entry = new ObjectInputStream(fis);
            this.defensesLoaded= (ArrayList<Defense>) entry.readObject();
            System.out.println("Defenses loaded");
            for (Enemy enemy : this.enemiesLoaded) {
                System.out.println(enemy.getName());
            }
        }
        public void loadEnemy(String classToLoad) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(classToLoad);
            ObjectInputStream entry = new ObjectInputStream(fis);
            this.enemiesLoaded = (ArrayList<Enemy>) entry.readObject();
            System.out.println("Enemies loaded");
            for (Enemy enemy : this.enemiesLoaded) {
                System.out.println(enemy.getName());
            }
        }
        public String getFile(){
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Guarde el archivo");
            int selection = fc.showSaveDialog(null);
            if (selection == JFileChooser.APPROVE_OPTION) {
                System.out.println("Get selected file "+fc.getSelectedFile().getAbsolutePath());
                return fc.getSelectedFile().getAbsolutePath();
            }
            return "";
        }

        @Override
        public Game load(String name) throws Error{
            Game game = new Game();
            game.setName("name");

            game.setDefenses(defensesLoaded);
            game.setEnemies(enemiesLoaded);
            return game;
        }
    }

}
