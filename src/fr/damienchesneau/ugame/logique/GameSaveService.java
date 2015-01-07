package fr.damienchesneau.ugame.logique;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Service de récupération ou sauvegarde d'une partie.
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public interface GameSaveService {

    public GameService getGaveByFileName(final String name) throws FileNotFoundException, IOException;

    public void saveGame(final GameService plateau, final String fileName) throws FileNotFoundException, IOException;

    public void procudeBinary(final GameService plateau, final String fileName) throws FileNotFoundException, IOException;

    public GameService getBinaryFileByName(String name) throws IOException;
}
