package frontend;

import backend.BackCV;
import frontend.pages.FrontRankedList;
import frontend.pages.FrontAddCVFile;
import frontend.pages.FrontMainMenu;

import javax.swing.*;
import java.awt.*;

public class FrontMainFrame {
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    public static JFrame mainFrame(){
        BackCV preloadNLP = new BackCV();
        preloadNLP.nlpInitialLoad();

        JFrame frame = new JFrame();

        frame.setTitle("CV Analyser | Main Menu");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg");
        frame.setIconImage(favicon);
        frame.setSize(450, 550);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(FrontMainMenu.mainMenuPanel(cardPanel, cardLayout), "MainMenu");
        cardPanel.add(FrontAddCVFile.addCVFile(cardPanel, cardLayout), "AddCVFile");
        cardPanel.add(FrontRankedList.rankedList(cardPanel, cardLayout), "RankedList");

        frame.add(cardPanel);
        frame.setVisible(true);

        return frame;
    }
}
