
package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.physique.GameSaveServiceData;
import fr.damienchesneau.ugame.physique.PhysiqueFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class GameSaveServiceImpl implements GameSaveService{

    private final GameSaveServiceData gameSaveSrv = PhysiqueFactory.getGameSaveServiceData();

    @Override
    public GameService getGaveByFileName(final String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveGame(final GameService plateau, String fileName) throws FileNotFoundException, IOException {
        Objects.requireNonNull(plateau, "Le plateau est null vous ne pouvez pas effectuer cet opétation.");
        Objects.requireNonNull(fileName, "Vous n'avez pas fourni de nom de fichier.");
        this.gameSaveSrv.saveGame(plateau, fileName);
    }

}
