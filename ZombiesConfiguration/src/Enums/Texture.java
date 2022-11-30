package Enums;

public enum Texture {
    LEFT_SIDE,
    RIGHT_SIDE,
    ATTACK,
    MOVEMENT;

    public static Texture getType(int i){
        switch(i) {
            case 0:
                return LEFT_SIDE;
            case 1:
                return RIGHT_SIDE;
            case 2:
                return ATTACK;
            case 3:
                return MOVEMENT;
            default:
                throw new Error("Texture type not found");

        }
    }

}
