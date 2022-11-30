/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ZombiesConfiguration.Classes;

import GameClasses.Defense;
import GameClasses.Enemy;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import Classes.Character;

/**
 *
 * @author Esteb
 */
public class Builder {
    private ArrayList<Enemy> enemieslist = new ArrayList<>();
    private ArrayList<Defense> defenselist = new ArrayList<>();
    
    private static Builder instance; 
 
    //Images routes for auxiliar/ temporal route before be added
    
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
    public void export(String route) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(route+"buildings.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.defenselist);
        oos.close();
        fos.close();
        System.out.println("Las defensas han sido exportadas");            
        fos = new FileOutputStream(route+"enemies.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(this.enemieslist);
        oos.close();
        fos.close();
        System.out.println("Los enemigos han sido exportados");            
        for(Enemy en : enemieslist){
            System.out.println(en.getName());
        }
        System.out.println("=============================");
        for(Defense en : defenselist){
            System.out.println(en.getName());
        }
        
     
        
    
    }
    
    
}
