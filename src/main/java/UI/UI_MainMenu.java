package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class UI_MainMenu {
    public static void MainMenu_Frame(){

        Font robotoFontTitle = null;
        Font robotoFontButtons = null;

        try{
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Nunito-Regular.ttf"));
            Font robotoFont = Font.createFont(Font.TRUETYPE_FONT, myStream);

            robotoFontTitle = robotoFont.deriveFont(Font.PLAIN, 30);
            robotoFontButtons = robotoFont.deriveFont(Font.PLAIN, 15);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Declaring instances of tools
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel pageTitle = new JLabel();
        JButton addCVButton = new JButton();
        JButton cvRankedListButton = new JButton();
        JButton quitButton = new JButton();

        // Defining attributes to frame
        frame.setTitle("CV Analyser | Main Menu");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Defining attributes to mainPanel
        mainPanel.setBackground(new Color(30,30,30));
        mainPanel.setOpaque(true);

        // Defining attributes to buttonPanel
        buttonPanel.setBackground(new Color(55,55,55));
        buttonPanel.setOpaque(true);
        buttonPanel.setBorder(new EmptyBorder(30,30,30,30));

        // Defining attributes to pageTitle
        pageTitle.setVisible(true);
        pageTitle.setText("Main Menu");
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageTitle.setFont(robotoFontTitle);
        pageTitle.setForeground(new Color(255,255,255,255));

        // Defining attributes to addCVButton
        addCVButton.setText("Add a CV");
        addCVButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCVButton.setFont(robotoFontButtons);

        // Defining attributes to cvRankedList
        cvRankedListButton.setText("Display Ranked List");
        cvRankedListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cvRankedListButton.setFont(robotoFontButtons);

        // Defining attributes to quitButton
        quitButton.setText("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setFont(robotoFontButtons);

        // Adding buttons to button container
//        buttonPanel.add(Box.createHorizontalStrut(300));
//        buttonPanel.add(Box.createVerticalStrut(60));
        buttonPanel.add(pageTitle);
        buttonPanel.add(Box.createVerticalStrut(40));
        buttonPanel.add(addCVButton);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(cvRankedListButton);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(quitButton);
//        buttonPanel.add(Box.createVerticalStrut(60));
//        buttonPanel.add(Box.createHorizontalStrut(300));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));


        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
    }
}
