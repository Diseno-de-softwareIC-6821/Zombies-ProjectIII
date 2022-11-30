package GameControl;

public class Settings {
    public static String BACKGROUND = "src\\Images\\fondo.jpg";
    public static String LIGFE_TREE_ROUTE = "src\\Images\\ArbolDeLaVida.png";
    public static final  int GAME_BOARD_SIZE = 700;
    public static final int NUM_SQUARES = 25; //25x25
    public static  double MAX_IMPROVEMENT_RATE = 0.5;
    public static  double MIN_IMPROVEMENT = 0.5;
    public static int STARTING_HOUSING_SPACE = 20;
    private int unitTime = 1000;
    private int unitTimeForAttack = 1000;
    private static Settings instance = null;
    private static Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }


}
