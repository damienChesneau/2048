
package fr.damienchesneau.ugame.physique;

/**
 * Factory qui permet a l'utilisateur de récuperer une implémentation de l'interface qu'il a choisi.
 * Ainsi il ne conait pas la méthode de fonctionnement simplement le service rendu.
 * Si la facon de développer cette partie change nous n'aurons rien d'autre a changer.
 * 
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public class PhysiqueFactory {
    
    private PhysiqueFactory(){}
       
    public static GameSaveServiceData getGameSaveServiceData(){
        return  new GameSaveServiceImpl();
    }
}
