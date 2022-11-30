package Factories;

import Classes.Item;
import Interfaces.iPrototype;
import Interfaces.iPrototypeFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemFactory implements iPrototypeFactory<ArrayList<Item>> {

    HashMap<String, Item> prototypeMap;

    public ItemFactory() {
        this.prototypeMap = new HashMap<>();
    }

    @Override
    public ArrayList<Item> getClone(String name, int quantity) {
        ArrayList<Item> entities = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            entities.add((Item) prototypeMap.get(name).clone());
        }

        return entities;
    }

    @Override
    public ArrayList<Item> getDeepClone(String name, int quantity) {
        ArrayList<Item> entities = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            entities.add((Item) prototypeMap.get(name).deepClone());
        }

        return entities;
    }

    @Override
    public void addPrototype(String name, iPrototype prototype) {
        prototypeMap.put(name, (Item) prototype);
    }
}

