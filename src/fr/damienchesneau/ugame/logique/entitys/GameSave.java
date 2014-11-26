package fr.damienchesneau.ugame.logique.entitys;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class GameSave {

    private final Levels[][] plateau;

    public GameSave(Levels[][] plateau) {
        this.plateau = plateau;
    }

    public Levels[][] getPlateau() {
        return plateau;
    }

}
