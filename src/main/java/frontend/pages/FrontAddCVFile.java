package frontend.pages;

import backend.BackCV;
import backend.BackCandidate;
import backend.BackRankedList;
import frontend.FrontFont;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class FrontAddCVFile extends FrontRankedList {

    private ArrayList<BackCandidate> candidateList = new ArrayList<>();
    private ArrayList<Integer> candidateScoreList = new ArrayList<>();

    File chosenFile = null;

    public ArrayList<BackCandidate> getcandidateList(){
        return candidateList;
    }

    public void setcandidateList(BackCandidate candidate){
        candidateList.add(candidate);
    }

    public File getChosenFile(){
        return chosenFile;
    }

    public void setChosenFile(File userSelectedFile){
        chosenFile = userSelectedFile;
    }



    public static JPanel addCVFile(JPanel cardPanel, CardLayout cardLayout){
        // Creating instances of components
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
        //JComboBox fileTypeSelection = new JComboBox();
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

        // Defining attributes for fileTypeSelection
//        fileTypeSelection.addItem("Text File (.txt)");
//        fileTypeSelection.addItem("Microsoft Word Documents (.docx)");
//        fileTypeSelection.addItem("PDF Documents (.pdf)");
//        fileTypeSelection.setBackground(new Color(85,85,85));
//        fileTypeSelection.setForeground(new Color(255,255,255));
//        fileTypeSelection.setOpaque(true);
//        fileTypeSelection.setVisible(true);
//        fileTypeSelection.setFont(font.fontElements());

        // Defining attributes for openFileExplorer
        openFileExplorer.setBorder(BorderFactory.createEmptyBorder(16,25,15,15));
        openFileExplorer.setForeground(new Color(255, 255, 255));
        openFileExplorer.setAlignmentX(Component.CENTER_ALIGNMENT);
        openFileExplorer.setContentAreaFilled(false);
        openFileExplorer.setFocusPainted(false);
        openFileExplorer.setText("Choose File");
        openFileExplorer.setFont(font.fontElements());

        chosenFileDisplay.setPreferredSize(new Dimension(150, 50));
        chosenFileDisplay.setFont(font.fontElements());
        chosenFileDisplay.setForeground(new Color(255,255,255));
        chosenFileDisplay.setBorder(BorderFactory.createEmptyBorder(15,15,15,0));

        FrontAddCVFile frontAddCVFileInstance = new FrontAddCVFile();

        openFileExplorer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser addCVFile = new JFileChooser();
                addCVFile.setDialogTitle("Choose a File");
                addCVFile.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents (.pdf)", "pdf"));
                addCVFile.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Word Documents (.docx)", "docx"));
                addCVFile.addChoosableFileFilter(new FileNameExtensionFilter("Text File (.txt)", "txt"));

                if(addCVFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    frontAddCVFileInstance.setChosenFile(addCVFile.getSelectedFile());
                    chosenFileDisplay.setText(frontAddCVFileInstance.getChosenFile().getName());

                }
            }
        });

        submitButton.setText("Submit CV");
        submitButton.setBorder(BorderFactory.createEmptyBorder(15, 15,15,15));
        submitButton.setForeground(new Color(255, 255, 255));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setContentAreaFilled(false);
        submitButton.setFocusPainted(false);
        submitButton.setFont(font.fontElements());
        submitButton.addActionListener(e -> {
            BackCV cvAnalyser = new BackCV();
            BackRankedList backRankedList = new BackRankedList();
            FrontRankedList frontRankedList = new FrontRankedList();

            chosenFileDisplay.setText("(Select a File)");
            frontAddCVFileInstance.setcandidateList(cvAnalyser.CVAnalyserMain(frontAddCVFileInstance.getChosenFile().toString()));
        });

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

        selectedFilePanel.add(openFileExplorer);
        selectedFilePanel.add(chosenFileDisplay);

        elementsPanel.add(pageTitle);
        elementsPanel.add(Box.createVerticalStrut(35));
        elementsPanel.add(selectedFilePanel);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(submitButton);
        elementsPanel.add(Box.createVerticalStrut(25));
        elementsPanel.add(backButton);

        addCVPanel.add(elementsPanel);

        return addCVPanel;
    }
}
