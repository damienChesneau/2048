package fr.damienchesneau.ugame;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Plateau {

    private final int PLATEAU_HEIGHT = 4;
    private final int PLATEAU_WIDTH = 4;
    private Levels[][] plateau;
    private final Window ihm;

    public Plateau() {
        initaliseWindow();
        ihm = new Window(new Commands(this));
    }

    public void startGame() {
        plateau = new Levels[PLATEAU_HEIGHT][PLATEAU_WIDTH];
        initializePlateau();
        placeNewValue();
        ihm.printPlateau(plateau);
    }

    public void goLeft() {
        int nbNone = 0;

        for (int i = 0; i < PLATEAU_HEIGHT; i++) {
            for (int j = 0; j < PLATEAU_WIDTH; j++) {
                if (plateau[i][j] != Levels.NONE && j != 0&& i != 0) {
                    Levels l = null;
                    if ((l = addLevel(plateau[i - 1][j], plateau[i][j])) == null) {
                        if (plateau[i][j - 1] == Levels.NONE) {
                            plateau[i - 1][j] = plateau[i][j];
                            plateau[i][j] = Levels.NONE;
                        }
                    } else {
                        plateau[i - 1][j] = l;
                        plateau[i][j] = Levels.NONE;
                    }
                }
            }
        }
        placeNewValue();
        ihm.printPlateau(plateau);
        System.out.println("Je suis la");
    }

    public void goRight() {

    }

    public void goDown() {

    }

    public void goUp() {

    }

    private PosAt newValue() {
        Random r = new Random(new Date().getTime());
        int valeur = 0 + r.nextInt(9 - 0);
        int isTowOrFour = 2;
        if (valeur == 1) {
            isTowOrFour = 4;
        }
        Random r2 = new Random(new Date().getTime());
        int xValue = 0 + r.nextInt(3 - 0);
        Random r3 = new Random(new Date().getTime());
        int yValue = 0 + r.nextInt(3 - 0);
        return new PosAt(xValue, yValue, getLevelComparedAValue(isTowOrFour));

    }

    private void placeNewValue() {
        PosAt firstElement = newValue();
        if (plateau[firstElement.getX()][firstElement.getY()] == Levels.NONE) {
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
            return "x=" + x + " y=" + y + "value=" + value.name(); //To change body of generated methods, choose Tools | Templates.
        }

        public Levels getValue() {
            return value;
        }

    }

    private void initaliseWindow() {
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
