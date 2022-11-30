package GameClasses;



import Interfaces.IProto;

import java.util.HashMap;

public class IPrototypeFactory {
    private static HashMap<String, IProto> characters = new HashMap<>();

    public static void add(String name, IProto character){
        characters.put(name, character);
    }
    public static IProto get(String name){
        return characters.get(name).clone();
    }


}
