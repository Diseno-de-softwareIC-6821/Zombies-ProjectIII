package Classes;

import Enums.eAttackType;

import java.util.ArrayList;
import java.util.HashMap;

public class Enemy  extends Character{
    private eAttackType type;
    private int scope;

    public Enemy(HashMap<Integer, String> textureMap, String currentTexture, ArrayList<Item> items, Item selectedItem,
                 String name, int level, int experience, int health, int damage, int defense, int speed, int dps,
                 int cost, int spawnLevel, int housingSpace, int positionX, int positionY, int scope, eAttackType type) {

        super(textureMap, currentTexture, items, selectedItem, name, level, experience, health, damage, defense, speed,
                dps, cost, spawnLevel, housingSpace, positionX, positionY);
        this.scope = scope;
        this.type = type;
    }

    public eAttackType getType() {
        return type;
    }

    public int getScope() {
        return scope;
    }

    public static class EnemyBuilder{
        private CharacterBuilder characterBuilder = new CharacterBuilder().setLevel(0);
        private eAttackType type =eAttackType.CONTACT;
        private int scope=0;

        public EnemyBuilder(){}

        public EnemyBuilder setType(eAttackType type){
            this.type = type;
            return this;
        }
        public EnemyBuilder setName(String name){
            characterBuilder.setName(name);
            return this;
        }

        public EnemyBuilder setCurrentTexture(String currentTexture){
            characterBuilder.setCurrentTexture(currentTexture);
            return this;
        }
        public EnemyBuilder setHealth(int health){
            characterBuilder.setHealth(health);
            return this;
        }
        public EnemyBuilder setDamage(int damage){
            characterBuilder.setDamage(damage);
            return this;
        }
        public EnemyBuilder setDPS(int dps){
            characterBuilder.setDps(dps);
            return this;
        }
        public EnemyBuilder setHousingSpace(int housingSpace){
            characterBuilder.setHousingSpace(housingSpace);
            return this;
        }
        public EnemyBuilder setSpawnLevel(int aparitionLevel){
            characterBuilder.setSpawnLevel(aparitionLevel);
            return this;
        }
        public EnemyBuilder setScope(int scope){
            this.scope = scope;
            return this;
        }
        public Enemy build(){
            Character character = characterBuilder.build();
            return new Enemy(character.getTextureMap(), character.getCurrentTexture(), character.getItems(),
                    character.getSelectedItem(), character.getName(), character.getLevel(), character.getExperience(),
                    character.getHealth(), character.getDamage(), character.getDefense(), character.getSpeed(),
                    character.getDps(), character.getCost(), character.getSpawnLevel(), character.getHousingSpace(),
                    character.getPositionX(), character.getPositionY(), scope, type);
        }





    }
}
