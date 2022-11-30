package ZombiesGame.GUI.GameControl.Threads;

import GameClasses.Enemy;

import java.awt.*;

public class EnemyThread extends ThreadComponent {
    private Enemy enemy;

    public EnemyThread(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void run() {
        while (this.enemy.getHealth()>0){
            this.setValue(this.enemy.getHealth());
        }
    }

    @Override
    protected void defaultComponentValue() {
        this.setBackground(Color.red);
        this.setMinimum(0);
        this.setMaximum(enemy.getHealth());
        this.setValue(enemy.getHealth());
    }
}
