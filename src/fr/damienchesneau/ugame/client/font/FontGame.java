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
 * Permet de récuper des polices spécifiques.
 *
 * @author Damien Chesneau
 * <a href="mailto:contact@damienchesneau.fr">contact@damienchesneau.fr</a>
 */
public class FontGame {

    public enum FontGameAvalable {

        CLEAR_SANS_BOLD, CLEAR_SANS_BOLD_ITALIC, CLEAR_SANS_ITALIC, CLEAR_SANS_LIGHT, CLEAR_SANS_MEDIUM, CLEAR_SANS_MEDIUM_ITALIC, CLEAR_SANS_REGULAR, CLEAR_SANS_THIN
    }

    private File getFile(FontGameAvalable fga) throws URISyntaxException {
        String name = null;
        switch (fga) {
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
        return new File(resource.toURI());
    }

    /**
     *
     * @param fga polide disponible
     * @return String name of font
     * @throws java.awt.FontFormatException
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public String getFont(FontGameAvalable fga) throws FontFormatException, IOException, URISyntaxException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, getFile(fga)));
        Font font = Font.createFont(Font.TRUETYPE_FONT, getFile(fga));
        return font.getFontName();
    }
}
