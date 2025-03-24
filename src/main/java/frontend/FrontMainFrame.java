package frontend;

import frontend.pages.FrontMainMenu;

import javax.swing.*;
import java.awt.*;

public class FrontMainFrame {
    public static void mainFrame(){
        JFrame frame = new JFrame();
        FrontMainMenu mainMenu = new FrontMainMenu();

        frame.setTitle("CV Analyser | Main Menu");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg");
        frame.setIconImage(favicon);
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        frame.add(mainMenu.mainMenuPanel());

        frame.setVisible(true);
    }
}
