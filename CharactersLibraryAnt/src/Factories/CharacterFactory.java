package Factories;

import Classes.Character;
import Interfaces.iPrototype;
import Interfaces.iPrototypeFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CharacterFactory implements iPrototypeFactory<ArrayList<Character>> {

    HashMap<String, Character> prototypeMap;
    ItemFactory itemFactory;

    public CharacterFactory(ItemFactory itemFactory){
        this.prototypeMap = new HashMap<>();
        this.itemFactory = itemFactory;
    }

    @Override
    public ArrayList<Character> getClone(String name, int quantity) {
        ArrayList<Character> entities = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            entities.add((Character) prototypeMap.get(name).clone());
        }

        return entities;
    }

    @Override
    public ArrayList<Character> getDeepClone(String name, int quantity) {
        ArrayList<Character> entities = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            entities.add((Character) prototypeMap.get(name).deepClone());
        }

        return entities;
    }

    @Override
    public void addPrototype(String name, iPrototype prototype) {
        prototypeMap.put(name, (Character) prototype);
    }
}
