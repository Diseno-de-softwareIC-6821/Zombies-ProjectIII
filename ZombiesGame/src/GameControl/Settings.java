package GameControl;

import GameClasses.Defense;
import GameClasses.Enemy;
import Enum.eAttackType;
import java.util.HashMap;

public class Settings {
    public static final Defense PRUEBA_DEFENSA = new Defense(new HashMap<>(),
            "src\\Images\\ArmaAtaqueMultiple.png",null, null,"Arma", 0, 0,
100, 40,0,0,0,0, 2,5, 4,5,5, eAttackType.MULTIPLE_ATTACK);

    public static final Enemy PRUEBA_ZOMBIE = new Enemy(null, "src\\Images\\ZombieAlcanceMedio.png",null
            , null,"Zombie", 0, 0, 100, 40,0,0,0,0,
            1,5, 4,5,5, eAttackType.MEDIUM_SCOPE);
    public static final Defense PRUEBA_MURALLA = new Defense(null, "src\\Images\\Muralla.png",null
            , null,"Muralla", 0, 0, 100, 40,0,0,0,0,
            1,1, 14,8,5, eAttackType.BLOCK);
    public static String LIGFE_TREE_ROUTE = "src\\Images\\ArbolDeLaVida.png";
    public static  Defense LIFE_TREE = new Defense(null, LIGFE_TREE_ROUTE,null
            , null,"Life Tree", 0, 0, 100, 0,5,0,0,0,
            1,1, 11,12,5, eAttackType.BLOCK);

    public static String BACKGROUND = "src\\Images\\fondo.jpg";

    public static final  int GAME_BOARD_SIZE = 700;
    public static final int NUM_SQUARES = 25; //25x25
    public static  double MAX_IMPROVEMENT_RATE = 0.5;
    public static  double MIN_IMPROVEMENT = 0.5;
    public static int STARTING_HOUSING_SPACE = 20;
    private int unitTime = 1000;
    private int unitTimeForAttack = 1000;
    public static final int HOUSING_SPACE_PLUS = 5;
    private static Settings instance = null;
    private static Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }


}
