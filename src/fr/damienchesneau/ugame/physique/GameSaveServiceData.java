package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public interface GameSaveServiceData {

    /**
     *
     * @param name
     * @return
     */
    public List<HistoryItem> getGaveByFileName(String name) throws IOException;

    public void saveGame(final GameService plateau, final String fileName) throws FileNotFoundException, IOException;
}
