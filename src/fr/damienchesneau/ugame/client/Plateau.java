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
        ihm.printPlateau(gameSrv.startGame());
    }

    public void startGame() {
        int[][] startGame = gameSrv.startGame();
    }

    public void goLeft() {
        Map<String, Object> goLeft = gameSrv.goLeft();
        ihm.printPlateau((int[][]) goLeft.get(GameService.KEY_PLATEAU));
    }

    private void setScore(int score) {
//        this.score = score;
    }

    public void goRight() {
        Map<String, Object> goLeft = gameSrv.goRight();
        ihm.printPlateau((int[][]) goLeft.get(GameService.KEY_PLATEAU));
    }

    public void goDown() {
        Map<String, Object> goLeft = gameSrv.goDown();
        ihm.printPlateau((int[][]) goLeft.get(GameService.KEY_PLATEAU));
    }

    public void goUp() {
        Map<String, Object> goLeft = gameSrv.goUp();
        ihm.printPlateau((int[][]) goLeft.get(GameService.KEY_PLATEAU));
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
    public GameService getGame(){
        return gameSrv;
    }
}
