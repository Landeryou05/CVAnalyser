package frontend.pages;

import frontend.FrontFont;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * FrontAddCVFile handles rendering for the AddCVFile page.
 * */
public class FrontJobDescription {
    /**
     * addCVFile handles logic for rendering the addCVFile page.
     * @param cardLayout This stores the data rendered as a cardLayout.
     * @param cardPanel This is the panel where cardLayout is added.
     * @return addCVPanel This is the panel which all components are added to.
     * */
    public static JPanel jobDescription(JPanel cardPanel, CardLayout cardLayout){
        /*
         * CREATING COMPONENT OBJECTS
         * */
        JPanel addCVPanel = new JPanel();
        addCVPanel.setBounds(150,150,150,150);
        JPanel selectedFilePanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);
            }
        };
        FrontFont font = new FrontFont();
        JLabel pageTitle = new JLabel();
        JPanel elementsPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 40,40);
            }
        };
        JButton submitButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);

                super.paintComponent(g);
            }
        };
        JButton backButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);

                super.paintComponent(g);
            }
        };

        /*
         * DEFINING COMPONENT ATTRIBUTES
         * */
        // Defining attributes for addCVPanel
        addCVPanel.setBackground(new Color(30,30,30));
        addCVPanel.setOpaque(true);
        addCVPanel.setLayout(new GridBagLayout());

        // Defining attributes for elementsPanel
        elementsPanel.setOpaque(false);
        elementsPanel.setBorder(new EmptyBorder(30,30,30,30));
        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));

        // Defining selectedFilePanel
        selectedFilePanel.setVisible(true);
        selectedFilePanel.setBackground(new Color(55,55,55));

        // Defining attributes for pageTitle
        pageTitle.setText("Job Description");
        pageTitle.setVisible(true);
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageTitle.setForeground(new Color(255,255,255));
        pageTitle.setFont(font.fontTitle());

        // Defining attributes for submitButton

        JTextArea textArea = new JTextArea(8, 30);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textAreaScrollPane.setPreferredSize(new Dimension(300, 150)); 

        // Defining attributes for submitButton
        submitButton.setText("Submit Job Description");
        submitButton.setBorder(BorderFactory.createEmptyBorder(15, 15,15,15));
        submitButton.setForeground(new Color(255, 255, 255));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setContentAreaFilled(false);
        submitButton.setFocusPainted(false);
        submitButton.setFont(font.fontElements());
        submitButton.addActionListener(e -> {
            textArea.setText(null);


        });

        // Defining attributes for backButton
        backButton.setText("Previous");
        backButton.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setFont(font.fontElements());
        backButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "MainMenu");
        });



        /*
         * ADDING COMPONENTS
         * */

        // Adding components to elementsPanel
        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(35));
        elementsPanel.add(textAreaScrollPane);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(submitButton);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);

        // Adding components to addCVPanel
        addCVPanel.add(elementsPanel);

        return addCVPanel;
    }
}
