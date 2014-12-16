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
        if (args.length == 2 ) {
            switch (args[0]) {
                case "-s":
                    UserPreference.setsSaveFile(args[1]);
                    break;
                case "-r":
                    UserPreference.setReplayFileName(args[1]);
                    break;
            }
        }else if(args.length == 1 ){
            switch (args[0]) {
                case "-a":
                    UserPreference.setAleatoire(true);
                    break;
                case "-n":
                    UserPreference.setAleatoire(true);
                    break;
            }
        }
        System.out.println(UserPreference.getsSaveFile());
    }

}
