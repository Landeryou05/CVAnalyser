package frontend;

import frontend.pages.FrontMainMenu;

import javax.swing.*;
import java.awt.*;

public class FrontMainFrame {
    public static JFrame mainFrame(){
        JFrame frame = new JFrame();

        frame.setTitle("CV Analyser | Main Menu");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg");
        frame.setIconImage(favicon);
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(FrontMainMenu.mainMenuPanel());

        frame.setVisible(true);

        return frame;
    }
}
