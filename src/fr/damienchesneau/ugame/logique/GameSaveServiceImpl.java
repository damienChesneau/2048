package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import fr.damienchesneau.ugame.physique.GameSaveServiceData;
import fr.damienchesneau.ugame.physique.PhysiqueFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
class GameSaveServiceImpl implements GameSaveService {

    private final GameSaveServiceData gameSaveSrv = PhysiqueFactory.getGameSaveServiceData();

    @Override
    public GameService getGaveByFileName(final String name) throws FileNotFoundException, IOException {
        List<HistoryItem> history = gameSaveSrv.getGaveByFileName(name);
        GameService game = LogicFactory.getGameService();
        game.startGame(history, false);
        try {
            return game.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(GameSaveServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveGame(final GameService plateau, String fileName) throws FileNotFoundException, IOException {
        Objects.requireNonNull(plateau, "Le plateau est null vous ne pouvez pas effectuer cet opétation.");
        Objects.requireNonNull(fileName, "Vous n'avez pas fourni de nom de fichier.");
        this.gameSaveSrv.saveGame(plateau, fileName);
    }

    @Override
    public void procudeBinary(GameService plateau, String fileName) throws FileNotFoundException, IOException {
        Objects.requireNonNull(plateau, "Le plateau est null vous ne pouvez pas effectuer cet opétation.");
        Objects.requireNonNull(fileName, "Vous n'avez pas fourni de nom de fichier.");
        this.gameSaveSrv.procudeBinary(plateau, fileName);
    }

    @Override
    public GameService getBinaryFileByName(String name) throws IOException {
        List<HistoryItem> history = gameSaveSrv.getBinaryFileByName(name);
        GameService game = LogicFactory.getGameService();
        game.startGame(history, true);
        try {
            return game.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(GameSaveServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
