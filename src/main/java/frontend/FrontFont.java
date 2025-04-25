package frontend;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * FrontFont loads the font from Google Fonts and then returns fonts based on whether font is needed for elements or titles
 * */
public class FrontFont {
    /**
     * fontTitle handles the font for title components.
     * @return fontTitle
     * */
    public Font fontTitle(){
        Font fontTitle = null; // Declaring fontTitle

        try { // Try except block for handling error loading font - it reverts to Roboto.
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Montserrat-Light.ttf")); // Font is located within 'Resources' folder.
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fontTitle = font.deriveFont(Font.PLAIN, 35);
            return fontTitle;
        } catch (Exception e) {
            fontTitle = (new Font("Roboto", Font.PLAIN, 35));
            return fontTitle;
        }
    }





    /**
     * fontElements handles the font for element components.
     * @return fontElements
     * */
    public Font fontElements(){
        Font fontElements = null;

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Montserrat-Light.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fontElements = font.deriveFont(Font.PLAIN, 17);
            return fontElements;
        } catch (Exception e) {
            fontElements = (new Font("Roboto", Font.PLAIN, 17));
            return fontElements;
        }
    }
}
