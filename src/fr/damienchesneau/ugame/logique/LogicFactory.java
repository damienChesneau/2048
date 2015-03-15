package fr.damienchesneau.ugame.logique;

/**
 * Factory qui permet a l'utilisateur de récuperer une implémentation de
 * l'interface qu'il a choisi. Ainsi il ne conait pas la méthode de
 * fonctionnement simplement le service rendu. Si la facon de développer cette
 * partie change nous n'aurons rien d'autre a changer.
 *
 * @author Damien Chesneau
 * <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public class LogicFactory {

    private LogicFactory() {}

    public static GameSaveService getGameSaveService() {
        return new GameSaveServiceImpl();
    }

    public static ArtificialInteligentService getArtificialInteligentService() {
        return new ArtificialInteligentServiceMinMax();
    }

    public static GameService getGameService() {
        return new GameServiceImpl();
    }
}
