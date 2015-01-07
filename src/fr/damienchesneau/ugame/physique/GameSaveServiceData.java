package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Service de gestion des fichiers.
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public interface GameSaveServiceData {

    /**
     *
     * @param name
     * @return
     */
    public List<HistoryItem> getGaveByFileName(String name) throws IOException;

    public void saveGame(final GameService plateau, final String fileName) throws FileNotFoundException, IOException;
    
    public void procudeBinary(final GameService plateau, final String fileName) throws FileNotFoundException, IOException;
    
    public List<HistoryItem> getBinaryFileByName(String name) throws IOException;
}
