package fr.damienchesneau.ugame.logique.entitys;

/**
 * Cette classe entité permet de pouvoir encapsuler l'histoire du jeux.
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class HistoryItem {

    private final int startItem;
    private final int horizontal;
    private final int vertical;
    private Direction direction;

    public HistoryItem(int startItem, int horizontal, int vertical) {
        this.startItem = startItem;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public HistoryItem(int startItem, int horizontal, int vertical, Direction direction) {
        this(startItem, horizontal, vertical);
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        String dir = "ERROR";
        if (getDirection() != null) {
            switch (getDirection()) {
                case DOWN:
                    dir = "S";
                    break;
                case UP:
                    dir = "N";
                    break;
                case LEFT:
                    dir = "W";
                    break;
                case RIGHT:
                    dir = "E";
                    break;
            }
        } else {
            dir = "";
        }
        return dir + getStartItem() + (getVertical() == -1 ? "" : getVertical()) + (getHorizontal() == -1 ? "" : getHorizontal());
    }

    public int getStartItem() {
        return startItem;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public Direction getDirection() {
        return direction;
    }

}
