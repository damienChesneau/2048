package fr.damienchesneau.ugame.logique;

import java.util.Map;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public interface GameService extends Cloneable {

    public static final String KEY_PLATEAU = "plateau";
    public static final String KEY_SCORE = "score";

    /**
     * initialise all for start a game.
     *
     * @return int[][] the plateau
     */
    public int[][] startGame();

    /**
     *
     * @param plateau a int matrice
     * @param score
     */
    public void startGame(int[][] plateau,int score);

    /**
     * GO all to left      <code>
     * Map<String, Object> ret = new HashMap<String, Object>(); <br>
     * ret.put(GameService.KEY_SCORE,score); <br>
     * ret.put(GameService.KEY_PLATEAU, getPlateau());<br>
     * </code>
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> goLeft();

    /**
     * go all to right      <code>
     * Map<String, Object> ret = new HashMap<String, Object>(); <br>
     * ret.put(GameService.KEY_SCORE,score); <br>
     * ret.put(GameService.KEY_PLATEAU, getPlateau());<br>
     * </code>
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> goRight();

    /**
     * go allll to down      <code>
     * Map<String, Object> ret = new HashMap<String, Object>(); <br>
     * ret.put(GameService.KEY_SCORE,score); <br>
     * ret.put(GameService.KEY_PLATEAU, getPlateau());<br>
     * </code>
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> goDown();

    /**
     * go all to up      <code>
     * Map<String, Object> ret = new HashMap<String, Object>(); <br>
     * ret.put(GameService.KEY_SCORE,score); <br>
     * ret.put(GameService.KEY_PLATEAU, getPlateau());<br>
     * </code>
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> goUp();

    /**
     *
     * @param toclone int matrice
     * @return cloned int matirce
     */
    public int[][] cloneAMartice(int[][] toclone);

    public int[][] getPlateau();

    public GameService clone() throws CloneNotSupportedException;
    
    public boolean isGameOver();
    
    public boolean isInGame();
    
    public int getScore();
    
    public int getNumberOfEmptyCells();
    
    public boolean equals(Object obj);
}
