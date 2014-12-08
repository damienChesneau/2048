package fr.damienchesneau.ugame.logique;

import java.util.Map;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public interface ArtificialInteligentService {

    public Map<String, Object> solveGame(GameService game) throws CloneNotSupportedException;

}
