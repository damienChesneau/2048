package fr.damienchesneau.ugame.logique;

import java.util.Map;

/**
 * Ce que l'utilisateur veux c'est résoudre le jeu. Il n'a rien a faire de savoir comment cela se passe.
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public interface ArtificialInteligentService {

    public Map<String, Object> solveGame(GameService game) throws CloneNotSupportedException;

}
