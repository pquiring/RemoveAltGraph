package code;

import org.openide.modules.ModuleInstall;

import java.awt.*;
import java.awt.event.*;

public class Installer extends ModuleInstall {

    public static boolean done = false;
    
    @Override
    public void restored() {
        if (done) return;
        done = true;
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
          public boolean dispatchKeyEvent(KeyEvent e) {
            int mods = e.getModifiers();
            if ((mods & KeyEvent.ALT_GRAPH_MASK) != 0) {
              mods &= ~KeyEvent.ALT_GRAPH_MASK;
              e.setModifiers(mods);
            }
            return false;
          }
        });
    }

}
