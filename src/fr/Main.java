package fr;

import fr.damienchesneau.ugame.client.Plateau;
import fr.damienchesneau.ugame.client.UserPreference;
import fr.damienchesneau.ugame.logique.ArtificialInteligentService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Plateau plateau = new Plateau();
        plateau.startGame();
        ArtificialInteligentService df = LogiqueFactory.getArtificialInteligentService();
        try {
            df.solveGame(plateau.getGame());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (args.length==2 && args[0].equals("-s") ) {
            UserPreference.setsSaveFile(args[1]);
        }
        System.out.println(UserPreference.getsSaveFile());
    }

}
