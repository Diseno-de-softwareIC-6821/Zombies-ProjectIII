package Classes;

import Interfaces.iLeveled;
import Interfaces.iPrototype;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;


public class Character implements iLeveled, iPrototype, Serializable {

    HashMap<Integer, String> textureMap;
    String currentTexture;

    ArrayList<Item> items;
    Item selectedItem;

    String name;
    int level;
    int experience;

    int health;
    int damage;
    int defense;
    int speed;
    int dps;

    int cost;

    int spawnLevel;
    int housingSpace;
    int positionX;
    int positionY;

    public Character(HashMap<Integer, String> textureMap, String currentTexture, ArrayList<Item> items, Item selectedItem, String name, int level, int experience, int health, int damage, int defense, int speed, int dps, int cost, int spawnLevel, int housingSpace, int positionX, int positionY) {
        this.textureMap = textureMap;
        this.currentTexture = currentTexture;

        this.items = items;
        this.selectedItem = selectedItem;

        this.name = name;
        this.level = level;
        this.experience = experience;

        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.dps = dps;

        this.cost = cost;
        this.spawnLevel = spawnLevel;
        this.housingSpace = housingSpace;

        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void attack( ArrayList<Character> target) {
        for (Character character : target) {
            character.health -= this.damage;
        }
    }

    @Override
    public void levelUp() {
        this.level++;
        this.experience = 0;
    }

    @Override
    public void levelDown() {
        this.level--;
        this.experience = 0;
    }

    @Override
    public Character clone() {
        System.out.println("Character cloned");
        return new Character(
                this.textureMap,
                this.currentTexture,
                this.items,
                this.selectedItem,
                this.name,
                this.level,
                this.experience,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.dps,
                this.cost,
                this.spawnLevel,
                this.housingSpace,
                this.positionX,
                this.positionY);
    }

    @Override
    public Character deepClone() {
        System.out.println("Character deep cloned");

        HashMap<Integer, String> textureMap = new HashMap<>();
        for (int i = 0; i < this.textureMap.size(); i++) {
            textureMap.put(i, this.textureMap.get(i));
        }

        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < this.items.size(); i++) {
            items.add( (Item) this.items.get(i).deepClone() );
        }

        Item selectedItem = (Item) this.selectedItem.deepClone();

        return new Character(
                textureMap,
                this.currentTexture,
                items,
                selectedItem,
                this.name,
                this.level,
                this.experience,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.dps,
                this.cost,
                this.spawnLevel,
                this.housingSpace,
                this.positionX,
                this.positionY);

    }

    @Override
    public String toString() {
        return "Character{" +
                "textureMap=" + textureMap +
                ", currentTexture='" + currentTexture + '\'' +
                ", items=" + items +
                ", selectedItem=" + selectedItem +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", health=" + health +
                ", damage=" + damage +
                ", defense=" + defense +
                ", speed=" + speed +
                ", dps=" + dps +
                ", cost=" + cost +
                ", spawnLevel=" + spawnLevel +
                ", housingSpace=" + housingSpace +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';

    }

    public HashMap<Integer, String> getTextureMap() {
        return textureMap;
    }

    public void setTextureMap(HashMap<Integer, String> textureMap) {
        this.textureMap = textureMap;
    }

    public String getCurrentTexture() {
        return currentTexture;
    }

    public void setCurrentTexture(String currentTexture) {
        this.currentTexture = currentTexture;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpawnLevel() {
        return spawnLevel;
    }

    public void setSpawnLevel(int spawnLevel) {
        this.spawnLevel = spawnLevel;
    }

    public int getHousingSpace() {
        return housingSpace;
    }

    public void setHousingSpace(int housingSpace) {
        this.housingSpace = housingSpace;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public static class CharacterBuilder{
        private HashMap<Integer, String> textureMap;
        private String currentTexture;

        private ArrayList<Item> items;
        private Item selectedItem;

        private String name;
        private int level;
        private int experience;

        private int health;
        private int damage;
        private int defense;
        private int speed;
        private int dps;

        private int cost;
        private int spawnLevel;
        private int housingSpace;
        private int positionX;
        private int positionY;

        public CharacterBuilder(){
            this.textureMap = new HashMap<>();
            this.currentTexture = "default";

            this.items = new ArrayList<>();
            this.selectedItem = null;

            this.name = "default";
            this.level = 1;
            this.experience = 0;

            this.health = 100;
            this.damage = 10;
            this.defense = 10;
            this.speed = 10;
            this.dps = 10;

            this.cost = 100;
            this.spawnLevel = 1;
            this.housingSpace = 1;
            this.positionX = 0;
            this.positionY = 0;
        }

        public CharacterBuilder setTextureMap(HashMap<Integer, String> textureMap) {
            this.textureMap = textureMap;
            return this;
        }

        public CharacterBuilder addTexture(int index, String texture){
            this.textureMap.put(index, texture);
            return this;
        }

        public CharacterBuilder setCurrentTexture(String currentTexture) {
            this.currentTexture = currentTexture;
            return this;
        }

        public CharacterBuilder setItems(ArrayList<Item> items) {
            this.items = items;
            return this;
        }

        public CharacterBuilder addItem(Item item){
            this.items.add(item);
            return this;
        }

        public CharacterBuilder setSelectedItem(Item selectedItem) {
            this.selectedItem = selectedItem;
            return this;
        }

        public CharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CharacterBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public CharacterBuilder setExperience(int experience) {
            this.experience = experience;
            return this;
        }

        public CharacterBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        public CharacterBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public CharacterBuilder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public CharacterBuilder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public CharacterBuilder setDps(int dps) {
            this.dps = dps;
            return this;
        }

        public CharacterBuilder setCost(int cost) {
            this.cost = cost;
            return this;
        }

        public CharacterBuilder setSpawnLevel(int spawnLevel) {
            this.spawnLevel = spawnLevel;
            return this;
        }

        public CharacterBuilder setHousingSpace(int housingSpace) {
            this.housingSpace = housingSpace;
            return this;
        }

        public CharacterBuilder setPositionX(int positionX) {
            this.positionX = positionX;
            return this;
        }

        public CharacterBuilder setPositionY(int positionY) {
            this.positionY = positionY;
            return this;
        }

        public Character build(){
            return new Character(
                textureMap,
                currentTexture,
                items,
                selectedItem,
                name,
                level,
                experience,
                health,
                damage,
                defense,
                speed,
                dps,
                cost,
                spawnLevel,
                housingSpace,
                positionX,
                positionY);
        }

    }

}
