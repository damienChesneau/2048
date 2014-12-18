package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.logique.entitys.Direction;
import fr.damienchesneau.ugame.logique.entitys.HistoryItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
class GameServiceImpl implements GameService {

    private final int PLATEAU_HEIGHT = 4;
    private final int PLATEAU_WIDTH = 4;

    private LinkedList<HistoryItem> gameHistory = new LinkedList<>();
    private int[][] plateau; // i colones J lignes
    private int score = 0;
    private int updatePlateau = 0;
    private boolean gameOver = false;
    private boolean ingame = false;
    private boolean win = false;

    public GameServiceImpl() {
        ingame = true;
        gameHistory = new LinkedList<>();
    }

    public GameServiceImpl(int[][] plateau, int score) {
        this();
        this.plateau = Objects.requireNonNull(plateau);
        this.score = score;
    }

    @Override
    public int[][] startGame() {
        gameHistory = new LinkedList<>();
        initializePlateau();
        score = 0;
        ingame = true;
        return plateau;
    }

    @Override
    public void startGame(int[][] plateau, int score) {
        gameHistory = new LinkedList<>();
        this.plateau = plateau;
        setScore(score);
        placeNewValue();
        placeNewValue();
        ingame = true;
    }

    @Override
    public GameService startGame(List<HistoryItem> history) {
        gameHistory.addAll(history);
        ingame = true;
        setScore(0);
        plateau = new int[PLATEAU_HEIGHT][PLATEAU_WIDTH];
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                plateau[i][j] = 0;
            }
        }
        for (HistoryItem historyItem : history) {
            Direction d = null;
            if ((d = historyItem.getDirection()) != null) {
                switch (d) {
                    case LEFT:
                        goLeft(false);
                        break;
                    case RIGHT:
                        goRight(false);
                        break;
                    case UP:
                        goUp(false);
                        break;
                    case DOWN:
                        goDown(false);
                        break;
                }
            }
            plateau[historyItem.getHorizontal()-1][historyItem.getVertical()-1] = historyItem.getStartItem();
        }
        return this;
    }

    @Override
    public Map<String, Object> goLeft() {
        return goLeft(true);
    }

    private Map<String, Object> goLeft(boolean updateHisto) {
        leftGravity();
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[j][i] != 0 && j - 1 != -1) {
                    int upLevel = 0;
                    if ((upLevel = addLevel(plateau[j - 1][i], plateau[j][i])) == 0) {
                        if (plateau[j - 1][i] == 0) {
                            plateau[j - 1][i] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    } else {
                        if (justOneMariedByLine) {
                            plateau[j - 1][i] = upLevel;
                            plateau[j][i] = 0;
                            justOneMariedByLine = false;
                        }
                    }
                }
            }
        }
        leftGravity();
        updatePlateau++;
        if (updateHisto) {
            updateLastHistory(Direction.LEFT);
        }
        return formatTheRet();
    }

    private void updateLastHistory(Direction dir) {
        placeNewValue();
        if (gameHistory.size() >= 2) {
            HistoryItem get = gameHistory.get(gameHistory.size() - 1);
            if (get != null) {
                get.setDirection(dir);
            }
        }
    }

    private Map<String, Object> formatTheRet() {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put(GameService.KEY_SCORE, score);
        ret.put(GameService.KEY_PLATEAU, getPlateau());
        return ret;
    }

    private void setScore(int score) {
        this.score = score;
    }

    private void leftGravity() {
//        if (isGameOver()) {
//            return;
//        }
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = PLATEAU_WIDTH - 1; j > 0; j--) {
                if (getPlateau()[j][i] != 0) {
                    int upLevel = 0;
                    if ((upLevel = addLevel(plateau[j - 1][i], plateau[j][i])) == 0) {
                        if (getPlateau()[j - 1][i] == 0) {
                            plateau[j - 1][i] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    }
                }
            }
        }
    }

    public Map<String, Object> goRight() {
        return goRight(true);
    }

    public Map<String, Object> goRight(boolean updateHisto) {
        rightGravity();
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = PLATEAU_WIDTH - 1; j > -1; j--) {
                if (getPlateau()[j][i] != 0) {
                    int upLevel = 0;
                    if (j + 1 != 4 && (upLevel = addLevel(plateau[j + 1][i], plateau[j][i])) == 0) {
                        if (getPlateau()[j + 1][i] == 0) {
                            plateau[j + 1][i] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    } else {
                        if (j + 1 != 4 && justOneMariedByLine) {
                            plateau[j + 1][i] = upLevel;
                            plateau[j][i] = 0;
                            justOneMariedByLine = false;
                        }
                    }
                }
            }
        }
        if (updateHisto) {
            updateLastHistory(Direction.RIGHT);
        }
        rightGravity();
        updatePlateau++;
        return formatTheRet();
    }

    private void rightGravity() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if (j + 1 != 4 && (upLevel = addLevel(plateau[j + 1][i], plateau[j][i])) == 0) {
                        if (plateau[j + 1][i] == 0) {
                            plateau[j + 1][i] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    }
                }
            }
        }
    }

    @Override
    public Map<String, Object> goDown() {
        return goDown(true);
    }

    public Map<String, Object> goDown(boolean history) {
//        if (isGameOver()) {
//            return formatTheRet();
//        }
        downGravity();
        for (int j = 0; j < PLATEAU_WIDTH; j++) {//LIGNES
            boolean justOneMariedByLine = true;
            for (int i = PLATEAU_HEIGHT - 1; i > -1; i--) {//COLONES 
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if (i + 1 != 4 && (upLevel = addLevel(plateau[j][i + 1], plateau[j][i])) == 0) {
                        if (plateau[j][i + 1] == 0) {
                            plateau[j][i + 1] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    } else {
                        if (i + 1 != 4 && justOneMariedByLine) {
                            plateau[j][i + 1] = upLevel;
                            plateau[j][i] = 0;
                            justOneMariedByLine = false;
                        }
                    }
                }
            }
        }
        if (history) {
            updateLastHistory(Direction.DOWN);
        }
        downGravity();
//        placeNewValue();
        updatePlateau++;
        return formatTheRet();
    }

    private void downGravity() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if (i + 1 != 4 && (upLevel = addLevel(plateau[j][i + 1], plateau[j][i])) == 0) {
                        if (plateau[j][i + 1] == 0) {
                            plateau[j][i + 1] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    }
                }
            }
        }
    }

    @Override
    public Map<String, Object> goUp() {
        return goUp(true);
    }

    public Map<String, Object> goUp(boolean history) {
//        if (isGameOver()) {
//            return formatTheRet();
//        }
        upGravity();
        for (int j = 0; j < PLATEAU_WIDTH; j++) {
            boolean justOneMariedByLine = true;
            for (int i = 1; i < PLATEAU_HEIGHT; i++) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if (i - 1 != -1 && (upLevel = addLevel(plateau[j][i - 1], plateau[j][i])) == 0) {
                        if (plateau[j][i - 1] == 0) {
                            plateau[j][i - 1] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    } else {
                        if (justOneMariedByLine) {
                            plateau[j][i - 1] = upLevel;
                            plateau[j][i] = 0;
                            justOneMariedByLine = false;
                        }
                    }
                }
            }
        }
        if (history) {
            updateLastHistory(Direction.UP);
        }
        upGravity();
