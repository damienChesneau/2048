package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.entitys.Levels;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public interface GameSaveServiceData {
    /**
     * 
     * @param name 
     */
    public Levels[][] getGaveByFileName(String name);

    public void saveGame(final Levels[][] plateau,final String fileName) throws FileNotFoundException, IOException;
}
