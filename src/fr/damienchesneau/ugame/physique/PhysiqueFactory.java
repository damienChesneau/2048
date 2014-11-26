
package fr.damienchesneau.ugame.physique;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class PhysiqueFactory {
    private PhysiqueFactory(){}
    
    private static GameSaveServiceData gameSaveSrv = null;
    
    public static GameSaveServiceData getGameSaveServiceData(){
        if(gameSaveSrv == null){
            gameSaveSrv = new GameSaveServiceImpl();
        }
        return gameSaveSrv;
    }
}
