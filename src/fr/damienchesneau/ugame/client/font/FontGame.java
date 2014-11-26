package fr.damienchesneau.ugame.client.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class FontGame {

    public enum FontGameAvalable {
        CLEAR_SANS_BOLD,CLEAR_SANS_BOLD_ITALIC,CLEAR_SANS_ITALIC,CLEAR_SANS_LIGHT,CLEAR_SANS_MEDIUM,CLEAR_SANS_MEDIUM_ITALIC,CLEAR_SANS_REGULAR,CLEAR_SANS_THIN
    }

    private File getFile(FontGameAvalable fga) {
        String name=null;
        switch(fga){
            case CLEAR_SANS_BOLD:
                name = "ClearSans-Bold.ttf";
                break;
            case CLEAR_SANS_BOLD_ITALIC:
                name = "ClearSans-BoldItalic.ttf";
                break;
            case CLEAR_SANS_ITALIC:
                name = "ClearSans-Italic.ttf";
                break;
            case CLEAR_SANS_LIGHT:
                name = "ClearSans-Light.ttf";
                break;
            case CLEAR_SANS_MEDIUM:
                name = "ClearSans-Medium.ttf";
                break;
            case CLEAR_SANS_MEDIUM_ITALIC:
                name = "ClearSans-MediumItalic.ttf";
                break;
            case CLEAR_SANS_REGULAR:
                name = "ClearSans-Regular.ttf";
                break;
            case CLEAR_SANS_THIN:
                name = "ClearSans-Thin.ttf";
                break;
            default:
                System.err.println("Houston, we have a problem.");
                break;
        }
        URL resource = getClass().getResource(name);
        try {
            return new File(resource.toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(FontGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * 
     * @param fga
     * @return String name of font
     */
    public String getFont(FontGameAvalable fga) {
        Font font = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getFile(fga)));
        } catch (FontFormatException ex) {
            Logger.getLogger(FontGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FontGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getFile(fga));
        } catch (FontFormatException ex) {
            Logger.getLogger(FontGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FontGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font.getFontName();

    }
}
