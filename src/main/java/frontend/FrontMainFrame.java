package frontend;

import backend.BackCV;
import frontend.pages.FrontRankedList;
import frontend.pages.FrontAddCVFile;
import frontend.pages.FrontMainMenu;

import javax.swing.*;
import java.awt.*;

/**
 * FrontMainFrame creates the window for the application, which is then called within the Main class.
 * */
public class FrontMainFrame {
    // Static objects that are used for page switching functionality.
    private static CardLayout cardLayout;
    private static JPanel cardPanel;





    /**
     * mainFrame returns the rendered window.
     * It also adds all 3 pages to the card panel for switching pages.
     * @return frame rendered frame
     * */
    public static JFrame mainFrame(){
        /*
         * CREATING COMPONENT OBJECTS
         * */
        JFrame frame = new JFrame();

        BackCV preloadNLP = new BackCV(); // Creating BackCV object.
        preloadNLP.nlpInitialLoad(); // Start multithreading process to preload NLP.

        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg"); // Creating image component to load favicon.





        /*
         * DEFINING COMPONENT ATTRIBUTES
         * */
        // Defining attributes for frame.
        frame.setTitle("CV Analyser | Main Menu");
        frame.setIconImage(favicon);
        frame.setSize(450, 550);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);





        /*
         * IMPLEMENTING CARDLAYOUT
         * */
        // Creating CardLayout object
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Adding components to cardPanel
        cardPanel.add(FrontMainMenu.mainMenuPanel(cardPanel, cardLayout), "MainMenu");
        cardPanel.add(FrontAddCVFile.addCVFile(cardPanel, cardLayout), "AddCVFile");
        cardPanel.add(FrontRankedList.rankedList(cardPanel, cardLayout), "RankedList");





        /*
         * ADDING COMPONENTS
         * */
        // Adding cardPanel component to frame.
        frame.add(cardPanel);
        frame.setVisible(true);

        return frame;
    }
}
