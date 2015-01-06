package fr.damienchesneau.ugame.client;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class UserPreference {

    private static String sSaveFileName = null;
    private static String replayFileName = null;

    private static boolean aleatoire = false;
    private static String fileAleatoire = "file_aleatoire.sv";

    public static boolean isSSaveFile() {
        return sSaveFileName == null;
    }

    public static boolean isReplayFile() {
        return getReplayFileName() == null;
    }

    public static String getsSaveFile() {
        return sSaveFileName;
    }

    public static void setsSaveFile(String asSaveFile) {
        sSaveFileName = asSaveFile;
    }

    public static String getReplayFileName() {
        return replayFileName;
    }

    public static void setReplayFileName(String aReplayFileName) {
        replayFileName = aReplayFileName;
    }

    public static boolean isAleatoire() {
        return aleatoire;
    }

    public static void setAleatoire(boolean aAleatoire) {
        aleatoire = aAleatoire;
    }

    public static String getFileAleatoire() {
        return fileAleatoire;
    }

    public static void setFileAleatoire(String aFileAleatoire) {
        fileAleatoire = aFileAleatoire;
    }
}
