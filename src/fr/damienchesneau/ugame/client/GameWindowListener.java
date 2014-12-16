package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class GameWindowListener extends WindowAdapter {

    private final JFrame ihm;
    private final Plateau plateau;
    private final GameSaveService savingSrv;

    GameWindowListener(JFrame frame, Plateau plateau) {
        this.ihm = frame;
        this.plateau = plateau;
        this.savingSrv = LogiqueFactory.getGameSaveService();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        System.out.println("out");
        String filename;
        if ((filename = UserPreference.getsSaveFile()) != null) {
            try {
                savingSrv.saveGame(plateau.getGame(), filename);
            } catch (IOException ex) {
                Logger.getLogger(GameWindowListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        ihm.requestFocus();
    }
}
