package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.entitys.Levels;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class PlateauOLD  {

    private final int PLATEAU_HEIGHT = 4;
    private final int PLATEAU_WIDTH = 4;
    private Levels[][] plateau;
    private final Window ihm;

    public PlateauOLD() {
        initaliseJFrameWindow();
        ihm = new Window(new Commands(/*this*/null));
    }

    public void startGame() {
        plateau = new Levels[PLATEAU_HEIGHT][PLATEAU_WIDTH];
        initializePlateau();
        placeNewValue();
//        ihm.printPlateau(getPlateau());
    }

    public void goLeft() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = PLATEAU_WIDTH - 1; j > 0; j--) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if ((upLevel = addLevel(getPlateau()[j - 1][i], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j - 1][i] == Levels.NONE) {
                            plateau[j - 1][i] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    } else {
                        if (justOneMariedByLine) {
                            plateau[j - 1][i] = upLevel;
                            plateau[j][i] = Levels.NONE;
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
//        ihm.printPlateau(getPlateau());
    }

    public void leftGravity() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = PLATEAU_WIDTH - 1; j > 0; j--) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if ((upLevel = addLevel(getPlateau()[j - 1][i], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j - 1][i] == Levels.NONE) {
                            plateau[j - 1][i] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    }
                }
            }
        }
    }

    public void goRight() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if (j + 1 != 4 && (upLevel = addLevel(getPlateau()[j + 1][i], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j + 1][i] == Levels.NONE) {
                            plateau[j + 1][i] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    } else {
                        if (j + 1 != 4 && justOneMariedByLine) {
                            plateau[j + 1][i] = upLevel;
                            plateau[j][i] = Levels.NONE;
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
//        ihm.printPlateau(getPlateau());
    }

    public void rightGravity() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if (j + 1 != 4 && (upLevel = addLevel(getPlateau()[j + 1][i], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j + 1][i] == Levels.NONE) {
                            plateau[j + 1][i] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    }
                }
            }
        }
    }

    public void goDown() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if (i + 1 != 4 && (upLevel = addLevel(getPlateau()[j][i + 1], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j][i + 1] == Levels.NONE) {
                            plateau[j][i + 1] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    } else {
                        if (i + 1 != 4 && justOneMariedByLine) {
                            plateau[j][i + 1] = upLevel;
                            plateau[j][i] = Levels.NONE;
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
//        ihm.printPlateau(getPlateau());
    }

    public void downGravity() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if (i + 1 != 4 && (upLevel = addLevel(getPlateau()[j][i + 1], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j][i + 1] == Levels.NONE) {
                            plateau[j][i + 1] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    }
                }
            }
        }
    }

    public void goUp() {
        for (int i = PLATEAU_HEIGHT - 1; i > 0; i--) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j > PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if ((upLevel = addLevel(getPlateau()[j][i - 1], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j][i - 1] == Levels.NONE) {
                            plateau[j][i - 1] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
                        }
                    } else {
                        if (justOneMariedByLine) {
                            plateau[j][i - 1] = upLevel;
                            plateau[j][i] = Levels.NONE;
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
//        ihm.printPlateau(getPlateau());
    }

    private void upGravity() {
        for (int i = PLATEAU_HEIGHT - 1; i > 0; i--) {
            boolean justOneMariedByLine = true;
            for (int j = 0; j > PLATEAU_WIDTH; j++) {
                if (getPlateau()[j][i] != Levels.NONE) {
                    Levels upLevel = null;
                    if ((upLevel = addLevel(getPlateau()[j][i - 1], getPlateau()[j][i])) == null) {
                        if (getPlateau()[j][i - 1] == Levels.NONE) {
                            plateau[j][i - 1] = getPlateau()[j][i];
                            plateau[j][i] = Levels.NONE;
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
        Random r2 = new Random(time);
        int xValue = 0 + r.nextInt(4 - 0);
        Random r3 = new Random(time);
        int yValue = 0 + r.nextInt(4 - 0);
        return new PosAt(xValue, yValue, getLevelComparedAValue(isTowOrFour));

    }

    private void placeNewValue() {
        PosAt firstElement = newValue();
        if (getPlateau()[firstElement.getX()][firstElement.getY()] == Levels.NONE) {
            plateau[firstElement.getX()][firstElement.getY()] = firstElement.getValue();
        } else {
            placeNewValue();
        }
    }

    private void initializePlateau() {
        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                plateau[i][j] = Levels.NONE;
            }
        }
    }

    private Levels addLevel(Levels levelOne, Levels levelTwo) {
        Levels level = null;
        if (levelOne == levelTwo && levelOne != Levels.NONE && levelTwo != Levels.NONE) {
            switch (levelOne) {
                case LEVEL1:
                    level = Levels.LEVEL2;
                    break;
                case LEVEL2:
                    level = Levels.LEVEL3;
                    break;
                case LEVEL3:
                    level = Levels.LEVEL4;
                    break;
                case LEVEL4:
                    level = Levels.LEVEL5;
                    break;
                case LEVEL5:
                    level = Levels.LEVEL6;
                    break;
                case LEVEL6:
                    level = Levels.LEVEL7;
                    break;
                case LEVEL7:
                    level = Levels.LEVEL8;
                    break;
                case LEVEL8:
                    level = Levels.LEVEL9;
                    break;
                case LEVEL9:
                    level = Levels.LEVEL10;
                    break;
                case LEVEL10:
                    level = Levels.LEVEL11;
                    break;
                default:
                    System.err.println("Houston, we have a problem.");
                    break;
            }
        }
        return level;
    }

    private Levels getLevelComparedAValue(int value) {
        Levels level = null;
        switch (value) {
            case 2:
                level = Levels.LEVEL1;
                break;
            case 4:
                level = Levels.LEVEL2;
                break;
            case 8:
                level = Levels.LEVEL3;
                break;
            case 16:
                level = Levels.LEVEL4;
                break;
            case 32:
                level = Levels.LEVEL5;
                break;
            case 64:
                level = Levels.LEVEL6;
                break;
            case 128:
                level = Levels.LEVEL7;
                break;
            case 254:
                level = Levels.LEVEL8;
                break;
            case 512:
                level = Levels.LEVEL9;
                break;
            case 1024:
                level = Levels.LEVEL10;
                break;
            case 2048:
                level = Levels.LEVEL11;
                break;
            default:
                System.err.println("Houston, we have a problem.");
                break;
        }
        return level;

    }

    public Levels[][] getPlateau() {
        return plateau.clone();
    }

    private final class PosAt {

        private final int x;
        private final int y;
        private final Levels value;

        public PosAt(int x, int y, Levels value) {
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
            return "x=" + x + " y=" + y + "value=" + value.name();
        }

        public Levels getValue() {
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
}
