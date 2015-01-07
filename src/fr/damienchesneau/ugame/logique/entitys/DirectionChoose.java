
package fr.damienchesneau.ugame.logique.entitys;

import fr.damienchesneau.ugame.logique.GameService;

/**
 * Classe entité permettant de referencer les choix possibles et leurs valeur.
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class DirectionChoose {
    /**
     * The score you will have if you chose this direction.
     */
    private final int score;
    private final Direction direction;
    private final GameService game;
    
    public DirectionChoose(int score, Direction dir,GameService game){
        this.score = score;
        this.direction = dir;
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public Direction getDirection() {
        return direction;
    }

    public GameService getGame() {
        return game;
    }
    
}
