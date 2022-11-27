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
    
    public static Builder getInstance(){
        if(instance ==null){
            instance = new Builder();
            
        }
        return instance;
    }
    public void addEnemy(Enemy a){ enemieslist.add(a);}
    public void addDefense(Defense a){defenselist.add(a);}
    
    public void export() throws Error{
        throw new Error("Esto no está implementado aún");
    }
    
    
}
