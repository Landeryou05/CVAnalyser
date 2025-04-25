package frontend;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * FrontQuit handles the process of closing the application.
 * */
public class FrontQuit {
    /**
     * quitConfirm takes mainMenuPanel and then shows a dialog to confirm quit.
     * @param parentFrame takes parentFrame and adds dialog.
     * */
    public static void quitConfirm(JFrame parentFrame){
        /*
         * CREATING COMPONENT OBJECTS
         * */
        JDialog quitConfirmFrame = new JDialog(parentFrame, true); // takes mainMenuPanel as an argument.
        JPanel quitConfirmPanel = new JPanel();
        JLabel cautionLabel = new JLabel();
        // Overriding paintComponent to custom render components such as JButton and JPanel.
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
        JButton cancelButton = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);
                super.paintComponent(g);
            }
        };
        JPanel buttons = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 40,40);
                super.paintComponent(g);
            }
        };



        /*
         * DEFINING COMPONENT ATTRIBUTES
         * */
        // Defining attributes for quitConfirmFrame
        quitConfirmFrame.setSize(300,240);
        quitConfirmFrame.setLocationRelativeTo(null);
        quitConfirmFrame.setTitle("Are you sure?");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg");
        quitConfirmFrame.setIconImage(favicon);
        quitConfirmFrame.setResizable(false);
        // Defining attributes for quitConfirmPanel
        quitConfirmPanel.setBackground(new Color(30,30,30));
        quitConfirmPanel.setBorder(new EmptyBorder(30,30,30,30));
        // Defining attributes for cautionLabel
        cautionLabel.setText("Added CVs will be lost!");
        cautionLabel.setForeground(new Color(255,255,255));
        cautionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cautionLabel.setFont(new FrontFont().fontElements());
        // Defining attributes for quitButton
        quitButton.setText("Quit");
        quitButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        quitButton.setForeground(new Color(255, 255, 255));
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setFont(new FrontFont().fontElements());
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.setBackground(new Color(55,55,55));
        quitButton.addActionListener(e -> {
            quitProgram();
        });
        // Defining attributes for cancelButton
        cancelButton.setText("Cancel");
        cancelButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        cancelButton.setForeground(new Color(255, 255, 255));
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelButton.setFont(new FrontFont().fontElements());
        cancelButton.setContentAreaFilled(false);
        cancelButton.setFocusPainted(false);
        cancelButton.setBackground(new Color(55,55,55));
        cancelButton.addActionListener(e -> {
            quitConfirmFrame.dispose();
        });
        // Defining attributes for buttons
        buttons.setOpaque(false);
        buttons.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));
        buttons.add(quitButton);
        buttons.add(Box.createHorizontalStrut(15));
        buttons.add(cancelButton);



        /*
        * ADDING COMPONENTS
        * */
        // Adding components to quitConfirmPanel.
        quitConfirmPanel.add(cautionLabel);
        quitConfirmPanel.add(Box.createVerticalStrut(30));
        quitConfirmPanel.add(buttons);
        quitConfirmPanel.setLayout(new BoxLayout(quitConfirmPanel, BoxLayout.Y_AXIS));
        // Adding components to quitConfirmFrame
        quitConfirmFrame.add(quitConfirmPanel);
        quitConfirmFrame.setVisible(true);
    }

    /**
     * quitProgram stops the running thread.
     * */
    public static void quitProgram(){
        System.exit(0);
    }
}
