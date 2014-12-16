package fr;

import fr.damienchesneau.ugame.client.Plateau;
import fr.damienchesneau.ugame.client.UserPreference;

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
        if (args.length == 2 && args[0].equals("-s")) {
            UserPreference.setsSaveFile(args[1]);
        }
        System.out.println(UserPreference.getsSaveFile());
    }

}
