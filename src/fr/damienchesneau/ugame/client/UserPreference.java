package fr.damienchesneau.ugame.client;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class UserPreference {

    private static String sSaveFileName = null;

    public static boolean isSSaveFile() {
        return sSaveFileName == null;
    }

    public static String getsSaveFile() {
        return sSaveFileName;
    }

    public static void setsSaveFile(String asSaveFile) {
        sSaveFileName = asSaveFile;
    }

}
