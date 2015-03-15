package fr;

import fr.damienchesneau.ugame.client.Plateau;
import fr.damienchesneau.ugame.logique.entitys.UserPreference;
import fr.damienchesneau.ugame.logique.ArtificialInteligentService;
import fr.damienchesneau.ugame.logique.GameSaveService;
import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameSaveService s = LogiqueFactory.getGameSaveService();
        Plateau plateau;
        if (args.length >= 3) {
            plateau = new Plateau();
            if (args[0].equals("-s") && args[2].equals("-a")) { //-s toto - a fichieraleatoireamoi 
                UserPreference.setsSaveFile(args[1]);
                try {
                    GameService gaveByFileName = s.getBinaryFileByName(args[3]);
                    plateau.startGame(gaveByFileName);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur", "Impossible de recupérer la partie.", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (args[0].equals("-K") && args[1].equals("-s") && args[3].equals("-g")) {//-K -s fichier -g 14071789
                /*
                 <!--  -K c'est pour le solveur  -->
                 <!--  -g c'est la valeur de seed  --> 
                 <!--
                 -s permer de charger un fichier standard pourtant dans le sujet on demande une suite aleatoire je ne suis pas sur de ce qui est demandé mais je vais me fier au sujet
                 et pas au fichier build.xml.
                 le fichier de sauvegarde contient la meilleure partie 
                 --> */
                UserPreference.setPreferendSeedValue(Long.valueOf(args[4]));
                try {
                    GameService gaveByFileName = s.getBinaryFileByName(args[2]);
                    plateau.startGame(gaveByFileName);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur", "Impossible de recupérer la partie.", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (args[0].equals("-M") && args[1].equals("-g")) {//-M -g 1212
                /*<!--  -M c'est pour l'application de l'algorithme MinMax  -->
                 <!--  -g c'est la valeur de seed  -->*/
                UserPreference.setPreferendSeedValue(Integer.valueOf(args[2]));
                ArtificialInteligentService ia = LogiqueFactory.getArtificialInteligentService();
                try {
                    Map<String, Object> solveGame = ia.solveGame(plateau.getGame().clone());
                    plateau.startGame((int[][]) solveGame.get(GameService.KEY_PLATEAU), (int) solveGame.get(GameService.KEY_SCORE));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (args.length == 2) {
            switch (args[0]) {
                case "-s":
                    plateau = new Plateau();
                    plateau.startGame();
                    UserPreference.setsSaveFile(args[1]);
                    break;
                case "-r":
                    plateau = new Plateau();
                    UserPreference.setReplayFileName(args[1]);
                    try {
                        GameService gaveByFileName = s.getGaveByFileName(UserPreference.getReplayFileName());
                        plateau.startGame(gaveByFileName);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur", "Impossible de recupérer la partie.", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "-a":
                    plateau = new Plateau();
                    plateau.startGame();
                    UserPreference.setsSaveFile(args[1]);
                    UserPreference.setAleatoire(true);
                    break;
                case "-n":
                    plateau = new Plateau();
                    UserPreference.setAleatoire(true);
                    UserPreference.setReplayFileName(args[1]);
                    try {
                        GameService gaveByFileName = s.getBinaryFileByName(UserPreference.getReplayFileName());
                        plateau.startGame(gaveByFileName);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur", "Impossible de recupérer la partie.", JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "-new_size":
                    plateau = new Plateau(Integer.valueOf(args[1]));
                    plateau.startGame();
                    break;
            }
        } else if (args.length == 1) {
            plateau = new Plateau();
            switch (args[0]) {
                case "-a":
                    plateau.startGame();
                    UserPreference.setAleatoire(true);
                    break;
                case "-n":
                    UserPreference.setAleatoire(true);
                    break;
            }
        } else {
            plateau = new Plateau();
            plateau.startGame();
        }
        System.out.println(UserPreference.getsSaveFile());
    }

}
