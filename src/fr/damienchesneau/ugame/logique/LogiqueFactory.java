package fr.damienchesneau.ugame.logique;

/**
 *
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
