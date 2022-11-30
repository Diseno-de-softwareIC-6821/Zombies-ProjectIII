package Interfaces;

public interface IProto<T extends IProto> extends Cloneable {
    public T clone();
}
