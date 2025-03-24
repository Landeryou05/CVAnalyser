package frontend;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FrontFont {
    public Font fontTitle(){
        Font fontTitle = null;

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Montserrat-Light.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fontTitle = font.deriveFont(Font.PLAIN, 30);
            return fontTitle;
        } catch (Exception e) {
            fontTitle = (new Font("Roboto", Font.PLAIN, 30));
            return fontTitle;
        }
    }

    public Font fontElements(){
        Font fontElements = null;

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Montserrat-Light.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fontElements = font.deriveFont(Font.PLAIN, 15);
            return fontElements;
        } catch (Exception e) {
            fontElements = (new Font("Roboto", Font.PLAIN, 30));
            return fontElements;
        }
    }
}
