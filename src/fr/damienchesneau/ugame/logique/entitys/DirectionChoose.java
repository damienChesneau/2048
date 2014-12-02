
package fr.damienchesneau.ugame.logique.entitys;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class DirectionChoose {
    /**
     * The score you will have if you chose this direction.
     */
    private final int score;
    private final Direction direction;
    private final int[][] plateau;
    public DirectionChoose(int score, Direction dir,int[][] plateau){
        this.score = score;
        this.direction = dir;
        this.plateau = plateau;
    }

    public int getScore() {
        return score;
    }

    public Direction getDirection() {
        return direction;
    }
    public int[][] getPlateau(){
        return plateau;
    }
    
}
