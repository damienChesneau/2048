package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.ArtificialInteligentService;
import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class Commands extends WindowAdapter implements KeyListener {

    private final Plateau plateau;
    private final GameSaveService savingSrv;

    public Commands(Plateau plateau) {
        this.plateau = plateau;
        this.savingSrv = LogiqueFactory.getGameSaveService();
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

    public Plateau getPlateau() {
        return this.plateau;
    }

    public final void solveGame() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ArtificialInteligentService df = LogiqueFactory.getArtificialInteligentService();
                try {
                    Map<String, Object> solveGame = df.solveGame(plateau.getGame().clone());
                    plateau.startGame((int[][]) solveGame.get(GameService.KEY_PLATEAU), (int) solveGame.get(GameService.KEY_SCORE));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

    public final void retry() {
        plateau.startGame();
    }
}
