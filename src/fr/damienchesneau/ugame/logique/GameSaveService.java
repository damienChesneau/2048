package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.logique.entitys.Levels;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public interface GameSaveService {

    public int[][] getGaveByFileName(String name);

    public void saveGame(final Levels[][] plateau,final String fileName) throws FileNotFoundException, IOException;
}
