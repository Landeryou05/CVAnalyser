package frontend.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FontRankedList {
    public static JPanel rankedList(){

        // Importing the font
        Font fontTitle = null;
        Font fontElements = null;

        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("Resources/Montserrat-Light.ttf"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, myStream);
            fontTitle = font.deriveFont(Font.PLAIN, 30);
            fontElements = font.deriveFont(Font.PLAIN, 15);
        } catch (Exception e) {
            fontTitle = (new Font("Roboto", Font.PLAIN, 30));
            fontElements = (new Font("Roboto", Font.PLAIN, 15));
        }

        // Creating instances of components
        JPanel rankedList = new JPanel();
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

        // Defining attributes for addCVPanel
        rankedList.setBackground(new Color(30,30,30));
        rankedList.setOpaque(true);

        // Defining attributes for elementsPanel
        elementsPanel.setOpaque(false);
        elementsPanel.setBorder(new EmptyBorder(30,30,30,30));
        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));
        elementsPanel.setBackground(new Color(55,55,55));

        // Defining attributes for pageTitle
        pageTitle.setText("CV Ranked List");
        pageTitle.setVisible(true);
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageTitle.setForeground(new Color(255,255,255));
        pageTitle.setFont(fontTitle);

        String[] columns = {"Code", "Name", "High", "Low", "Close", "Volume", "Change","Change %"};

        Object[][] data = {
                {"Code", "Name", "High", "Low", "Close", "Volume", "Change","Change %"},
                {"MBF", "CITYGROUP", 10.16, 10.16, 10.16, 200, 0.08,0.79},
                {"MBL", "BANK OF AMERICA", 12.66, 12.66, 12.66, 6600, 0.13,1.04},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16},
                {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16}
        };

        JTable rankedListTable = new JTable(data, columns);
        new JScrollPane(rankedListTable);

        rankedListTable.setPreferredSize(new Dimension(300, 95));
        rankedListTable.setDefaultEditor(Object.class, null);

        rankedListTable.setBackground(new Color(51,51,51));
        rankedListTable.setForeground(new Color(255,255,255));

        // Defining attributes for backButton
        backButton.setText("Previous");
        backButton.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setFont(fontElements);
        backButton.addActionListener(e -> {
            rankedList.removeAll();
            rankedList.add(FrontMainMenu.mainMenuPanel());
            rankedList.revalidate();
            rankedList.repaint();

        });


        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(35));
        elementsPanel.add(rankedListTable);
        elementsPanel.add(Box.createVerticalStrut(25));
        //elementsPanel.add(openFileExplorer);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);
        rankedList.add(elementsPanel);

        return rankedList;
    }
}
