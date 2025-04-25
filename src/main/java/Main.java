/*
* SID
* 2407888
*
* GROUP NAME
* JAMH
*
* DEVIATIONS FROM PLAN
* As part of the plan, there wasn't a GUI. I have since added a GUI and therefore, added more code that has wasn't initially planned (mainly within the 'frontend' package).
* This has also had a direct impact on the usage of my planned classes (within the 'backend' package), as it deviates from how they are accessed and utilised.
* I have also taken out the planned KeyboardReader class, as there is a GUI and console input doesn't need to be read.
* There has also been some deviations in method, some class and variable names as I want to ensure clarity, simplicity and modularity throughout the entire program.
* */

import frontend.FrontMainFrame;

/**
 * Main holds the main method.
 * */
public class Main {
    /**
     * main is the entry point to the program.
     * It calls the main frame, so that the panels can be added to the main frame.
     * */
    public static void main(String[] args){
        FrontMainFrame frame = new FrontMainFrame();
        frame.mainFrame();
    }
}
