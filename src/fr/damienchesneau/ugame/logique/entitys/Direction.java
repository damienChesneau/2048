package fr.damienchesneau.ugame.logique.entitys;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple énumération des directions possibles
 *
 * @author Damien Chesneau
 * <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public enum Direction {

    UP, DOWN, LEFT, RIGHT;
    
    private static Map<String, Direction> e = new HashMap<>();

    static {
        e.put("N", Direction.UP);
        e.put("S", Direction.DOWN);
        e.put("W", Direction.LEFT);
        e.put("E", Direction.RIGHT);
    }

    public static Map<String, Direction> getDirectionByString() {
        return e;
    }
}
