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
import Interfaces.IProto;


/**
 *
 * @author Esteb
 */
public class Defense extends Character implements Serializable, IProto<Defense> {
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
    @Override
    public Defense clone(){
        return new Defense(this.getTextureMap(), this.getCurrentTexture(),this.getItems(), this.getSelectedItem(), this.getName(),
                this.getLevel(), this.getExperience(), this.getHealth(),this.getDamage(), this.getDefense(),
                this.getSpeed(), this.getDps(), this.getCost(), this.getSpawnLevel(), this.getHousingSpace(),
                this.getPositionX(), this.getPositionY(), this.scope , this.type);
    }
    
    //BALANCE FOR CONFIGURATION
      public static class DefenseBuilder{
        private CharacterBuilder characterBuilder = new CharacterBuilder().setLevel(0);

        private int scope = 0;
        private eAttackType type =eAttackType.CONTACT;


        public DefenseBuilder(){}

        public DefenseBuilder setType(eAttackType type){
            this.type = type;
            return this;
        }
        public DefenseBuilder setName(String name){
            characterBuilder.setName(name);
            return this;
        }

        public DefenseBuilder setCurrentTexture(String currentTexture){
            characterBuilder.setCurrentTexture(currentTexture);
            return this;
        }
        public DefenseBuilder setHealth(int health){
            characterBuilder.setHealth(health);
            return this;
        }
        public DefenseBuilder setDamage(int damage){
            characterBuilder.setDamage(damage);
            return this;
        }
        public DefenseBuilder setDPS(int dps){
            characterBuilder.setDps(dps);
            return this;
        }
        public DefenseBuilder setHousingSpace(int housingSpace){
            characterBuilder.setHousingSpace(housingSpace);
            return this;
        }
        public DefenseBuilder setSpawnLevel(int aparitionLevel){
            characterBuilder.setSpawnLevel(aparitionLevel);
            return this;
        }
        public DefenseBuilder setScope(int scope){
            this.scope = scope;
            return this;
        }

        
        public Defense build(){
            Character character = characterBuilder.build();
            return new Defense(character.getTextureMap(), character.getCurrentTexture(), character.getItems(),
                    character.getSelectedItem(), character.getName(), character.getLevel(), character.getExperience(),
                    character.getHealth(), character.getDamage(), character.getDefense(), character.getSpeed(),
                    character.getDps(), character.getCost(), character.getSpawnLevel(), character.getHousingSpace(),
                    character.getPositionX(), character.getPositionY(), scope, type);
        }

    }

    
    
    
    
}
