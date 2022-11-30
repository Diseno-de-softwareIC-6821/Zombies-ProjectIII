package GameControl.Threads;

import GameClasses.Defense;

import java.awt.*;

public class DefenseThread extends ThreadComponent {

    private Defense defense;

    public DefenseThread(Defense defense) {
        this.defense = defense;
    }

    @Override
    public void run() {
        while (this.defense.getHealth()>0){
            this.setValue(this.defense.getHealth());
            updateUI(); //may be necessary
        }
    }

    @Override
    protected void defaultComponentValue() {
        this.setBackground(Color.blue);
        this.setMinimum(0);
        this.setMaximum(this.defense.getHealth());
        this.setValue(this.defense.getHealth());
    }
}
