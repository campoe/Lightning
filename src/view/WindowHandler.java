package view;

import java.awt.event.*;

/**
 * Created by Coen on 30-3-2017.
 */
public class WindowHandler implements WindowListener, WindowFocusListener, WindowStateListener {

    private Window window;

    public WindowHandler(Window window) {
        this.window = window;
        window.getFrame().addWindowListener(this);
        window.getFrame().addWindowFocusListener(this);
        window.getFrame().addWindowStateListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("[WINDOW] opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("[WINDOW] closing...");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("[WINDOW] iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("[WINDOW] deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("[WINDOW] activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("[WINDOW] deactivated");
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println("[WINDOW] gained focus");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("[WINDOW] lost focus");
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("[WINDOW] state changed from: " + e.getOldState() + ", to: " + e.getNewState());
    }

}
