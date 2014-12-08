package fr;

import fr.damienchesneau.ugame.client.Plateau;
import fr.damienchesneau.ugame.client.UserPreference;
import fr.damienchesneau.ugame.logique.ArtificialInteligentService;
import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.util.Map;
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
            Map<String, Object> solveGame = df.solveGame(plateau.getGame().clone());
            plateau.startGame((int[][]) solveGame.get(GameService.KEY_PLATEAU), (int) solveGame.get(GameService.KEY_SCORE));
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (args.length == 2 && args[0].equals("-s")) {
            UserPreference.setsSaveFile(args[1]);
        }
        System.out.println(UserPreference.getsSaveFile());
    }

}
