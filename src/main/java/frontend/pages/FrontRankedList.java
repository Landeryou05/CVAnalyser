package frontend.pages;

import backend.BackRankedList;
import frontend.FrontFont;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

/**
 * FrontRankedList renders the Ranked List page, where users can refresh and view the ranked list of CVs.
 * */
public class FrontRankedList {
    private static ArrayList<Object[]> rankedListArray = new ArrayList<>();

    public ArrayList<Object[]> getRankedListArray(){
        return rankedListArray;
    }

    /**
     * setRankedListArray takes in each attribute of candidate and adds an object to a pre-defined array list.
     * @param candidateScore Score returned based on candidate's CV strength - uses BackCV to achieve this.
     * @param candidateName Name returned - uses BackCV to extract this.
     * @param candidateSkills Skills returned - uses BackCV to extract this.
     * @param candidateOrganisations Organisations mentioned within CV - uses BackCV to extract this.
     * @param candidateFile File that has been examined - uses FrontAddCVFile to extract path to file.
     * */
    public void setRankedListArray(String candidateScore, String candidateName, String candidateSkills, String candidateOrganisations, String candidateFile){
        rankedListArray.add(new Object[]{candidateScore, candidateName, candidateSkills, candidateOrganisations, candidateFile});
    }



    /**
     * rankedList is the method that renders the rankedList page.
     * @param cardLayout This stores the data rendered as a cardLayout.
     * @param cardPanel This is the panel where cardLayout is added.
     * @return rankedListPanel This is the panel which all components are added to.
     * */
    public static JPanel rankedList(JPanel cardPanel, CardLayout cardLayout){
        /*
         * CREATING COMPONENT OBJECTS
         * */
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



        /*
         * DEFINING COMPONENT ATTRIBUTES
         * */
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
        // Defining attributes for table.
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("Score"); // Add headings to the table.
        table.addColumn("Name");
        table.addColumn("Skills");
        table.addColumn("Organisation");
        table.addColumn("File");
        // Defining attributes for rankedListTable
        JTable rankedListTable = new JTable(table);
        rankedListTable.setFont(font.fontElements());
        rankedListTable.setPreferredScrollableViewportSize(new Dimension(350,150));
        rankedListTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        rankedListTable.getColumnModel().getColumn(0).setPreferredWidth(75); // Setting the prefered width for the headings.
        rankedListTable.getColumnModel().getColumn(1).setPreferredWidth(150); // User can also manually change the width.
        rankedListTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        rankedListTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        rankedListTable.getColumnModel().getColumn(4).setPreferredWidth(400);
        rankedListTable.setDefaultEditor(Object.class, null); // Stops the user from being able to change data within a cell.
        rankedListTable.setBackground(new Color(51,51,51));
        rankedListTable.setForeground(new Color(255,255,255));
        // Defining attributes for rankedListTableHeader
        JTableHeader rankedListTableHeader = rankedListTable.getTableHeader();
        rankedListTableHeader.setFont(font.fontElements());
        rankedListTableHeader.setReorderingAllowed(false); // Stops user from being able to change order of columns.
        // Defining attributes for rankedListTable
        JScrollPane rankedListTableScrollPane = new JScrollPane(rankedListTable);
        // Defining attributes for rankedListTableScrollPane
        rankedListTableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Allows for horizontal scrolling if table size is bigger than the viewport.
        // Defining attributes for refreshList
        refreshList.setText("Refresh List");
        refreshList.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        refreshList.setForeground(new Color(255, 255, 255));
        refreshList.setAlignmentX(Component.CENTER_ALIGNMENT);
        refreshList.setContentAreaFilled(false);
        refreshList.setFocusPainted(false);
        refreshList.setFont(font.fontElements());
        /*
        * Handles the event of refreshing the ranked list.
        * It resets the row count.
        * creates an instance of BackRankedList and then ranks the candidates based on score.
        * for every candidate in rankedListArray, it then adds a row where candidate is located.
        * */
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
        backButton.addActionListener(e -> { // Switches to main menu when the back button is clicked.
            cardLayout.show(cardPanel, "MainMenu");
        });



        /*
         * ADDING COMPONENTS
         * */
        // Adding components to elementsPanel.
        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(35));
        elementsPanel.add(rankedListTableScrollPane);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(refreshList);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);
        // Adding components to rankedListPanel.
        rankedListPanel.add(elementsPanel);

        return rankedListPanel;
    }
}
