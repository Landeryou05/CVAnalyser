package frontend.pages;

import backend.BackCV;
import backend.BackCandidate;
import frontend.FrontFont;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * FrontAddCVFile handles rendering for the AddCVFile page.
 * */
public class FrontAddCVFile {
    /*
     * Declaring instance variables.
     * */
    private ArrayList<BackCandidate> candidateList = new ArrayList<>(); // Array list to store candidate objects.
    private File chosenFile = null;





    public ArrayList<BackCandidate> getCandidateList(){
        return candidateList;
    }

    public void setCandidateList(BackCandidate candidate){
        candidateList.add(candidate);
    }

    public File getChosenFile(){
        return chosenFile;
    }

    public void setChosenFile(File chosenFile){
        this.chosenFile = chosenFile;
    }





    /**
     * addCVFile handles logic for rendering the addCVFile page.
     * @param cardLayout This stores the data rendered as a cardLayout.
     * @param cardPanel This is the panel where cardLayout is added.
     * @return addCVPanel This is the panel which all components are added to.
     * */
    public static JPanel addCVFile(JPanel cardPanel, CardLayout cardLayout){
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
        JLabel chosenFileDisplay = new JLabel();
        chosenFileDisplay.setText("(Select a File)");
        JButton openFileExplorer = new JButton(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2D.setColor(new Color(85,85,85));
                graphics2D.fillRoundRect(0,0, getWidth(), getHeight(), 20,20);
                super.paintComponent(g);
            }
        };
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
        pageTitle.setText("Add a CV");
        pageTitle.setVisible(true);
        pageTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        pageTitle.setForeground(new Color(255,255,255));
        pageTitle.setFont(font.fontTitle());

        // Defining attributes for openFileExplorer
        openFileExplorer.setBorder(BorderFactory.createEmptyBorder(16,25,15,15));
        openFileExplorer.setForeground(new Color(255, 255, 255));
        openFileExplorer.setAlignmentX(Component.CENTER_ALIGNMENT);
        openFileExplorer.setContentAreaFilled(false);
        openFileExplorer.setFocusPainted(false);
        openFileExplorer.setText("Choose File");
        openFileExplorer.setFont(font.fontElements());

        // Defining attributes for chosenFileDisplay
        chosenFileDisplay.setPreferredSize(new Dimension(150, 50));
        chosenFileDisplay.setFont(font.fontElements());
        chosenFileDisplay.setForeground(new Color(255,255,255));
        chosenFileDisplay.setBorder(BorderFactory.createEmptyBorder(15,15,15,0));

        FrontAddCVFile frontAddCVFileInstance = new FrontAddCVFile(); // Creating an instance of FrontAddCVFile to then set the chosen file in the setter method.

        openFileExplorer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Adding event handler for clicking the select file button and then selecting a file.
                JFileChooser addCVFile = new JFileChooser();
                addCVFile.setDialogTitle("Choose a File");
                // Setting file types in the filter of user's chosen directory.
                addCVFile.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents (.pdf)", "pdf"));
                addCVFile.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Word Documents (.docx)", "docx"));
                addCVFile.addChoosableFileFilter(new FileNameExtensionFilter("Text File (.txt)", "txt"));

                // sets the chosen file as the path of the file selected by the user if a file is chosen by the user.
                if(addCVFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    frontAddCVFileInstance.setChosenFile(addCVFile.getSelectedFile());
                    chosenFileDisplay.setText(frontAddCVFileInstance.getChosenFile().getName());
                }
            }
        });

        // Defining attributes for submitButton
        submitButton.setText("Submit CV");
        submitButton.setBorder(BorderFactory.createEmptyBorder(15, 15,15,15));
        submitButton.setForeground(new Color(255, 255, 255));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setContentAreaFilled(false);
        submitButton.setFocusPainted(false);
        submitButton.setFont(font.fontElements());
        submitButton.addActionListener(e -> {
            BackCV cvAnalyser = new BackCV();
            FrontRankedList rankedList = new FrontRankedList();

            chosenFileDisplay.setText("(Select a File)");

            frontAddCVFileInstance.setCandidateList(cvAnalyser.cvAnalyserMain(frontAddCVFileInstance.getChosenFile().toString()));

            rankedList.getRankedListArray().clear();

            for (BackCandidate candidate : frontAddCVFileInstance.getCandidateList()){
                rankedList.setRankedListArray(candidate.getCandidateScore().toString(), candidate.getCandidateName(), candidate.getCandidateSkills(), candidate.getCandidateOrganisations(), candidate.getCandidateFile());
            }
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
        // Adding components to selectedFilePanel
        selectedFilePanel.add(openFileExplorer);
        selectedFilePanel.add(chosenFileDisplay);

        // Adding components to elementsPanel
        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(35));
        elementsPanel.add(selectedFilePanel);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(submitButton);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);

        // Adding components to addCVPanel
        addCVPanel.add(elementsPanel);

        return addCVPanel;
    }
}
