package frontend.pages;

import backend.BackCV;
import backend.BackCandidate;
import frontend.FrontFont;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class FrontRankedList {
    private ArrayList<BackCandidate> rankedListArray = new ArrayList<>();

    private String candidateScore;
    private String candidateName;
    private String candidateSkills;
    private String candidateOrganisations;

    public String getCandidateScore(){
        return candidateScore;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public String getCandidateSkills(){
        return candidateSkills;
    }

    public String getCandidateOrganisations(){
        return candidateOrganisations;
    }

    public void setCandidateScore(String setCandidateScore){
        candidateScore = setCandidateScore;
    }

    public void setCandidateName(String setCandidateName){
        candidateName = setCandidateName;
    }

    public void setCandidateSkills(String setCandidateSkills){
        candidateSkills = setCandidateSkills;
    }

    public void setCandidateOrganisations(String setCandidateOrganisations){
        candidateOrganisations = setCandidateOrganisations;
    }

    public ArrayList<BackCandidate> getRankedListArray(){
        return rankedListArray;
    }

    public void setRankedListArray(ArrayList<BackCandidate> setRankedListArray){
        rankedListArray = setRankedListArray;
    }

//    public void candidateInfo(String candidateScore, String candidateName, String candidateSkills, String candidateOrganisations){
////        setCandidateScore(candidateScore);
////        setCandidateName(candidateName);
////        setCandidateSkills(candidateSkills);
////        setCandidateOrganisations(candidateOrganisations);
//    }

    public static JPanel rankedList(JPanel cardPanel, CardLayout cardLayout){
        // Creating instances of components
        FrontRankedList rankedListInstance = new FrontRankedList();
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
        JButton clearList = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);

                super.paintComponent(g);
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

//        String[] columns = {"Rank", "Name", "Organisations", "keywords", "CV"};
//
//
//
//        ArrayList<String> candidateObjects = new ArrayList<>();
//
//        Object[][] data = {candidateObjects.toString()};
//
//        for (BackCandidate candidate : frontRankedList.getRankedListArray()){
//            candidateObjects.add(frontRankedList.candidateName);
//            candidateObjects.add(frontRankedList.candidateSkills);
//            candidateObjects.add(frontRankedList.candidateOrganisations);
//        }

        DefaultTableModel table = new DefaultTableModel();

        table.addColumn("Rank");
        table.addColumn("Name");
        table.addColumn("Organisations");
        table.addColumn("Keywords");
        table.addColumn("CV");

        table.addRow(new Object[]{"321", 'f', "fsdfsd", "ggg", 'f'});

        // Defining attributes for rankedListTable
        JTable rankedListTable = new JTable(table);
        rankedListTable.setFont(font.fontElements());
        rankedListTable.setPreferredScrollableViewportSize(new Dimension(320,100));
        rankedListTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

        // Defining attributes for clearList
        clearList.setText("Clear List");
        clearList.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        clearList.setForeground(new Color(255, 255, 255));
        clearList.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearList.setContentAreaFilled(false);
        clearList.setFocusPainted(false);
        clearList.setFont(font.fontElements());
        clearList.addActionListener(e -> {
            // ADD DELETE OBJECTS HERE
        });

        // Defining attributes for refreshList
        refreshList.setText("Refresh List");
        refreshList.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        refreshList.setForeground(new Color(255, 255, 255));
        refreshList.setAlignmentX(Component.CENTER_ALIGNMENT);
        refreshList.setContentAreaFilled(false);
        refreshList.setFocusPainted(false);
        refreshList.setFont(font.fontElements());
        refreshList.addActionListener(e -> {
//            System.out.println(frontRankedListInstance.getCandidateScore());
//            System.out.println(frontRankedListInstance.getCandidateName());
//            System.out.println(frontRankedListInstance.getCandidateSkills());
//            System.out.println(frontRankedListInstance.getCandidateOrganisations());

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
        elementsPanel.add(clearList);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(refreshList);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);

        rankedListPanel.add(elementsPanel);

        return rankedListPanel;
    }
}
