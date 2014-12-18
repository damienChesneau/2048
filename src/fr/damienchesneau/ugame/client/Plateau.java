package fr.damienchesneau.ugame.client;

import fr.damienchesneau.ugame.logique.GameService;
import fr.damienchesneau.ugame.logique.LogiqueFactory;
import java.util.Map;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Plateau implements Cloneable {

    private final Window ihm;
    private GameService gameSrv = null;

    public Plateau() {
        gameSrv = LogiqueFactory.getGameService();
        ihm = new Window(new Commands(this));
        initaliseJFrameWindow();
        updateWindow(gameSrv.startGame(), 0);
    }

    public void startGame() {
        int[][] startGame = gameSrv.startGame();
        updateWindow(startGame, 0);
    }
    public void startGame(GameService game){
        gameSrv = game;
        updateWindow(game.getPlateau(), game.getScore());
    }
    
    public void startGame(int[][] plateau, int score) {
        gameSrv.startGame(plateau, score);
        updateWindow(plateau, score);
    }

    public void goLeft() {
        Map<String, Object> goLeft = gameSrv.goLeft();
        updateWindow((int[][]) goLeft.get(GameService.KEY_PLATEAU), (int) goLeft.get(GameService.KEY_SCORE));
    }

    public void goRight() {
        Map<String, Object> goRight = gameSrv.goRight();
        updateWindow((int[][]) goRight.get(GameService.KEY_PLATEAU), (int) goRight.get(GameService.KEY_SCORE));
    }

    public void goDown() {
        Map<String, Object> goDown = gameSrv.goDown();
        updateWindow((int[][]) goDown.get(GameService.KEY_PLATEAU), (int) goDown.get(GameService.KEY_SCORE));
    }

    public void goUp() {
        Map<String, Object> goUp = gameSrv.goUp();
        updateWindow((int[][]) goUp.get(GameService.KEY_PLATEAU), (int) goUp.get(GameService.KEY_SCORE));
    }
    private static int nb = 0;

    private void updateWindow(int[][] plateau, int score) {
        nb++;
        ihm.printPlateau(plateau);
        ihm.setScore(score);
        if (nb >= 110) {
            System.out.println("edsqw");
        }
        if (gameSrv.isGameOver()) {
            ihm.infoGameOver();
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

    public GameService getGame() {
        return gameSrv;
    }
}
