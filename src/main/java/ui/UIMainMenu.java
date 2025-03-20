package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class UIMainMenu {
    public static void MainMenu_Frame(){
        Font fontTitle = null;
        Font fontButtons = null;

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Montserrat-Light.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fontTitle = font.deriveFont(Font.PLAIN, 30);
            fontButtons = font.deriveFont(Font.PLAIN, 15);
        } catch (Exception e) {
            fontTitle = (new Font("Roboto", Font.PLAIN, 30));
            fontButtons = (new Font("Roboto", Font.PLAIN, 15));
        }

        // Declaring instances of tools
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel(){
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

        // Defining attributes to frame
        frame.setTitle("CV Analyser | Main Menu");
        frame.setSize(350, 450);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Defining attributes to mainPanel
        mainPanel.setBackground(new Color(30,30,30));
        mainPanel.setOpaque(true);

        // Defining attributes to buttonPanel
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(new EmptyBorder(30,30,30,30));

        // Defining attributes to pageTitle
        pageTitle.setText("Main Menu");
        pageTitle.setVisible(true);
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageTitle.setFont(fontTitle);
        pageTitle.setForeground(new Color(255,255,255));

        // Defining attributes to addCVButton
        addCVButton.setText("Add a CV");
        addCVButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        addCVButton.setForeground(new Color(255, 255, 255));
        addCVButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCVButton.setFont(fontButtons);
        addCVButton.setContentAreaFilled(false);
        addCVButton.setFocusPainted(false);

        // Defining attributes to cvRankedList
        cvRankedListButton.setText("Display Ranked List");
        cvRankedListButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        cvRankedListButton.setForeground(new Color(255, 255, 255));
        cvRankedListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cvRankedListButton.setFont(fontButtons);
        cvRankedListButton.setContentAreaFilled(false);
        cvRankedListButton.setFocusPainted(false);

        // Defining attributes to quitButton
        quitButton.setText("Quit");
        quitButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        quitButton.setForeground(new Color(255, 255, 255));
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setFont(fontButtons);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);

        // Adding buttons to button container
        buttonPanel.add(pageTitle);
        buttonPanel.add(Box.createVerticalStrut(45));
        buttonPanel.add(addCVButton);
        buttonPanel.add(Box.createVerticalStrut(35));
        buttonPanel.add(cvRankedListButton);
        buttonPanel.add(Box.createVerticalStrut(35));
        buttonPanel.add(quitButton);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
    }
}
