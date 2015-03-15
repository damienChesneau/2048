package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.ArtificialInteligentService;
import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Cette classe permet de gerer les commandes utilisateurs comme les touches
 * pour jouer et les actions apres un clique <br>
 * Sur un bouton.
 *
 * @author Damien Chesneau
 * <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
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
        ArtificialInteligentService df = LogiqueFactory.getArtificialInteligentService();
        try {
            Map<String, Object> solveGame = df.solveGame(plateau.getGame().clone());
            plateau.startGame((int[][]) solveGame.get(GameService.KEY_PLATEAU), (int) solveGame.get(GameService.KEY_SCORE));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error unable to launch the solver", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void retry() {
        plateau.startGame();
    }
}
