/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameClasses;

import Classes.Character;
import Classes.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import Enum.eAttackType;

/**
 *
 * @author Esteb
 */
public class Defense extends Character implements Serializable{
    private int scope;
    private eAttackType type ;
    public Defense(HashMap<Integer, String> textureMap, String currentTexture,
            ArrayList<Item> items, Item selectedItem, String name, int level,
            int experience, int health, int damage, int defense, int speed,
            int dps, int cost, int spawnLevel, int housingSpace, int positionX,
            int positionY, int scope, eAttackType type) {
        super(textureMap, currentTexture, items, selectedItem, name, level, 
                experience, health, damage, defense, speed, dps, cost, spawnLevel, 
                housingSpace, positionX, positionY);
        this.scope = scope;
        this.type = type;
    }
    
    
    
    
    
}
