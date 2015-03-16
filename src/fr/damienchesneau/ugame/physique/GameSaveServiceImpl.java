package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Damien Chesneau
 * <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
class GameSaveServiceImpl implements GameSaveServiceData {

    @Override
    public List<HistoryItem> getGaveByFileName(String name) throws IOException {
        String line;
        LinkedList<HistoryItem> history = new LinkedList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(name), Charset.forName("UTF-8"))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                    Direction direction = null;
                    int vertical;
                    int horizontal;
                    int number;
                    int index = 0;
                    if (line.startsWith("N") || line.startsWith("S") || line.startsWith("W") || line.startsWith("E")) {
                        String directionStt = line.substring(0, 1);
                        switch (directionStt) {
                            case "N":
                                direction = Direction.UP;
                                break;
                            case "S":
                                direction = Direction.DOWN;
                                break;
                            case "W":
                                direction = Direction.LEFT;
                                break;
                            case "E":
                                direction = Direction.RIGHT;
                                break;
                        }
                        index++;
                    }
                    String s = line.substring(index + 1, index + 2);
                    horizontal = Integer.parseInt(line.substring(index + 2, index + 3));
                    vertical = Integer.parseInt(line.substring(index + 1, index + 2));
                    number = Integer.parseInt(line.substring(index, index + 1));
                    HistoryItem item = new HistoryItem(number, horizontal, vertical, direction);
                    history.add(item);
                }
            }
        }
        return history;
    }

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

    @Override
    public void procudeBinary(GameService game, String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        List<HistoryItem> gameHistory = game.getGameHistory();
        for (int i = 0; i < gameHistory.size(); i++) {
            if (gameHistory.get(i).getStartItem() == 2) {
                fos.write("0".getBytes());
            } else if (gameHistory.get(i).getStartItem() == 4) {
                fos.write("1".getBytes());
            }
        }
        fos.close();
    }

    @Override
    public List<HistoryItem> getBinaryFileByName(String name) throws IOException {
        String line;
        LinkedList<HistoryItem> history = new LinkedList<>();
        FileInputStream fis = new FileInputStream(new File(name));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("#")) {
                for (int i = 0; i < line.length(); i++) {
                    int val = Integer.valueOf(line.substring(i, i + 1));
                    HistoryItem item = new HistoryItem(val == 1 ? 4 : 2, -1, -1, null);
                    history.add(item);
                }
            }
        }
        return history;
    }

}
