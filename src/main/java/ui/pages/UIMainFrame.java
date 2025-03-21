package ui.pages;

import javax.swing.*;
import java.awt.*;

public class UIMainFrame {
    public static void mainFrame(){
        JFrame frame = new JFrame();
        UIMainMenu mainMenu = new UIMainMenu();

        frame.setTitle("CV Analyser | Main Menu");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Favicon.png");
        frame.setIconImage(favicon);
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        frame.add(mainMenu.mainMenuPanel());

        frame.setVisible(true);
    }
}
