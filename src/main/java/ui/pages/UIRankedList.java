package ui.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UIRankedList {
    public static JPanel rankedList(){
        JPanel rankedList = new JPanel();

        rankedList.setOpaque(false);
        rankedList.setBorder(new EmptyBorder(30, 30, 30, 30));
        rankedList.add(new JLabel("This is the Add CV Panel"));

        return rankedList;
    }
}
