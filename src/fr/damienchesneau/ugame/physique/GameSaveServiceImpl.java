package fr.damienchesneau.ugame.physique;

import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        ArrayList<HistoryItem> history = new ArrayList<>();
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
                        direction = Direction.getDirectionByString().get(directionStt);
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
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
            List<HistoryItem> gameHistory = game.getGameHistory();
            for (int i = 0; i < gameHistory.size(); i++) {
                bw.append(gameHistory.get(i) + "\n");
                if (i == 1) {
                    bw.append("#\n");
                    bw.append("#\n");
                }
                bw.flush();
            }
        }
    }

    @Override
    public void procudeBinary(GameService game, String fileName) throws FileNotFoundException, IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName))) {
            List<HistoryItem> gameHistory = game.getGameHistory();
            for (HistoryItem gameHistory1 : gameHistory) {
                if (gameHistory1.getStartItem() == 2) {
                    bw.write("0");
                } else if (gameHistory1.getStartItem() == 4) {
                    bw.write("1");
                }
            }
        }
    }

    @Override
    public List<HistoryItem> getBinaryFileByName(String name) throws IOException {
        String line;
        ArrayList<HistoryItem> history = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(name), Charset.forName("UTF-8"))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                    for (int i = 0; i < line.length(); i++) {
                        int val = Integer.valueOf(line.substring(i, i + 1));
                        HistoryItem item = new HistoryItem(val == 1 ? 4 : 2, -1, -1, null);
                        history.add(item);
                    }
                }
            }
        }
        return history;
    }

}
