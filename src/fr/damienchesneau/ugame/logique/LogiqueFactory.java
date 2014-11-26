
package fr.damienchesneau.ugame.logique;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class LogiqueFactory {
    private static GameSaveService gameSave = null;
    
    public static GameSaveService getGameSaveService(){
        if(gameSave == null){
            gameSave = new GameSaveServiceImpl();
        }
        return gameSave;
    }
}
