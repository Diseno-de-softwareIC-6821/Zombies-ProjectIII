package GameControl;
import Classes.Character;
import javax.swing.*;

public abstract class ThreadComponent extends JProgressBar implements Runnable {
    protected abstract void defaultComponentValue();
}
