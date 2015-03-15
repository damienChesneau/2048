package fr.damienchesneau.ugame.logique;

import fr.damienchesneau.ugame.logique.entitys.DirectionChoose;
import java.util.Map;

/**
 * Ce que l'utilisateur veux c'est résoudre le jeu. Il n'a rien a faire de savoir comment cela se passe.
 * Grâce a cette interface c'est ce que je fais. 
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public interface ArtificialInteligentService {

    public Map<String, Object> solveGame(GameService game) throws Exception;

    public DirectionChoose getBestDirection(GameService p) throws Exception;
}
