package Enums;


import static Enums.eTexture.eTextureType.*;

public class eTexture {
    public static final int currentTexture = 0;
    public static final int leftSide = 1;
    public static final int rightSide = 2;
    public static final int attack = 5;
    public static final int movement = 6;

    public static int getTextureInt(eTextureType type)throws Error{//is like texture factory
        switch(type){
            case CURRENT_TEXTURE:
                return currentTexture;
            case LEFT_SIDE:
                return leftSide;
            case RIGHT_SIDE:
                return rightSide;
            case ATTACK:
                return attack;
            case MOVEMENT:
                return movement;
            default:
                throw new Error("Texture type not found");
        }
    }

    public static enum eTextureType{
        CURRENT_TEXTURE,
        LEFT_SIDE,
        RIGHT_SIDE,
        ATTACK,
        MOVEMENT
    }
}
