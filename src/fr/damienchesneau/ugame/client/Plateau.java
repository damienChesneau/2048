package fr.damienchesneau.ugame.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Plateau implements Cloneable {

    private final int PLATEAU_HEIGHT = 4;
    private final int PLATEAU_WIDTH = 4;
    private int[][] plateau;
    private final Window ihm;
    private boolean gameOver = false;
    private int score = 0;
    private boolean ingame = false;

    public Plateau() {
        initaliseJFrameWindow();
        ihm = new Window(new Commands(this));
    }

    public void startGame() {

        initializePlateau();
    }

    public int goLeft() {
        if (isGameOver()) {
            return score;
        }
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = PLATEAU_WIDTH - 1; j > 0; j--) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if ((upLevel = addLevel(plateau[j - 1][i], plateau[j][i])) == 0) {
                        if (plateau[j - 1][i] == 0) {
                            plateau[j - 1][i] = plateau[j][i];
                            plateau[j][i] = 0;
                        }
                    } else {
                        if (justOneMariedByLine) {
                            plateau[j - 1][i] = upLevel;
                            setScore(getScore() + upLevel);
                            plateau[j][i] = 0;
                            justOneMariedByLine = false;
                        }
                    }
                }
            }
        }
        leftGravity();
        leftGravity();
        leftGravity();
        leftGravity();
        placeNewValue();
        ihm.printPlateau(plateau);
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public void leftGravity() {
        if (isGameOver()) {
            return;
        }
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

    public int goRight() {
        if (isGameOver()) {
            return score;
        }
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
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
        rightGravity();
        rightGravity();
        rightGravity();
        rightGravity();
        placeNewValue();
        ihm.printPlateau(getPlateau());
        return score;
    }

    public void rightGravity() {
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

    public int goDown() {
        if (isGameOver()) {
            return score;
        }
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != 0) {
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
        downGravity();
        downGravity();
        downGravity();
        downGravity();
        placeNewValue();
        ihm.printPlateau(plateau);
        return score;
    }

    public void downGravity() {
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

    public int goUp() {
        if (isGameOver()) {
            return score;
        }
        for (int i = PLATEAU_HEIGHT - 1; i > 0; i--) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j > PLATEAU_WIDTH; j++) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if ((upLevel = addLevel(plateau[j][i - 1], plateau[j][i])) == 0) {
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
        upGravity();
        upGravity();
        upGravity();
        upGravity();
        placeNewValue();
        ihm.printPlateau(plateau);
        return score;
    }

    private void upGravity() {
        for (int i = PLATEAU_HEIGHT - 1; i > 0; i--) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j > PLATEAU_WIDTH; j++) {
                if (plateau[j][i] != 0) {
                    int upLevel = 0;
                    if ((upLevel = addLevel(plateau[j][i - 1], plateau[j][i])) == 0) {
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
            gameOver = true;
            return null;
        }
        Random r2 = new Random(time);
        int index = 0 + r.nextInt(ids.size() - 0);
        int iValue = getIById(ids.get(index));
        int jValue = getJById(ids.get(index));
        return new PosAt(iValue, jValue, (isTowOrFour));
    }

    private void gameOver() {
        System.err.println("Game over");
        ihm.infoGameOver();
        gameOver = true;
        ingame = false;
    }

    public boolean isInGame() {
        return ingame;
    }

    public int getIById(int id) {
        return Integer.parseInt(new Integer(id).toString().substring(0, 1));
    }

    public int getJById(int id) {
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

    private void placeNewValue() {
        PosAt firstElement = newValue();
        if (firstElement != null && plateau[firstElement.getX()][firstElement.getY()] == 0) {
            if (numberOfEmptyCell() == 0) {
                gameOver();
            } else {
                plateau[firstElement.getX()][firstElement.getY()] = firstElement.getValue();
            }
        } else {
            //placeNewValue();
        }
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
        ihm.printPlateau(plateau);
        ingame = true;
    }

    private int addLevel(int levelOne, int levelTwo) {
        int level = 0;
        if (levelOne == levelTwo && levelOne != 0 && levelTwo != 0) {
            level = levelOne * 2;
        }
        return level;
    }

    public int[][] getPlateau() {
        return plateau.clone();
    }

    public boolean isGameOver() {
        return gameOver;
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

    private void initaliseJFrameWindow() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public int getScore() {
        return score;
    }

    public int getNumberOfEmptyCells() {
        return getEmptyCellIds().size();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Plateau copy = (Plateau) super.clone();
        copy.plateau = (cloneAMartice(this.plateau));
        return copy;
    }

    private int[][] cloneAMartice(int[][] toclone) {
        int[][] cloned = new int[PLATEAU_HEIGHT][PLATEAU_WIDTH];
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
                plateau[i]= toclone[i].clone();
        }
        return cloned;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj instanceof Plateau) {
            Plateau p2 = (Plateau) obj;
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

}
