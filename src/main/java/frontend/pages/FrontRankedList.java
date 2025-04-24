package frontend.pages;

import backend.BackRankedList;
import frontend.FrontFont;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FrontRankedList {
    private static ArrayList<Object[]> rankedListArray = new ArrayList<>();

    public ArrayList<Object[]> getRankedListArray(){
        return rankedListArray;
    }

    public void setRankedListArray(String candidateScore, String candidateName, String candidateSkills, String candidateOrganisations, String candidateFile){
        rankedListArray.add(new Object[]{candidateScore, candidateName, candidateSkills, candidateOrganisations, candidateFile});
    }

    public static JPanel rankedList(JPanel cardPanel, CardLayout cardLayout){
        // Creating instances of components
        JPanel rankedListPanel = new JPanel();
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
        JButton refreshList = new JButton(){
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
        FrontFont font = new FrontFont();

        // Defining attributes for addCVPanel
        rankedListPanel.setBackground(new Color(30,30,30));
        rankedListPanel.setOpaque(true);
        rankedListPanel.setLayout(new GridBagLayout());

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
        pageTitle.setFont(font.fontTitle());

        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("Score");
        table.addColumn("Name");
        table.addColumn("Skills");
        table.addColumn("Organisation");
        table.addColumn("File");


        // Defining attributes for rankedListTable
        JTable rankedListTable = new JTable(table);
        rankedListTable.setFont(font.fontElements());
        rankedListTable.setPreferredScrollableViewportSize(new Dimension(350,150));
        rankedListTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        rankedListTable.getColumnModel().getColumn(0).setPreferredWidth(75);
        rankedListTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        rankedListTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        rankedListTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        rankedListTable.getColumnModel().getColumn(4).setPreferredWidth(400);
        rankedListTable.setDefaultEditor(Object.class, null);
        rankedListTable.setBackground(new Color(51,51,51));
        rankedListTable.setForeground(new Color(255,255,255));

        // Defining attributes for rankedListTableHeader
        JTableHeader rankedListTableHeader = rankedListTable.getTableHeader();
        rankedListTableHeader.setFont(font.fontElements());
        rankedListTableHeader.setReorderingAllowed(false);

        // Defining attributes for rankedListTable
        JScrollPane rankedListTableScrollPane = new JScrollPane(rankedListTable);

        // Defining attributes for rankedListTableScrollPane
        rankedListTableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Defining attributes for refreshList
        refreshList.setText("Refresh List");
        refreshList.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        refreshList.setForeground(new Color(255, 255, 255));
        refreshList.setAlignmentX(Component.CENTER_ALIGNMENT);
        refreshList.setContentAreaFilled(false);
        refreshList.setFocusPainted(false);
        refreshList.setFont(font.fontElements());
        refreshList.addActionListener(e -> {
            table.setRowCount(0);
            BackRankedList rankedListInstance = new BackRankedList();

            rankedListInstance.rankedList(rankedListArray);

            for (Object[] rowData : rankedListArray){
                table.addRow(rowData);
            }
        });

        // Defining attributes for backButton
        backButton.setText("Previous");
        backButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setFont(font.fontElements());
        backButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "MainMenu");
        });

        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(35));
        elementsPanel.add(rankedListTableScrollPane);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(refreshList);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);

        rankedListPanel.add(elementsPanel);

        return rankedListPanel;
    }
}
