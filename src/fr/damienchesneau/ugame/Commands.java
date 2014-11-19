package fr.damienchesneau.ugame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Commands implements KeyListener {
    
    private final Plateau plateau;
    
    public Commands(Plateau plateau) {
       this.plateau = plateau;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Right key pressed.");
                plateau.goRight();
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left key pressed.");
                plateau.goLeft();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down key pressed.");
                plateau.goDown();
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up key pressed.");
                plateau.goUp();
                break;
            default:
                System.out.println("Not Supported key");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
