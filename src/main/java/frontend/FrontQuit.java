package frontend;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FrontQuit {
    public static void quitConfirm(JFrame parentFrame){
        JDialog quitConfirmFrame = new JDialog(parentFrame, true);
        JPanel quitConfirmPanel = new JPanel();
        JLabel cautionLabel = new JLabel();
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

        // Defining attributes for quitConfirmFrame
        quitConfirmFrame.setSize(300,240);
        quitConfirmFrame.setLocationRelativeTo(null);
        quitConfirmFrame.setTitle("Are you sure?");
        Image favicon = Toolkit.getDefaultToolkit().getImage("Resources/Logo.jpg");
        quitConfirmFrame.setIconImage(favicon);
        quitConfirmFrame.setResizable(false);

        quitConfirmPanel.setBackground(new Color(30,30,30));
        quitConfirmPanel.setBorder(new EmptyBorder(30,30,30,30));

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

        buttons.setOpaque(false);
        buttons.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));
        buttons.add(quitButton);
        buttons.add(Box.createHorizontalStrut(15));
        buttons.add(cancelButton);

        quitConfirmPanel.add(cautionLabel);
        quitConfirmPanel.add(Box.createVerticalStrut(30));
        quitConfirmPanel.add(buttons);
        quitConfirmPanel.setLayout(new BoxLayout(quitConfirmPanel, BoxLayout.Y_AXIS));

        quitConfirmFrame.add(quitConfirmPanel);
        quitConfirmFrame.setVisible(true);
    }

    public static void quitProgram(){
        System.exit(0);
    }
}
