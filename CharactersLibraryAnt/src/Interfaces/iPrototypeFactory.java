package Interfaces;

public interface iPrototypeFactory<T> {
    T getClone(String name, int quantity);
    T getDeepClone(String name, int quantity);
    void addPrototype(String name, iPrototype prototype);
}
