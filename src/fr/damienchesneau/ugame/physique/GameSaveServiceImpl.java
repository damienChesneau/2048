package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class GameSaveServiceImpl implements GameSaveServiceData {

    @Override
    public List<HistoryItem> getGaveByFileName(String name) throws IOException {
        String line;
        LinkedList<HistoryItem> history = new LinkedList<>();
        FileInputStream fis = new FileInputStream(new File(name));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("#")) {
                Direction direction = null;
                int vertical;
                int horizontal;
                int number;
                int index = 0;
                if (line.startsWith("N") || line.startsWith("S") || line.startsWith("O") || line.startsWith("E")) {
                    String directionStt = line.substring(0, 1);
                    switch (directionStt) {
                        case "N":
                            direction = Direction.UP;
                            break;
                        case "S":
                            direction = Direction.DOWN;
                            break;
                        case "O":
                            direction = Direction.LEFT;
                            break;
                        case "E":
                            direction = Direction.RIGHT;
                            break;
                    }
                    index++;
                }
                horizontal = Integer.parseInt(line.substring(index + 2, 1));
                vertical = Integer.parseInt(line.substring(index + 1, 1));
                number = Integer.parseInt(line.substring(index, 1));
                HistoryItem item = new HistoryItem(number, horizontal, vertical, direction);
            }
        }
        return null;
    }
    /*
     214
     244
     # remarquez que le fichier n'est pas au format du sujet 
     # n effet la direction jouée par le joeur est en premier puis la nouvelle valeur
     N211
     W231
     N212
     W234
     N422
     */

    @Override
    public void saveGame(final GameService game, final String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        List<HistoryItem> gameHistory = game.getGameHistory();
        for (int i = 0; i < gameHistory.size(); i++) {
            fos.write((gameHistory.get(i) + "\n").getBytes());
            if (i == 1) {
                fos.write(("#\n").getBytes());
                fos.write(("#\n").getBytes());
            }
        }
        fos.close();
    }

}
