This NetBeans plugin will automatically remove the AltGraph code from all KeyEvents.
In Java9 the AltGraph code was added in Windows but this key has the same scancode as the right Alt (VK_RMENU).
This change causes the right Alt to have an extra bit set which causes hotkeys to stop working.
See Java bug : https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8194873
Also see : https://en.wikipedia.org/wiki/AltGr_key
To compile:
 - open project in NetBeans.
 - run build/nbm to create plugin.
To install in NetBeans:
 - Tools -> Plugins -> Downloaded -> Add Plugins...
To fix this bug in your Java programs add this function:

  import java.awt.*;
  import java.awt.event.*;

  /** Java9+ treats the right Alt as AltGr.  This function will remove this 'bug'. */
  public static void removeAltGraph() {
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
