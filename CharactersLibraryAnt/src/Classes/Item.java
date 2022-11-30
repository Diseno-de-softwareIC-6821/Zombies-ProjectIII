package Classes;

import Enums.eItemClass;
import Enums.eItemEffect;
import Interfaces.iPrototype;

import java.util.HashMap;

public class Item implements iPrototype {

    HashMap<Integer, String> textureMap;
    String currentTexture;
    eItemClass itemClass;
    eItemEffect itemEffect;

    String name;

    int level;
    int range;
    int coolDown;
    int damage;
    int explosionRadius;
    int ammo;

    public Item(HashMap<Integer, String> textureMap, eItemClass itemClass, eItemEffect itemEffect,String name, int level, int range, int coolDown, int damage, int explosionRadius, int ammo) {
        this.textureMap = textureMap;
        this.itemClass = itemClass;
        this.itemEffect = itemEffect;
        this.name = name;
        this.level = level;
        this.range = range;
        this.coolDown = coolDown;
        this.damage = damage;
        this.explosionRadius = explosionRadius;
        this.ammo = ammo;
    }




    @Override
    public iPrototype clone() {
        System.out.println("Cloning " + this.name);
        return new Item(this.textureMap, this.itemClass, this.itemEffect, this.name, this.level, this.range, this.coolDown, this.damage, this.explosionRadius, this.ammo);
    }

    @Override
    public iPrototype deepClone() {

        System.out.println("Deep Cloning " + this.name);
        HashMap<Integer, String> textureMap = new HashMap<>();
        for (int i = 0; i < this.textureMap.size(); i++) {
            textureMap.put(i, this.textureMap.get(i));
        }
        return new Item(textureMap, this.itemClass, this.itemEffect, this.name, this.level, this.range, this.coolDown, this.damage, this.explosionRadius, this.ammo);

    }

    @Override
    public String toString() {
        return "Item{" +
                "textureMap=" + textureMap +
                ", currentTexture='" + currentTexture + '\'' +
                ", itemClass=" + itemClass +
                ", itemEffect=" + itemEffect +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", range=" + range +
                ", coolDown=" + coolDown +
                ", damage=" + damage +
                ", explosionRadius=" + explosionRadius +
                ", ammo=" + ammo +
                '}';
    }

    public void addTexture(int index, String texture) {
        this.textureMap.put(index, texture);
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

    public eItemClass getItemClass() {
        return itemClass;
    }

    public void setItemClass(eItemClass itemClass) {
        this.itemClass = itemClass;
    }

    public eItemEffect getItemEffect() {
        return itemEffect;
    }

    public void setItemEffect(eItemEffect itemEffect) {
        this.itemEffect = itemEffect;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
