package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.entitys.Levels;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class GameSaveServiceImpl implements GameSaveServiceData {

    @Override
    public Levels[][] getGaveByFileName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveGame(final Levels[][] plateau, final String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject("#\n#\n");
        oos.writeObject("2VH\n2VH\n");
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                System.out.println("j= "+j+" i="+i+" "+plateau[i][j]);
            }
        }
    }

}