//        placeNewValue();
        updatePlateau++;
        return formatTheRet();
    }

    private void upGravity() {
        for (int i = PLATEAU_HEIGHT - 1; i > 0; i--) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if (i - 1 != -1 && (upLevel = addLevel(plateau[j][i - 1], plateau[j][i])) == 0) {
                        if (plateau[j][i - 1] == 0) {
                            plateau[j][i - 1] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    }
                }
            }
        }
    }

    private PosAt newValue() {
        long time = new Date().getTime();
        Random r = new Random(time);
        int valeur = 0 + r.nextInt(9 - 0);
        int isTowOrFour = 2;
        if (valeur == 1) {
            isTowOrFour = 4;
        }
        List<Integer> ids = getEmptyCellIds();
        if (ids.size() == 0) {
            gameOver();
            return null;
        }
        Random r2 = new Random(time);
        int index = 0 + r.nextInt(ids.size() - 0);
        int iValue = getIById(ids.get(index));
        int jValue = getJById(ids.get(index));
        return new PosAt(iValue, jValue, (isTowOrFour));
    }

    private void gameOver() {
        gameOver = true;
        ingame = false;
    }

    @Override
    public boolean isInGame() {
        return ingame;
    }

    private int getIById(int id) {
        return Integer.parseInt(new Integer(id).toString().substring(0, 1));
    }

    private int getJById(int id) {
        int jValue = 0;
        if (new Integer(id).toString().length() != 1) {
            jValue = Integer.parseInt(new Integer(id).toString().toString().substring(1, 2));
        }
        return jValue;
    }

    public List<Integer> getEmptyCellIds() {
        List<Integer> idDispo = new ArrayList<Integer>();
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[i][j] == 0) {
                    idDispo.add(Integer.parseInt(Integer.toString(i) + Integer.toString(j)));
                }
            }
        }
        return idDispo;
    }

    private void placeValueWithData(int x, int y, int value) {
        plateau[x][y] = value;
    }

    private boolean placeNewValue() {
        PosAt firstElement = newValue();
        if (firstElement != null && plateau[firstElement.getX()][firstElement.getY()] == 0) {
            plateau[firstElement.getX()][firstElement.getY()] = firstElement.getValue();
            gameHistory.addLast(new HistoryItem(firstElement.getValue(),firstElement.getX()+1, firstElement.getY()+1 ));
        } else {
//            placeNewValue();
        }
        if (numberOfEmptyCell() == 0) {
            gameOver();
            return false;
        }
        return true;
    }

    public int numberOfEmptyCell() {
        int nb = 0;
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[i][j] == 0) {
                    nb++;
                }
            }
        }
        return nb;
    }

    private void initializePlateau() {
        plateau = new int[PLATEAU_HEIGHT][PLATEAU_WIDTH];
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                plateau[i][j] = 0;
            }
        }
        placeNewValue();
        placeNewValue();
        ingame = true;
    }

    private int addLevel(int levelOne, int levelTwo) {
        int level = 0;
        if (levelOne == levelTwo && levelOne != 0 && levelTwo != 0) {
            level = levelOne * 2;
            setScore(getScore() + level);
            if (level == 2048) {
                ingame = false;
                win = true;
//                System.out.println("--------------------------- 2048 ------------------------------------");
            }
        }
        return level;
    }

    @Override
    public boolean isWin() {
        return win;
    }

    @Override
    public int[][] getPlateau() {
        return cloneAMartice(plateau);
    }

    @Override
    public boolean isGameOver() {
        boolean gameOverRet = false;
        if (isWin()) {
            gameOverRet = false;
        } else {
            boolean zero = Arrays.asList(plateau).contains(0);
            if (!zero) {
                int oldScore = this.getScore();
                GameService clonedGame = null;
                try {
                    clonedGame = ((GameService) this.clone());
                    if ((((int) clonedGame.goLeft().get(GameService.KEY_SCORE)) == oldScore)
                            && (((int) clonedGame.goDown().get(GameService.KEY_SCORE)) == oldScore)
                            && (((int) clonedGame.goUp().get(GameService.KEY_SCORE)) == oldScore)
                            && (((int) clonedGame.goRight().get(GameService.KEY_SCORE)) == oldScore)) {
                        gameOverRet = true;
                    }
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(GameServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        }
        return gameOverRet;
    }

    @Override
    public GameService clone() throws CloneNotSupportedException {
        return new GameServiceImpl(getPlateau(), new Integer(score));
    }

    public boolean isIngame() {
        return ingame;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getNumberOfEmptyCells() {
        return getEmptyCellIds().size();
    }

    public int[][] cloneAMartice(int[][] toclone) {
        int[][] cloned = new int[PLATEAU_HEIGHT][PLATEAU_WIDTH];
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            cloned[i] = toclone[i].clone();
        }
        return cloned;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj instanceof GameService) {
            GameService p2 = (GameService) obj;
            ret = true;
            for (int i = 0; i < PLATEAU_HEIGHT; i++) {
                for (int j = 0; j < PLATEAU_WIDTH; j++) {
                    if (this.plateau[i][j] != p2.getPlateau()[i][j]) {
                        ret = false;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public Map<String, Object> getDatas() {
        Map<String, Object> toRet = new HashMap<>();
        toRet.put(GameService.KEY_PLATEAU, getPlateau());
        toRet.put(GameService.KEY_SCORE, getScore());
        return toRet;
    }

    public List<HistoryItem> getGameHistory() {
        return gameHistory;
    }

    private final class PosAt {

        private final int x;
        private final int y;
        private final int value;

        public PosAt(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "x=" + x + " y=" + y + "value=" + value;
        }

        public int getValue() {
            return value;
        }
    }
}
