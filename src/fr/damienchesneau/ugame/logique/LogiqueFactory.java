package fr.damienchesneau.ugame.logique;

/**
 * Factory qui permet a l'utilisateur de récuperer une implémentation de l'interface qu'il a choisi.
 * Ainsi il ne conait pas la méthode de fonctionnement simplement le service rendu.
 * Si la facon de développer cette partie change nous n'aurons rien d'autre a changer.
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class LogiqueFactory {

    private static GameSaveService gameSave = null;
    private static ArtificialInteligentService inteligentSrv = null;
//    private static GameService gameSrv = null;

    public static GameSaveService getGameSaveService() {
        if (gameSave == null) {
            gameSave = new GameSaveServiceImpl();
        }
        return gameSave;
    }

    public static ArtificialInteligentService getArtificialInteligentService() {
        if (inteligentSrv == null) {
            inteligentSrv = new ArtificialInteligentServiceMinMax();
        }
        return inteligentSrv;
    }

    public static GameService getGameService() {
        return new GameServiceImpl();
    }
}
