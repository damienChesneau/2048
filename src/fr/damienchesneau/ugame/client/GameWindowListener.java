package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.entitys.UserPreference;
import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Cette classe a été créer pour pouvoir intercepter l'evenement de fermeture de la fenetre.
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
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
        String filename;
        if ((filename = UserPreference.getsSaveFile()) != null) {
            try {
                if (UserPreference.isAleatoire()) {
                    savingSrv.procudeBinary(plateau.getGame(), filename);
                }else{
                    savingSrv.saveGame(plateau.getGame(), filename);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error unable to save the game", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(GameWindowListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        ihm.requestFocus();
    }
}
