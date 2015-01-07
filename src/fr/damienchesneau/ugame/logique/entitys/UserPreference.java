package fr.damienchesneau.ugame.logique.entitys;

/**
 * Les préférences utilisateurs serons envoyé ici.
 * @author Damien Chesneau <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public class UserPreference {

    private static String sSaveFileName = null;
    private static String replayFileName = null;

    private static boolean aleatoire = false;
    private static String fileAleatoire = "file_aleatoire.sv";

    private static long preferendSeedValue = 0;

    public static void setPreferendSeedValue(long preferendSeedValue) {
        UserPreference.preferendSeedValue = preferendSeedValue;
    }

    public static long getPreferendSeedValue() {
        return preferendSeedValue;
    }

    
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
