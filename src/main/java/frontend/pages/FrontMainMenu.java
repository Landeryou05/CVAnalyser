package frontend.pages;

import frontend.FrontFont;
import frontend.FrontQuit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * FrontMainMenu handles the rendering of the Main Menu panel that is added to the FrontMainFrame cardLayout.
 * */
public class FrontMainMenu {
    private static JFrame mainFrame; // Static JFrame as parent frame for quitConfirm method param.





    /**
     * mainMenuPanel handles logic for rendering the main menu.
     * @param cardLayout This stores the data rendered as a cardLayout.
     * @param cardPanel This is the panel where cardLayout is added.
     * @return mainPanel This is the panel which all components are added to.
     * */
    public static JPanel mainMenuPanel(JPanel cardPanel, CardLayout cardLayout){
        /*
         * CREATING COMPONENT OBJECTS
         * */
        JPanel mainPanel = new JPanel();
        // Overriding default painComponents for custom rendering of vectors.
        JPanel elementsPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 40,40);
            }
        };
        JLabel pageTitle = new JLabel();
        JButton addCVButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);
                super.paintComponent(g);
            }
        };
        JButton cvRankedListButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);
                super.paintComponent(g);
            }
        };
        JButton quitButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);
                super.paintComponent(g);
            }
        };
        FrontFont font = new FrontFont();





        /*
         * DEFINING COMPONENT ATTRIBUTES
         * */
        // Defining attributes to mainPanel
        mainPanel.setBackground(new Color(30,30,30));
        mainPanel.setOpaque(true);
        mainPanel.setVisible(true);
        mainPanel.setLayout(new GridBagLayout());

        // Defining attributes to elementsPanel
        elementsPanel.setOpaque(false);
        elementsPanel.setBorder(new EmptyBorder(30,30,30,30));
        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));

        // Defining attributes to pageTitle
        pageTitle.setText("Main Menu");
        pageTitle.setVisible(true);
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageTitle.setFont(font.fontTitle());
        pageTitle.setForeground(new Color(255,255,255));

        // Defining attributes to addCVButton
        addCVButton.setText("Add a CV");
        addCVButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        addCVButton.setForeground(new Color(255, 255, 255));
        addCVButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCVButton.setFont(font.fontElements());
        addCVButton.setContentAreaFilled(false);
        addCVButton.setFocusPainted(false);

        addCVButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "AddCVFile");
        });

        // Defining attributes to cvRankedList
        cvRankedListButton.setText("Display Ranked List");
        cvRankedListButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        cvRankedListButton.setForeground(new Color(255, 255, 255));
        cvRankedListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cvRankedListButton.setFont(font.fontElements());
        cvRankedListButton.setContentAreaFilled(false);
        cvRankedListButton.setFocusPainted(false);

        cvRankedListButton.addActionListener(e -> { // Handles event for when Ranked List Button is clicked.
            cardLayout.show(cardPanel, "RankedList");
        });

        // Defining attributes to quitButton
        quitButton.setText("Quit");
        quitButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        quitButton.setForeground(new Color(255, 255, 255));
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setFont(font.fontElements());
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);

        quitButton.addActionListener(e -> { // Handles event for quit button.
            FrontQuit.quitConfirm(mainFrame);
        });





        /*
         * ADDING COMPONENTS
         * */
        // Adding components to elementsPanel
        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(40));
        elementsPanel.add(addCVButton);
        elementsPanel.add(Box.createVerticalStrut(30));
        elementsPanel.add(cvRankedListButton);
        elementsPanel.add(Box.createVerticalStrut(30));
        elementsPanel.add(quitButton);

        // Adding elements to mainPanel
        mainPanel.add(elementsPanel);

        return mainPanel;
    }
}
