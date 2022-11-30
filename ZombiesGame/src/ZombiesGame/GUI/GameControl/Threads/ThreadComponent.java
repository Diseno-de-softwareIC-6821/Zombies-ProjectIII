package ZombiesGame.GUI.GameControl.Threads;
import javax.swing.*;

public abstract class ThreadComponent extends JProgressBar implements Runnable {
    protected abstract void defaultComponentValue();
}
