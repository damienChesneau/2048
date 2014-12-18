package fr;

import fr.damienchesneau.ugame.client.Plateau;
import fr.damienchesneau.ugame.client.UserPreference;
import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameSaveService s = LogiqueFactory.getGameSaveService();
        Plateau plateau = new Plateau();
        if (args.length == 2) {
            switch (args[0]) {
                case "-s":
                    plateau.startGame();
                    UserPreference.setsSaveFile(args[1]);
                    break;
                case "-r":
                    UserPreference.setReplayFileName(args[1]);
                    try {
                        GameService gaveByFileName = s.getGaveByFileName(UserPreference.getReplayFileName());
                        plateau.startGame(gaveByFileName);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur", "Impossible de recupérer la partie.", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        } else if (args.length == 1) {
            switch (args[0]) {
                case "-a":
                    plateau.startGame();
                    UserPreference.setAleatoire(true);
                    break;
                case "-n":
                    UserPreference.setAleatoire(true);
                    break;
            }
        }else{
            plateau.startGame();
        }
        System.out.println(UserPreference.getsSaveFile());
    }

}
