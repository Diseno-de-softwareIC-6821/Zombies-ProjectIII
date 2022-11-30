package GameControl.adm;

import GameClasses.Defense;
import GameClasses.Enemy;
import GameClasses.Game;
import GameClasses.IPrototypeFactory;
import GameControl.BoardMarks.Board;
import GameControl.Settings;
import GameControl.Threads.DefenseThread;
import GameControl.Threads.EnemyThread;

import java.util.ArrayList;

public class Control {

    Board board;
    ArrayList<DefenseThread> listDefenseThreads = new ArrayList<>();
    ArrayList<EnemyThread> listaEnemiesThreads = new ArrayList<>();

    public Control(Board board) {
        this.board = board;
    }

    public void addDefense(Defense defense){
        DefenseThread defenseThread = new DefenseThread(defense);
        listDefenseThreads.add(defenseThread);
        new Thread(defenseThread).start();
    }



    /*
    * Functions for the enemies
    * */

    private void addEnemy(EnemyThread enemyThread){
        listaEnemiesThreads.add(enemyThread);
        new Thread(enemyThread).start();
    }
    public void generateEnemies(){ //this will be the method to implements in interface

    }
    public void generateRound(){
        //int level = Game.getInstance().getLevel();
        //int amount = (Settings.HOUSING_SPACE_PLUS*level)+20;
        //for(int i = 0; i<amount; i++){
        /*    String randEnemy = selectRandomEnemy();
            Enemy enemy = (Enemy) IPrototypeFactory.get(randEnemy);
            int[] position = getRandomPosition();

            enemy.setPositionX(position[0]);
            enemy.setPositionY(position[1]);
            this.board
            this.addEnemy(new EnemyThread(enemy));

        }
        TODO Generar Round*/

    }
    private String selectRandomEnemy(){
        int size = Game.getInstance().getEnemies().size();
        int random = (int) (Math.random()*size);
        return Game.getInstance().getEnemies().get(random).getName();
    }

    private int[] getRandomPosition(){
        int[] range = {0,Settings.NUM_SQUARES-1}; //chosen randomly if zombie appears in the first or last row or column
        int xrangeChosen = range[(int) (Math.random()*2)]; //chosen randomly if zombie appears in the first or last row or column
        int yrangeChosen = range[(int) (Math.random()*2)]; //chosen randomly if zombie appears in the first or last row or column
        int[] choosenPos = {xrangeChosen, yrangeChosen}; //chose randomly modified value
        int alterablePos = (int) (Math.random()*2);
        choosenPos[alterablePos] = (int) (Math.random()*Settings.NUM_SQUARES);
        return  choosenPos;
    }



}
