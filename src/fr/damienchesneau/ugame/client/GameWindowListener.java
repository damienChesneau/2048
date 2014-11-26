package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class GameWindowListener extends WindowAdapter {

    private final JFrame ihm;
    private final Plateau plateau;
    private final GameSaveService savingSrv;
    
    GameWindowListener(JFrame frame,Plateau plateau){
        this.ihm = frame;
        this.plateau = plateau;
        this.savingSrv = LogiqueFactory.getGameSaveService();
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
//        try {
//            savingSrv.saveGame(plateau.getPlateau(),null);
//        } catch (IOException ex) {
//            System.exit(1);
//            Logger.getLogger(GameWindowListener.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        ihm.requestFocus();
    }
}
