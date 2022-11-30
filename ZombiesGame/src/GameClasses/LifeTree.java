package GameClasses;

import Classes.Item;

import java.util.ArrayList;
import java.util.HashMap;
import Enum.eAttackType;
public class LifeTree extends Defense{
    private static final String IMAGE_PATH = "src\\Images\\ArbolDeLaVida.png";
    private static final String NAME ="Life tree";
    private static final int XPOS = 0;
    private static  final int YPOS = 0;
    private static final int HEALTH = 500;
    private static LifeTree instance;

    private LifeTree() {
        super(new HashMap<>(), IMAGE_PATH, new ArrayList<>(), null, NAME, 0, 0, HEALTH,
                0, 0, 0, 0, 0, 1, 0, XPOS, YPOS, 0, eAttackType.BLOCK);
    }

    public void getInstance(){
        if(instance == null){
            instance = new LifeTree();
        }
    }
    public void setPos(int x, int y){
        this.setPositionX(x);
        this.setPositionY(y);
    }







}
