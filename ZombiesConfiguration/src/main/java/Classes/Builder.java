/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.LinkedList;

/**
 *
 * @author Esteb
 */
public class Builder {
    private LinkedList<Enemy> enemieslist = new LinkedList<>();
    private LinkedList<Defense> defenselist = new LinkedList<>();
    
    private static Builder instance; 
    private Enemy.EnemyBuilder enemyBuilder = new Enemy.EnemyBuilder();
    private Defense.DefenseBuilder defenseBuilder = new Defense.DefenseBuilder();
    //Images routes for auxiliar/ temporal route before be added
    private String actualEnemyRoute = "";
    private String actualDefenseRoute= "";
    
    public static Builder getInstance(){
        if(instance ==null){
            instance = new Builder();
            
        }
        return instance;
    }
    
    
    
    
    public void addEnemy(Enemy enemy)throws Error{
        if(validateCharacter(enemy)){
            enemieslist.add(enemy);
        }
    }
    public void addDefense(Defense a)throws Error{
        if(validateCharacter(a)){
            defenselist.add(a);
        }
    }
    
    public void cleanEnemyBuilder(){
        enemyBuilder = new Enemy.EnemyBuilder();
    }
    public void cleanDefenseBuilder(){
        defenseBuilder = new Defense.DefenseBuilder();
    }
    
    public void export() throws Error{
        throw new Error("Esto no está implementado aún");
    }

    public Enemy.EnemyBuilder getEnemyBuilder() {
        return enemyBuilder;
    }

    public Defense.DefenseBuilder getDefenseBuilder() {
        return defenseBuilder;
    }
    
    

    public String getActualEnemyRoute() {
        return actualEnemyRoute;
    }

    public String getActualDefenseRoute() {
        return actualDefenseRoute;
    }

    public void setActualEnemyRoute(String actualEnemyRoute) {
        this.actualEnemyRoute = actualEnemyRoute;
    }

    public void setActualDefenseRoute(String actualDefenseRoute) {
        this.actualDefenseRoute = actualDefenseRoute;
    }
    public boolean validateCharacter(Character character)throws Error{
        if(character.getHealth()<=0){
            throw new Error("Health must be greater than 0");
        }
        if(character.getHealth()>100){
            throw new Error("Health must be less than 100");
        }
        if(character.getSpeed()<=0){
            throw new Error("Speed must be greater than 0");
        }
        if(character.getName().equals("default")){
            throw new Error("Name must not be blank");
        }
        return true;
    }
    
    
}
